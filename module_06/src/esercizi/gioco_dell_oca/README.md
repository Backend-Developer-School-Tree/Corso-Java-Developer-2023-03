# Il Gioco dell'Oca 🛵

Progettare il Gioco dell’Oca modellando:
- Il `Giocatore`, che mantiene l’informazione sulla posizione nel
tabellone e i punti accumulati e implementa il metodo `tiraDadi()`
- Il `Tabellone` come sequenza di caselle costruita a partire da un
intero N e da un elenco di giocatori; la classe dispone
dell’operazione di posizionamento dei giocatori tenendo conto
dell’effetto “gioco dell’oca” in cui, arrivati alla fine, si torna indietro
- Diversi **tipi di caselle** ciascuna con un diverso effetto a seguito del
posizionamento del giocatore su quella casella:
- una `CasellaVuota` (nessun effetto sul giocatore)
- una `CasellaSpostaGiocatore` che sposta il giocatore di x caselle (avanti se x > 0 o indietro se x < 0)
- una `CasellaPunti` che ha l’effetto di far guadagnare o perdere un certo
numero di punti al giocatore
- la classe `GiocoDellOca` che, dato un intero N e dati i giocatori, che
inizializza un tabellone di lunghezza N e implementa il metodo
  `giocaUnTurno()` che fa effettuare una mossa a ognuno dei giocatori
