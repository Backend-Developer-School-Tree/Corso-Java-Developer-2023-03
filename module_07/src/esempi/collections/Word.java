package module_07.src.esempi.collections;

import java.util.Objects;

public class Word {
    private int id;
    private String word;

    public Word(int i, String word) {
        this.id = i;
        this.word = word;
    }

    // ...

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return id == word1.id && word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word);
    }

    public int getId() { return id; }
    public String getWord() { return word; }
}
