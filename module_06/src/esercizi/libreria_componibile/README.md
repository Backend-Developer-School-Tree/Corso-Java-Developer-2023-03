# Libreria componibile 🛵

Progettare una libreria componibile, costituita da una serie di scaffali
- Ogni scaffale contiene una sequenza di libri e prevede una capienza
massima
- Un libro è rappresentato dal titolo e dall’autore e dispone di un
metodo letto che restituisce un booleano relativo all'avvenuta lettura
del libro
  - Un libro può essere usato (si modelli con una nuova classe),
  in quanto tale il libro è già stato letto in passato almeno una volta


- Una libreria permette di aggiungere ed eliminare scaffali, di accedere
al k-esimo scaffale e di ottenere il numero di scaffali
- Uno scaffale permette di aggiungere libri, eliminare libri per titolo e
cercare libri per titolo e/o libri non ancora letti
- La libreria inoltre permette di aggiungere un libro nel primo scaffale
libero


- La libreria e gli scaffali devono essere iterabili (implementare l'interfaccia [Iterable](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html))