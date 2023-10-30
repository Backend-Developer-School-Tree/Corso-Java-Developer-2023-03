package esempi.jdbc;

import esempi.jdbc.dao.User;

import java.sql.*;
import java.util.Properties;

public class DatabaseConnection
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // <-------------- Carichiamo il driver JDBC in memoria -------------------->

        // strettamente necessario fino a Java 1.6
        // dalle versioni successive il caricamento del driver viene fatto implicitamente a runtime
        // https://jdbc.postgresql.org/documentation/use/#loading-the-driver
        // Class.forName("org.postgresql.Driver");

        // <-------------- Creiamo una connessione con il DB -------------------->

        String username = "postgres";
        String password = "postgres";
        Connection conn;

        // 1. specificando tutti i parametri nell'url
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AndiamoATeatro?user=" + username + "&password=" + password);

        // 2. specificando username e password come parametri
        // eventuali altri parametri andranno passati comunque all'interno dell'url (o tramite properties)
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AndiamoATeatro", username, password);

        // 3. utilizziamo un oggetto Properties
        Properties props = new Properties(); // essenzialmente funziona come una mappa proprietà --> valore associato
        props.setProperty("user", username);
        props.setProperty("password", password);
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AndiamoATeatro", props);

        // 4. caricare le properties da un file
        // props.load();

        // <-------------- Creare uno statement per eseguire istruzioni SQL  -------------------->

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM utente;");

        // <-------------- Eseguiamo le istruzioni SQL  -------------------->

        ResultSet rs = statement.executeQuery();
        while(rs.next()) { System.out.println(rs.getString("nome")); }

        // <-------------- Chiudiamo la connessione e rilasciamo le risorse  -------------------->

        conn.close();
        rs.close();
        statement.close();


        // ******************** ESEMPI QUERY *****************

        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AndiamoATeatro", username, password);
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente;");
        rs = ps.executeQuery();

        while(rs.next()) {
            int id = rs.getInt(1);              //("id");
            String nome = rs.getString(2);      //("nome");
            String cognome = rs.getString(3);   //("cognome");
            User user = new User(id, nome, cognome);

            // in maniera più strutturata potremmo creare un metodo statico ad hoc (che fa la stessa cosa)
            // User user = User.getFromResultSet(rs);
        }
    }
}
