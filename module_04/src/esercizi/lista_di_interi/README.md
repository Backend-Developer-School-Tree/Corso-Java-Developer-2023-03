# ListaDiInteri 🛵

Vogliamo creare una lista dinamica di interi, che quindi non abbia una dimensione fissa e in cui possiamo inserire
quanti elementi vogliamo (potenzialmente infiniti), risolvendo le limitazioni dell'array standard.
Implementare quindi una classe ListaDiInteri che preveda almeno i seguenti metodi:
- `get(int i)` restituisce l’elemento i-esimo della lista
- `indexOf(int i)` restituisce l’indice della posizione dell’intero fornito in input
- `toString()` restituisce una stringa formattata contenente la lista di interi
- `length()` restituisce la dimensione della lista
- `contains(int i)` contiene un determinato intero (true o false)?
- `add(int i)` aggiungi un intero in coda alla lista

Main di test:

```java
public class Main {
    public static void main(String[] args) {
        ListaDiInteri lista = new ListaDiInteri();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        System.out.println(lista.length());
        System.out.println(lista.toString());
        System.out.println(lista.contains(3));
        System.out.println(lista.get(2));
        System.out.println(lista.indexOf(3));
    }
}
```

## Bonus stage 🏍

Implementare anche le seguenti funzionalità:
- Aggiungi un intero nella posizione specificata
- Elimina la prima occorrenza di un intero dalla lista
- Elimina l’elemento i-esimo della lista

**Nota: attenzione a shiftare gli altri elementi a seguito di queste operazioni!**