package esercizi.find_prime_numbers;

public class FindPrimeNumbers {

    public static void main(String[] args) {
        System.out.println(isPrime(4));
        findPrimeNumbers(20);
    }

    public static void findPrimeNumbers(int n) {
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) System.out.println(i);
        }
    }

    public static boolean isPrime(int n) {
        return isPrime(n, n-1);
    }

    public static boolean isPrime(int n, int divisore) {
        if (n < 2) throw new ArithmeticException();

        if (n == 2) return true;
        if (divisore == 1) return true;

        if (n % divisore == 0) return false;

        return isPrime(n, divisore-1);
    }

}
