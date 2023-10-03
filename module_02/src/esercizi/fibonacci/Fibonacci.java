package esercizi.fibonacci;

public class Fibonacci {

    /*
    Scrivere un metodo che stampa l’ennesimo elemento della sequenza di Fibonacci,
    nella quale ogni numero è definito dalla somma dei due precedenti, eccetto i
    primi due che sono per definizione 0 e 1. Esempio: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
    E così via.
    Assumete di iniziare da 0,  dunque fibonacci(0) = 0, fibonacci(1) = 1, ... e così via.

    fib(0) = 0
    fib(1) = 1
    fib(n) = fib(n-1) + fib(n-2)
     */
    public static void fibonacci(int n) {
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        System.out.println("Il numero di fibonacci " + n + " della sequenza è: " + array[n]);
    }

    public static void fibonacci2(int n) {
        int f1 = 0;
        int f2 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        System.out.println("Il numero di fibonacci " + n + " della sequenza è: " + result);
    }


}
