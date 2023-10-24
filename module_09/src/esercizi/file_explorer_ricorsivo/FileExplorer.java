package esercizi.file_explorer_ricorsivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileExplorer
{
    private final Path path;

    public FileExplorer(String first, String... more) { this(Paths.get(first, more)); }

    public FileExplorer(Path path) { this.path = path; }

    public List<Path> getSubPath() throws IOException { return getSubPath(path); }

    // test_folder --> [folder1, folder2, file1.txt, file2.md]
    public List<Path> getSubPath(Path path) throws IOException { return Files.list(path).toList(); }

    public boolean exists(String filename) throws IOException { return exists(filename, path); }

    public boolean exists(String filename, Path subPath) throws IOException {
        return find(filename, subPath) != null;
    }

    /**
     * Cerca un file all’interno della cartella
     */
    public Path find(String fileName) throws IOException { return find(fileName, path); }

    /**
     * Cerca un file solo all’interno di una sottocartella
     * (es. solo tra quelli interni a /test_folder/folder2/ e sottocartelle)
     */
    public Path find(String fileName, Path subPath) throws IOException {
        // verifichiamo che il sub-path sia effettivamente contenuto nel path del FileExplorer
        if (!subPath.toAbsolutePath().startsWith(path.toAbsolutePath()))
            throw new RuntimeException(subPath.toString() + " is not contained in " + path.getFileName());

        // per ogni sotto-path verifichiamo
        // - se è una directory e proseguiamo la ricorsione,
        // - se è un file se ha il nome che cerchiamo
        for (Path subSubPath : getSubPath(subPath)) {
            if (Files.isDirectory(subSubPath))
                return find(fileName, subSubPath);
            else // if (Files.isRegularFile())
                if (subSubPath.getFileName().toString().equals(fileName))
                    return subSubPath;
        }

        return null;
    }

    /**
     * Cerca all'interno della cartella tutti i file con l'estensione specificata
     */
    public List<Path> findByExtension(String extension) throws IOException { return findByExtensions(List.of(extension)); }

    /**
     * Cerca all'interno della cartella tutti i file con le estensioni specificate
     */
    public List<Path> findByExtensions(List<String> extensions) throws IOException {
        return findByExtensions(extensions, path);
    }

    private List<Path> findByExtensions(List<String> extensions, Path subPath) throws IOException {
        List<Path> results = new ArrayList<>();

        for (Path subSubPath : getSubPath(subPath))
        {
            if (Files.isDirectory(subSubPath))
                results.addAll(findByExtensions(extensions, subSubPath));
            else
                for (String extension : extensions)
                    if (subSubPath.getFileName().toString().endsWith(extension))
                        results.add(subSubPath);
        }

        return results;
    }

    @Override
    // @lombok.SneakyThrows // se avete lombok è preferibile rispetto ad un try-catch "inutile" di questo tipo
    public String toString() {
        try { return path.getFileName().toString() + '\n' + toString(path, 1); }
        catch (IOException e) { e.printStackTrace(); }
        return null;
    }

    private String toString(Path path, int depth) throws IOException {
        StringBuilder sb = new StringBuilder();

        for (Path subPath : getSubPath(path)) { // test_folder --> [folder1, folder2, file1.txt, file2.md]

            sb.append("|-- ".repeat(depth))
                    .append(subPath.getFileName())
                    .append('\n');

            if (Files.isDirectory(subPath))
                sb.append(toString(subPath, depth + 1));
        }

        return sb.toString();
    }

    public void print() throws IOException {
        System.out.println(path.getFileName());
        print(path, 1);
    }

    private void print(Path path, int depth) throws IOException {
        for (Path subPath : Files.list(path).toList()) { // test_folder --> [folder1, folder2, file1.txt, file2.md]
            System.out.println("|-- ".repeat(depth) + subPath.getFileName());

            if (Files.isDirectory(subPath))
                print(subPath, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Path testFolder = Paths.get("module_09", "src", "esercizi", "file_explorer_ricorsivo", "test_folder");

        // FileExplorer fe = new FileExplorer(testFolder);
        FileExplorer fe = new FileExplorer("module_09", "src", "esercizi", "file_explorer_ricorsivo", "test_folder");

        // fe.print();
        System.out.println(fe);

        Path subTestFolder = Paths.get("module_09", "src", "esercizi", "file_explorer_ricorsivo", "test_folder", "folder1");
        // System.out.println(subTestFolder.toAbsolutePath().startsWith(testFolder.toAbsolutePath()));

        System.out.println(fe.exists("file1.txt"));
        System.out.println(fe.exists("file1.txt", Paths.get("module_09", "src", "esercizi", "file_explorer_ricorsivo", "test_folder", "folder1")));

        System.out.println(fe.find("file1.txt"));
        System.out.println(fe.find("file1.txt", Paths.get("module_09", "src", "esercizi", "file_explorer_ricorsivo", "test_folder", "folder1")));

        System.out.println(fe.findByExtension(".txt"));
        System.out.println(fe.findByExtensions(List.of(".txt", ".md")));
    }
}
