package intrusi;

public class Intrusi {

    /*
    Date tre stringhe s1, s2 e s3 in input, stampare s3 dopo aver rimpiazzato,
    all’interno di s3, ogni occorrenza compresa tra due spazi di s1 con s2.
    Ad esempio, date in input le stringhe «a», «b», «a abc d», stampare a video
    «a bbc d». Potete dare per assunto  che la stringa c conterrà sempre e
    solo due spazi.
     */
    public static void intrusi(String s1, String s2, String s3) {
        String[] s3_splitted = s3.split(" ");
        // la parte centrale di s3 ha indice 1
        String parola_centrale = s3_splitted[1].replace(s1, s2);
        String result = s3_splitted[0] + " " + parola_centrale + " " + s3_splitted[2];
        System.out.println("La stringa risultante è: " + result);
    }

}
