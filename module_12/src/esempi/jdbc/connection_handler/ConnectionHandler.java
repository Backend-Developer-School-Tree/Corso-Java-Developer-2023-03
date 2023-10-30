package esempi.jdbc.connection_handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class ConnectionHandler implements AutoCloseable
{
    public static final String DB_URL_PREFIX = "jdbc:";
    /*
    public static final String DB_HOST = "localhost";
    public static final int DB_PORT = 5432;
    ...
    public static final String username = "postgres";
     */

    public static final Path PROPERTIES_PATH = Paths.get("module_12", "src", "esempi", "jdbc", "resources", "postgres.properties");

    // TODO: valutare se implementare pattern Singleton
    // private static ConnectionHandler instance;

    private Connection connection;
    private Properties dbProps;

    public ConnectionHandler() throws IOException {
        try (BufferedReader br = Files.newBufferedReader(PROPERTIES_PATH)) {
            dbProps = new Properties();
            dbProps.load(br);
        }

        // dbProperties.setProperty("host", DB_HOST);
        // dbProperties.setProperty("port", DB_PORT);
        // ...

        System.out.println("JDBC driver name: " + dbProps.getProperty("driver"));
        System.out.println("Host name: "        + dbProps.getProperty("host") + ":" + dbProps.getProperty("port"));
        System.out.println("Database name: "    + dbProps.getProperty("name"));
        System.out.println("DB username: "      + dbProps.getProperty("user"));
        System.out.println("DB password: "      + dbProps.getProperty("password"));

        // <-------------- Carichiamo il driver JDBC in memoria -------------------->

        // strettamente necessario fino a Java 1.6
        // dalle versioni successive il caricamento del driver viene fatto implicitamente a runtime
        // https://jdbc.postgresql.org/documentation/use/#loading-the-driver
        // Class.forName("org.postgresql.Driver");
    }

    // "jdbc:postgresql://localhost:5432/AndiamoATeatro"
    private String getDbUrl() {
        return DB_URL_PREFIX +
                dbProps.getProperty("driver") + "://" +
                dbProps.getProperty("host") + ":" +
                dbProps.getProperty("port") + "/" +
                dbProps.getProperty("name");
    }

    // utilizzare SOLO questo metodo getConnection ci garantisce di utilizzare sempre e sola una connessione unica al DB
    // non rischiamo di crearne N che possano farlo crashare ad esempio
    private Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            // se la connessione non esiste o è stata chiusa, ne creiamo una nuova
            connection = DriverManager.getConnection(getDbUrl(), dbProps);

        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }

    @Override
    public void close() throws SQLException { closeConnection(); }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        // utilizziamo il metodo getConnection per assicurarci che la connessione non venga duplicata
        // e garantire che la connection esista e sia attiva (sempre)
        Connection conn = getConnection();

        return conn.prepareStatement(sql);
    }

    public static void main(String[] args) throws Exception {
        // gestiamo in maniera strutturata apertura/chiusura della connessione con il DB, garantendone l'univocità
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement("SELECT * FROM utente;");
        ResultSet rs = ps.executeQuery();
        // while (rs.next()) System.out.println(rs.getString("nome"));

        ch.closeConnection();
        ps.close();
        rs.close();

        // <---------------- implementando l'interfaccia AutoClosable ------------------>

        // possiamo chiudere il tutto (PreparedStatement, ResultSet e Connection) anche tramite try-with-resources
        try (ConnectionHandler ch2 = new ConnectionHandler();
             PreparedStatement ps2 = ch2.getPreparedStatement("SELECT * FROM utente;");
             ResultSet rs2 = ps2.executeQuery())
        {
            while (rs2.next()) System.out.println(rs2.getString("nome"));
        }
        /*
        // la chiusura manuale di ogni risorsa aperta non è più necessaria (che andrebbe fatta in un finally)
        finally {
            ch2.closeConnection();
            ps2.close();
            rs2.close();
        }
         */
    }
}
