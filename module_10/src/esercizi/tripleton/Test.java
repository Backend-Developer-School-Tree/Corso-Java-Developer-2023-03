package esercizi.tripleton;

public class Test
{
    public static void main(String[] args)
    {
        // la costruzione a partire dal costruttore non deve essere possibile
        // Tripleton t = new Tripleton();

        Tripleton t1 = Tripleton.getInstance();
        Tripleton t2 = Tripleton.getInstance();
        Tripleton t3 = Tripleton.getInstance();

        // verifichiamo che le prime 3 istanze siano diverse tra loro
        if (t1 == t2 || t1 == t3 || t2 == t3)
            throw new RuntimeException("Le prime 3 istanze non sono diverse tra loro");

        // e che ogni 3 istanze si ripetano invece di generarne di nuove
        for (int i = 0; i < 10; i++)
        {
            Tripleton t = Tripleton.getInstance();
            int ii = (i % 3) + 1;

            if (ii == 1 && t != t1 || ii == 2 && t != t2 || ii == 3 && t != t3)
                throw new RuntimeException("Le istanze non si ripetono correttamente ogni 3");
        }
    }
}
