package module_07.src.esercizi.pila;

import java.util.ArrayList;
import java.util.List;

public class Pila<T> {

    private List<T> elements = new ArrayList<>();
    private Integer dimensioneMassima = null;

    public Pila() {}

    // public Pila(T... elements)

    // public Pila(T... elements, int dimensioneMassima)

    public Pila(int dimensioneMassima) { this.dimensioneMassima = dimensioneMassima; }

    private boolean isFull() { return dimensioneMassima != null && size() >= dimensioneMassima; }

    public boolean isEmpty() { return size() == 0; }

    public boolean push(T element) {
        if (isFull()) return false;
        return elements.add(element);
    }

    public T pop() { return elements.remove(size()-1); }

    public T peek() { return elements.get(size()-1); }

    public int size() { return elements.size(); }

}
