## Sequenza iterabile 🛴

Progettare un'interfaccia `Iterabile` che definisce i seguenti metodi:
* `Object next()`         per permettere di ottenere il prossimo elemento e scorrere la sequenza
* `boolean hasNext()`     per indicare se è presente un prossimo elemento nella sequenza
* `void reset()`          per resettare l'iterazione (torna all'inizio)

Progettare un'interfaccia `Sequenza` che definisce i seguenti metodi:
* `get(int i)` che restituisce l'elemento alla posizione i della sequenza
* `contains(Object o)` che restituisce true se l'elemento è presente nella sequenza
* `size()` che restituisce quanti elementi sono presenti all'interno della sequenza
* `add(Object o)` che aggiunge un elemento alla sequenza
* `remove(int i)` che rimuove l'elemento alla posizione i della sequenza, torna true se l'elemento è stato rimosso, false se non l'ha trovato
* `clear()` rimuove tutti gli elementi dalla sequenza

Progettare due classi `ListaDiInteri` (potete basarvi sull'esercizio [ListaDiInteri](../../../../module_04/src/esercizi/lista_di_interi/))
e `MiaStringa` (costruita a partire da una stringa).
Entrambe le classi devono implementare i metodi dell'interfaccia `Iterabile` e dell'interfaccia `Sequenza`
(considerate una stringa come una sequenza di char).

Le classi [`TestIterabile`](TestIterabile.java) e [`TestSequenza`](TestSequenza.java) contengono del codice di test per
verificare le funzioni.

**Nota:** per semplicità stiamo utilizzando la classe `Object` per consentire alle interfacce di essere utilizzate sia con
stringhe che con interi (che con qualunque altro tipo). Questo andrebbe in realtà fatto utilizzando i Generics
(come succede per l'interfaccia [Iterable di Java](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)),
che però vedremo nei prossimi moduli (che una volta spiegati potrete utilizzare per completare l'esercizio!)