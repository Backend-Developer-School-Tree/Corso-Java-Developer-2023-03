package module_07.src.esercizi.inverti_lista_massimo;

import java.util.ArrayList;
import java.util.List;

public class InvertiListaMassimo {

    /**
     * Data in input una lista di elementi di tipo generico
     * ritorna un'altra lista con gli elementi in ordine invertito
     */
    public static <T> List<T> inverti(List<T> lista) {
        List<T> listaInvertita = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            listaInvertita.add(lista.get(lista.size()-1-i));
        }
        return listaInvertita;
    }

    /**
     * Data in input una lista di elementi di tipo generico ne ritorna il valore massimo
     */
    public static <T extends Comparable<T>> T max(List<T> lista) {
        T max = null;
        for (T t : lista) {
            if (max == null || t.compareTo(max) > 0)
                max = t;
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> listaDiInteri = new ArrayList<>(List.of(1,2,3,4));
        List<String> listaDiStringhe = List.of("uno", "due", "tre", "quattro");

        System.out.println(inverti(listaDiInteri));
        System.out.println(inverti(listaDiStringhe));

        System.out.println(max(listaDiInteri));
        System.out.println(max(listaDiStringhe));
    }
}
