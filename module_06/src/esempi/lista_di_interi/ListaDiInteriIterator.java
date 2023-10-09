package esempi.lista_di_interi;

import java.util.Iterator;

public class ListaDiInteriIterator implements Iterator<Integer> {

    int index = 0;
    ListaDiInteri lista;

    ListaDiInteriIterator(ListaDiInteri lista) {
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return index != lista.length();
    }

    @Override
    public Integer next() {
        return lista.get(index++);
    }
}
