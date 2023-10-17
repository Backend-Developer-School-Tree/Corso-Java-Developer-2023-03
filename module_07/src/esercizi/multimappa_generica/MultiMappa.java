package module_07.src.esercizi.multimappa_generica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MultiMappa<K, V> implements Iterable<MultiMappa.Elemento<K, V>>
{
    private final Map<K, List<V>> map = new HashMap<>();

    public void put(K key, V value) {
        /*
        // senza metodo merge // paradigma imperativo
        List<V> list = new ArrayList<>();

        if (map.containsKey(key)) list = map.get(key);

        list.add(value);
        map.put(key, list);
         */

        /*
        // con metodo merge // paradigma funzionale
        map.merge(key, Arrays.asList(value), (l1, l2) -> {
            l1.addAll(l2);
            return l1;
        });
         */

        putAll(key, Arrays.asList(value));
    }

    public void putAll(K key, List<V> values) {
        map.merge(key, values, (l1, l2) -> {
            l1.addAll(l2);
            return l1;
        });
    }

    public void putAll(MultiMappa<K, V> multiMappa) {
        // for (Elemento<K, V> kvElemento : multiMappa) putAll(kvElemento.getKey(), kvElemento.getValues());
        multiMappa.forEach(kvElemento -> putAll(kvElemento.key, kvElemento.values));
    }

    public void removeAll(MultiMappa<K, V> multiMappa) {
        // TODO
    }

    public List<V> get(K key) { return map.getOrDefault(key, new ArrayList<>()); }

    public List<V> get(K key, Predicate<V> predicate) {
        List<V> valoriCheSoddisfano = new ArrayList<>();

        for (V v : get(key)) {
            if (predicate.test(v)) valoriCheSoddisfano.add(v);
        }

        return valoriCheSoddisfano;

        /*
        // soluzione con gli stream (argomento del modulo 12)
        return get(key).stream()
                .filter(predicate)
                .collect(Collectors.toList());
         */
    }

    public Set<K> keySet() { return map.keySet(); }

    public List<V> values() {
        List<V> list = new ArrayList<>();
        // for (List<V> values : map.values()) list.addAll(values);
        map.values().forEach(list::addAll);
        return list;
    }

    public List<V> values(Comparator<V> cmp) {
        List<V> list = values();
        list.sort(cmp);
        return list;
    }

    public Set<V> valueSet() { return new HashSet<>(values()); }

    public <Z> MultiMappa<K, Z> transformToMultiMappa(Function<Elemento<K, V>, List<Z>> mappingFunction) {
        MultiMappa<K, Z> multiMappa = new MultiMappa<>();
        for (Elemento<K, V> coppia : this) {
            List<Z> values = mappingFunction.apply(coppia);
            multiMappa.putAll(coppia.key, values);
        }
        return multiMappa;
    }

    public void mapEach(Function<Elemento<K, V>, List<V>> mappingFunction) {
        // for (Elemento<K, V> coppia : this) map.put(coppia.key, mappingFunction.apply(coppia));
        this.forEach(coppia -> map.put(coppia.key, mappingFunction.apply(coppia)));
    }

    @Override
    public String toString() { return map.toString(); }

    @Override
    public Iterator<Elemento<K, V>> iterator() {
        return new Iterator<Elemento<K, V>>() {
            private final Iterator<K> keysIterator = map.keySet().iterator();

            @Override
            public boolean hasNext() {
                return keysIterator.hasNext();
            }

            @Override
            public Elemento<K, V> next() {
                K key = keysIterator.next();
                return new Elemento<K, V>(key, get(key));
            }
        };
    }

    /*
    @Getter
    @Setter
    @AllArgsConstructor
    protected static class Elemento<K, V> {
        private final K key;
        private List<V> values;
    }
     */

    protected static class Elemento<K, V> {

        private K key;
        private List<V> values;

        public Elemento(K key, List<V> values) {
            this.key = key;
            this.values = values;
        }

        public K getKey() {
            return key;
        }

        public List<V> getValues() {
            return values;
        }

        public List<V> setValues(List<V> values) {
            this.values = values;
            return this.values;
        }
    }

    public static void main(String[] args) {
        MultiMappa<Integer, Integer> mm = new MultiMappa<>();
        mm.putAll(1, Arrays.asList(1,2,3,4,5,6,7,8,9));
        System.out.println(mm.get(1));
        System.out.println(mm.get(1, v -> v > 5));

        System.out.println(mm);
        mm.mapEach(coppia -> coppia.values.stream().map(v -> v * 2).collect(Collectors.toList()));
        System.out.println(mm);
    }
}
