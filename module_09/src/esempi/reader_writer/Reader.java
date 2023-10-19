package esempi.reader_writer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Reader {

    public static void readByScanner(String path) { readByScanner(Paths.get(path)); }

    /**
     * Metodo inefficiente per leggere da file tramite la classe Scanner.
     * In precedenza utilizzata analogamente per leggere input da tastiera.
     *
     * La risorsa aperta (in questo caso l'oggetto scanner)
     * DEVE essere sempre chiuso in un blocco finally per assicurarsi
     * che non rimanga aperta in caso di eccezioni non/mal gestite!
     */
    public static void readByScanner(Path path) {
        Scanner sc = null;
        try {
            // sc = new Scanner(System.in); // input dallo stream della tastiera
            sc = new Scanner(path);         // input dallo stream del file in path
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (sc != null)
                sc.close();
        }
    }

    /**
     * Metodo per leggere da file tramite la classe Scanner,
     * utilizzando try-with-resources per chiudere in automatico l'oggetto scanner senza il blocco finally.
     */
    public static void readByScannerTryWithResources(Path path) throws IOException {
        try (Scanner sc = new Scanner(path)) {
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        }
        catch (IOException e)
        {
            throw new IOException();
        }
    }

    /**
     * Lettura standard da file tramite BufferedReader,
     * con chiusura automatica tramite try-with-resources.
     */
    public static void readByBufferedReader(Path path) {
        // try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {  // pre Java 7
        try (BufferedReader br = Files.newBufferedReader(path)) {                           // post Java 7
            String line;
            // legge una riga del file e passa alla successiva finché ce ne sono da leggere nel file buffer
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lettura di tutto il contenuto di un file senza BufferedReader e necessità di chiudere risorse.
     * Leggere una riga per volta è comunque l'utilizzo più consigliato
     * per non leggere interamente file di grandi dimensioni e caricare troppe informazioni in memoria.
     */
    public static void readAllLines(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        lines.forEach(l -> System.out.println(l));
    }

    public static void main(String[] args) throws IOException {
        // REMINDER: tutti i percorsi sono di default relativi rispetto alla root del progetto
        // sconsigliabile utilizzare "/" per risalire al percorso
        // Path path = Paths.get("module_09/src/esempi/reader_writer/Reader.java");
        // metodo più robusto per generare un percorso ad un file, il compilatore risalirà al separatore corretto in base all'OS
        Path path = Paths.get("module_09", "src", "esempi", "reader_writer", "Reader.java");

        System.out.println(path.toAbsolutePath());

        // readByScanner(path);
        readByBufferedReader(path);
        // readAllLines(path);
    }

}
