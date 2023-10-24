package esercizi.righe_inverse;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InvertiRighe
{
    private List<String> lines = new ArrayList<>();
    private Path srcPath;
    private Path toPath;

    public InvertiRighe(Path srcPath) throws IOException {
        this.srcPath = srcPath;
        setInversedFileName();
        this.lines = Files.readAllLines(srcPath);
    }

    private void setInversedFileName() {
        // "righe.txt"
        String fileName = this.srcPath.getFileName().toString();
        // "module_09/src/esercizi/righe_inverse
        Path parentDirectory = this.srcPath.getParent();
        // "righe.txt" --> "righe_inversed.txt"
        String inversedFileName = fileName.replace(".txt", "_inversed.txt");
        // "module_09/src/esercizi/righe_inverse/righe_inversed.txt"
        this.toPath = parentDirectory.resolve(inversedFileName);
    }

    private void writeLines() throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(toPath)) {
            // for (int i = lines.size()-1; i >= 0; i--) {
            for (int i = 0; i < lines.size(); i++) {
                bw.write(lines.get(lines.size()-i-1));
                bw.newLine();
            }
        }

        // senza try-with-resources va chiuso sempre il buffer
        // bw.close();
    }

    public void invertLines() throws IOException { writeLines(); }

    public static void main(String[] args) throws IOException {
        InvertiRighe ir = new InvertiRighe(Paths.get("module_09", "src", "esercizi", "righe_inverse", "righe.txt"));
        ir.invertLines();

        Path path = Paths.get("module_09", "src", "esercizi", "righe_inverse", "righe.txt");
        System.out.println(path);
        System.out.println(path.getParent());
    }
}
