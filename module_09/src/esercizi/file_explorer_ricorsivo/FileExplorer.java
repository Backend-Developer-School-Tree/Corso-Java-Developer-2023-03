package esercizi.file_explorer_ricorsivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExplorer {
    private final Path path;

    public FileExplorer(String first, String... more) {
        this(Paths.get(first, more));
    }

    public FileExplorer(Path path) {
        this.path = path;
    }

    public Path getPath() { return path; }

    @Override
    @lombok.SneakyThrows
    public String toString() {
        return path.getFileName() + "\n" + toString(path, 1);
    }

    private String toString(Path path, int depth) throws IOException {
        StringBuilder sb = new StringBuilder();

        for (Path path1 : Files.list(path).toList()) {
            sb.append("|-- ".repeat(depth));
            sb.append(path1.getFileName());
            sb.append("\n");

            if (Files.isDirectory(path1))
                sb.append(toString(path1, depth + 1));
        }

        return sb.toString();
    }

    public void print() throws IOException {
        System.out.println(path.getFileName());
        print(path, 1);
    }

    private void print(Path path, int depth) throws IOException {
        for (Path path1 : Files.list(path).toList()) {
            System.out.println("|-- ".repeat(depth) + path1.getFileName());

            if (Files.isDirectory(path1))
                print(path1, depth + 1);
        }
    }

    /**
     * Cerca un file all’interno della cartella
     */
    public Path find(String fileName) throws IOException {
        return find(fileName, path);
    }

    /**
     * Cerca un file solo all’interno di una sottocartella
     * (es. solo tra quelli interni a /test_folder/folder2/ e sottocartelle)
     */
    private Path find(String fileName, Path path) throws IOException {

        for (Path path1 : Files.list(path).toList()) {
            if (Files.isDirectory(path1))
                return find(fileName, path1);
            else if (Files.isRegularFile(path1))
                if (path1.getFileName().toString().equals(fileName))
                    return path1;
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        FileExplorer explorer = new FileExplorer("module_09", "src", "esercizi", "file_explorer_ricorsivo", "test_folder");
        explorer.print();
        System.out.println(explorer);

        System.out.println(explorer.find("file1.txt"));

        Path subdir = explorer.getPath().resolve("folder2");
        System.out.println(explorer.find("file1.txt", subdir));
    }
}
