# Conto bancario 🛵

Progettare la classe `ContoBancario` che rappresenti un
conto con informazioni relative al denaro attualmente
disponibile, il codice IBAN e la lista delle operazioni svolte sul conto.

- Modellare quindi una generica operazione bancaria
  `Operazione` che disponga di un metodo `esegui()`
- Modellare quindi i seguenti tipi di operazione:
  - `Prelievo`: preleva una specificata quantità di denaro da un
  dato conto
  - `SvuotaConto`: preleva tutto il denaro da un dato conto
  - `Versamento`: versa del denaro sul conto specificato
  - `Situazione`: stampa l’attuale saldo del conto
  - `Bonifico`: preleva del denaro da un conto e lo versa su un altro

Prevedere le seguenti funzionalità per la classe `ContoBancario`:
- dei metodi per svolgere ogni operazione esistente
- un metodo che restituisca l'elenco delle operazioni svolte in ordine temporale
- un metodo `eseguiOperazioni` che prende in input una lista di operazioni e le esegue tutte