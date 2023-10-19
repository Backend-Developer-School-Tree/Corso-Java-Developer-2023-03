# File explorer ricorsivo 🏍📁

Si realizzi una classe FileExplorer, costruita a partire dal percorso di una cartella esistente,
dotata di un metodo `toString()` che ne visualizzi ricorsivamente il contenuto.

Esempio di possibile visualizzazione della cartella [test_folder](test_folder):
```
test_folder
|-- file1.txt
|-- file2.md
|-- folder1
|-- |-- file.csv
|-- folder2
|-- |-- file1.md
|-- |-- folder1
|-- |-- |-- file1.txt
|-- |-- |-- file2.txt
|-- |-- |-- file3.csv
```

Realizzare inoltre i seguenti metodi ricorsivi:
- Cerca un file all’interno della cartella
- Cerca un file solo all’interno di una sottocartella (es. solo tra quelli interni a `/test_folder/folder2/` e sottocartelle)
- Cerca all'interno della cartella tutti i file con l'estensione specificata
- Cerca all'interno della cartella tutti i file con le estensioni fornite in input

Nota1: si faccia uso al meglio dell'overloading

Nota2: quando necessario, utilizzare sempre `Paths.get` piuttosto che percorsi "hardcodati" in formato stringa (es. `Paths.get("test_folder", "folder2")` piuttosto che `test_folder/folder2/`)
