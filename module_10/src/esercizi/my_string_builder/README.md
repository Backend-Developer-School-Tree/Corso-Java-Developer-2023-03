# MyStringBuilder 🛴

Progettare una classe `MyStringBuilder` che consenta di costruire una stringa e di concatenarne altre step-by-step.

Il risultato finale dovrebbe essere analogo al comportamento della classe `StringBuilder` già esistente
([qui](https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html) la documentazione).

```Java
StringBuilder sb = new StringBuilder();

sb.append("Facilissimo")
  .append(" concatenare")
  .append(" stringhe!");

String finalString = sb.toString();

System.out.println(finalString);
```

La classe `MyStringBuilder` dovrà quindi implementare almeno:
- la possibilità di creare un'istanza a partire da una stringa, da un carattere o partendo da zero
- un metodo `append` che consenta di aggiungere una stringa o un carattere all'istanza attuale 
- un metodo `toString` che si occupi di restituire la stringa completa

E consentire la corretta esecuzione del seguente codice:

```Java
MyStringBuilder msb = new MyStringBuilder(); 

msb.append("Facilissimo")
   .append(" concatenare")
   .append(" stringhe!");

String myFinalString = msb.build();

System.out.println(finalString.equals("Facilissimo concatenare stringhe!"));
System.out.println(finalString);
```
