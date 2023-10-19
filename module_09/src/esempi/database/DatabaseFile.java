package esempi.database;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DatabaseFile extends Database {

    private Map<Integer, Utente> utenti = new HashMap<>();

    private Path pathFileUtenti;

    // public DatabaseFile(Path pathFileUtenti, Path pathFileVeicoli) throws IOException {
    public DatabaseFile(Path pathFileUtenti) throws IOException {
        this.pathFileUtenti = pathFileUtenti;
        this.readUtenti();
    }

    private void readUtenti() throws IOException {
        List<String> utentiString = Files.readAllLines(pathFileUtenti);

        for (String s : utentiString) {
            Utente utente = Utente.readByCsv(s);
            utenti.put(utente.id(), utente);
        }
    }

    // da utilizzare al termine di ogni operazione di modifica o inserimento o eliminazione
    private void saveFileUtenti() throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(pathFileUtenti);

        for (Utente utente : utenti.values()) {
            // bw.write(utente.id() + "," + utente.nome());
            bw.write(utente.toCsv());
            bw.newLine();
        }

        bw.close();
    }

    @Override
    void inserisciUtente(Utente u) {
        utenti.put(u.id(), u);
        try {
            saveFileUtenti();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    Collection<Utente> getUtenti() {
        return utenti.values();
    }

    @Override
    Utente getUtente(int id) {
        return utenti.get(id);
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("module_09", "src", "esempi", "database", "utenti.csv");
        System.out.println(Files.readAllLines(path)); // ["1,andrea", "2,davide", "3,marco"]

        Database db = new DatabaseFile(path);
        System.out.println(db.getUtenti());
        System.out.println(db.getUtente(1));

        db.inserisciUtente(new Utente(4, "Stefano"));
        System.out.println(db.getUtenti());
        System.out.println(Files.readAllLines(path)); // ["1,andrea", "2,davide", "3,marco", "4,Stefano"]
    }
}
