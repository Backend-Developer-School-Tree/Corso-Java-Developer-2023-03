package esempi.reader_writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Writer {

    /**
     * Scrittura su file tramite BufferedWriter,
     * con chiusura automatica tramite try-with-resources.
     *
     * Il comportamento di default è quello di sovrascrivere il file se già esistente, o di crearlo altrimenti.
     */
    public static void writeLine(Path path, String lineToWrite) {
        // try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toString())))    // pre Java 7
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {                           // post Java 7
            bw.write(lineToWrite);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // se dobbiamo scrivere più di una riga non è assolutamente efficiente chiamare più volte writeLine in un for
    // in quanto per ogni stringa da inserire aprirebbe e chiuderebbe ogni volta il file
    // molto più efficiente quindi aprirlo una sola volta e inserire le stringhe con un for successivamente
    public static void writeLines(Path path, List<String> linesToWrite) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {

            for (String s : linesToWrite) {
                bw.write(s);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Scrittura su file tramite BufferedWriter in modalità append,
     * ovvero senza sovrascrivere il file ma aggiungendo in coda.
     *
     * Altre opzioni di apertura file sono disponibili nell'enum java.nio.file.StandardOpenOption.
     */
    public static void appendLine(Path path, String lineToAppend) {
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {

            bw.write(lineToAppend);
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("module_09", "src", "esempi", "reader_writer", "test.txt");
        writeLine(path, "new test");
        appendLine(path, "new append test");
    }

}
