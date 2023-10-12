Esercizi dei precedenti moduli da poter riprendere per esercitarsi con i generici:

- [ListaDiInteri](module_04/src/esercizi/lista_di_interi) rendere la classe generica su un tipo `T` piuttosto che sui soli interi, così che invece di istanziarla così: `ListaDiInteri lista = new ListaDiInteri();`
  si possa istanziare analogamente a come facciamo per le collection di Java:
```Java
Lista<Integer> lista = new Lista<>();
// analogo a ArrayList<Integer> lista = new ArrayList<>();
Lista<String> lista = new Lista<>();
Lista<Libro> lista = new Lista<>();
// ...
```

- [Sequenza Iterabile](module_06/src/esercizi/sequenza_iterabile) rendere le due interfacce `Iterabile` e `Sequenza` generiche, così da poter sostituire l'utilizzo della classe `Object` nei vari tipi di ritorno e parametri (utilizzare Object come avevamo fatto per questo esercizio è infatti il più possibile da evitare in favore dei generici)