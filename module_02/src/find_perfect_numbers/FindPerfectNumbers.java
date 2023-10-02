package find_perfect_numbers;

public class FindPerfectNumbers {

    public static void main(String[] args) {
        System.out.println(isPerfect(6));

        findPerfectNumbers(1000);
    }

    public static void findPerfectNumbers(int n) {
        for (int i = 0; i < n; i++) {
            if (isPerfect(i)) System.out.println(i);
        }
    }

    public static boolean isPerfect(int n) {
        if (n <= 1) return false;

        // somma dei suoi divisori escluso se stesso
        int divisorsSum = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                divisorsSum += i;
        }

        return divisorsSum == n;

        // versione "più verbosa"
        // if (divisorsSum == n) return true;
        // else return false;
    }

    /*
    public static boolean isPerfectRecursive(int n, int divisorsSum) {
        if (n <= 1) return false;


    }
     */

}
