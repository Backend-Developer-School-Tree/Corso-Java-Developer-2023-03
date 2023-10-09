package esempi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class EsempiListe {
    public static void main(String[] args) {
        Integer[] array = new Integer[] {6,7};

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);

        list.get(0); // array[0]

        List<Integer> list2 = Arrays.asList(array); // da array a lista

        list.addAll(list2); // [1, 5] + [6, 7] = [1, 5, 6, 7]

        list.indexOf(1);

        list.remove(1);

        list.size(); // array.length

        list.contains(1);
        list.containsAll(list2);

        System.out.println(list.containsAll(list2));

        for (Integer integer : list) {
            System.out.println(integer);
        }

        // analogo a usare direttamente l'iterator

        Iterator<Integer> iter = list.iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
