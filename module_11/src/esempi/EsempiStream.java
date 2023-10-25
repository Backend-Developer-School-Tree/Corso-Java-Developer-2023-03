package esempi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EsempiStream {

    public static void main(String[] args){
        System.out.println("***** ESEMPI STREAM *****");

        List<Integer> numeri = new ArrayList<>();
        numeri.add(5);
        numeri.add(8);
        numeri.add(12);
        numeri.add(0);
        numeri.add(-1);

        // Voglio contare solo i numeri maggiori di 0
        int conteggioImperativo = 0;
        for(Integer n : numeri){
            if(n>0)
                conteggioImperativo++;
        }
        System.out.println(conteggioImperativo);

        long conteggioDichiarativo = numeri.stream().filter(n -> n>0).count();
        System.out.println(conteggioDichiarativo);

        // Stampare tutte le stringhe di un array
        String[] parole = {"Java","JavaScript","PHP","Python"};
        Arrays.stream(parole).forEach(System.out::println);

        // Massimo di un array. Nota il metodo max torna una classe Optional,
        // con il metodo get() prendo il valore dentro l'Optional
        int numeroMassimo = numeri.stream().max(Integer::compare).get();
        System.out.println(numeroMassimo);

    }
}
