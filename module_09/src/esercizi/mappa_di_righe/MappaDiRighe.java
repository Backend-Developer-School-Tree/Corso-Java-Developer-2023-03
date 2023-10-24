package esercizi.mappa_di_righe;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MappaDiRighe
{
    private Map<String, List<String>> map = new HashMap<>();
    private Path path;

    public MappaDiRighe(Path path) throws IOException {
        this.path = path;
        readLines();
    }

    public void readLines() throws IOException {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] keyValues = line.split(":");

                String[] values = keyValues[1].split(",");

                // attenzione perché List.of genera una lista non modificabile
                // (che solleva un eccezione nel caso ci provassimo)
                // map.put(key, List.of(values));
                map.put(keyValues[0], Arrays.asList(values));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        MappaDiRighe mdr = new MappaDiRighe(Paths.get("module_09", "src", "esercizi", "mappa_di_righe", "righe.txt"));
        System.out.println(mdr.map);
    }
}
