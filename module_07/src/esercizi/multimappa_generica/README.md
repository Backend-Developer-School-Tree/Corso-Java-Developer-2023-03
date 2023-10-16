# Multimappa generica 🏍
Una multimappa è una mappa che permette di memorizzare più valori (dello stesso tipo) a fronte di una data
chiave. Creare una classe `MultiMappa` generica sul tipo di chiavi e valori.

La classe deve implementare le seguenti funzionalità:
- `put(k, v)` che associa il valore alla chiave specificata (suggerimento: vedere metodo `merge`)
- `putAll(MultiMappa m)` che aggiunge tutti gli elementi della multimappa in input alla mappa corrente
- `removeAll(MultiMappa m)` che rimuove tutte le chiavi della multimappa in input dalla mappa corrente
- `get(k)` che restituisce l'insieme dei valori associati alla chiave (suggerimento: vedere metodo `getOrDefault`)
- `get(k, p)` come `get(k)` ma restituisce solo i valori che soddisfano il predicato p
- `keySet()` che resituisce l'insieme delle chiavi contenute nella mappa
- `values()` che restituisce l'elenco (con duplicati) dei valori contenuti nella multimappa
- `values(cmp)`che restituisce i valori ordinati secondo il metodo di comparazione passato in input
- `valueSet()` che restituisce l'insieme dei valori contenuti nella multimappa
- `transformToMultiMappa(f)` che restituisce una multimappa in cui le coppie (k, v) sono trasformate in (k, z)
secondo una funzione (k, v) -> z (z può essere di tipo diverso rispetto a quello di v)
- `mapEach(f)` che sostituisce ciascun valore v con un valore dello stesso tipo secondo una funzione (k, v) -> v'
- la classe deve essere iterabile sulle coppie (k, v) mediante una classe interna `Elemento`

Utilizzare funzioni lambda **e riferimenti a metodo** dove possibile.
