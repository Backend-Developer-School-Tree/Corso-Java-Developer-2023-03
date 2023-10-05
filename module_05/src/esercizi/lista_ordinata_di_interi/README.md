# Lista di interi ordinata

A partire dalla classe dell'esercizio [ListaDiInteri](https://github.com/Backend-Developer-School-Tree/Corso-Java-Developer-2023-02/tree/main/module_04/src/lista_di_interi), implementare una classe `ListaOrdinataDiInteri` per creare liste di
interi ordinati in modo crescente. La classe ridefinisce i seguenti 3
metodi di aggiunta:
- `add(k)` aggiunge un intero: l'intero viene inserito nella posizione
appropriata, in modo da preservare l'ordine degli interi della lista
- `add(k, j)` aggiunge un intero nella posizione specificata: come sopra,
l'aggiunta avviene solo se l'intero preserva l'ordine degli interi della lista
- `addLast(k)` aggiunge un intero in coda alla lista: l'aggiunta avviene solo
se l'intero preserva l'ordine della lista

L'array non deve essere ordinato con metodi di sorting, quali `Arrays.sort`
(né vostri metodi di sorting *completo* dell'array)

**Extra**: permettere di specificare un parametro da passare
opzionalmente al costruttore di `ListaOrdinataDiInteri` per stabilire l'ordine
della lista (crescente o decrescente; per default, crescente)
