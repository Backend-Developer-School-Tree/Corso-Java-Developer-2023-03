Progettare una classe Lampadina che rappresenti una lampadina elettrica
La lampadina può essere accesa, spenta o rotta
Espone due metodi
stato() che indica lo stato corrente della lampadina
click() che cambia lo stato da accesa a spenta o da spenta ad accesa, oppure rompe la lampadina
Una lampadina si rompe dopo un numero di click definito dal produttore
La classe deve contenere uno o più campi che ne descrivano lo stato, un costruttore
e i metodi indicati sopra

PARTE 2
Progettare una classe Interruttore che rappresenta un interruttore per la lampadina fatta precedentemente

Ogni interruttore è collegato ad una lampadina e ne regola accensione e spegnimento

Definite quali campi, metodi e costruttori siano opportuni

Creare un metodo di test che istanzia due interruttori e li collega alla stessa 
lampadina e poi offre all’utente ripetutamente la possibilità di 
clickare uno dei due interruttori oppure di terminare l’esecuzione

PARTE 3
Modificare la classe Lampadina facendo in modo che tutte le lampadine 
condividano l’informazione sulla presenza di corrente all’interno dell’impianto 
(immaginate che tutte le lampadine siano collegate allo stesso impianto di 
corrente)

Le lampadine devono comportarsi coerentemente con la presenza o meno di 
elettricità nell’impianto

Quindi quando non c’è corrente una lampadina può essere soltanto nello stato 
«spento» o «rotto»

Scrivere un metodo di test che testi la funzione di ’’staccare’’ o ‘’riattaccare’’ 
la corrente