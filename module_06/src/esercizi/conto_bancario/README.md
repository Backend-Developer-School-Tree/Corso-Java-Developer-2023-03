# Conto bancario 🛵

Progettare la classe `ContoBancario` che rappresenti un
conto con informazioni relative al denaro attualmente
disponibile, il codice IBAN.

- Modellare quindi una generica operazione bancaria
  `Operazione` che disponga di un metodo `esegui()`
- Modellare quindi i seguenti tipi di operazione:
  - `PrelevaDenaro`: preleva una specificata quantità di denaro da un
  dato conto
  - `SvuotaConto`: preleva tutto il denaro da un dato conto
  - `VersaDenaro`: versa del denaro sul conto specificato
  - `SituazioneConto`: stampa l’attuale saldo del conto
  - `Bonifico`: preleva del denaro da un conto e lo versa su un altro
- Specificare un metodo nella classe `ContoBancario` che
restituisca l'elenco delle operazioni svolte in ordine temporale


- Prevedere la possibilità di iterare il conto bancario sulle operazioni