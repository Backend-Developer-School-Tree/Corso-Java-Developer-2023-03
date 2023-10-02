package binary_search;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1}, 1));
        System.out.println(binarySearch(new int[]{1,3,6}, 2));
        System.out.println(binarySearch(new int[]{1,3,6}, 3));
        System.out.println(binarySearch(new int[]{1,2,5,7,8,10,12,16,19}, 10));
        System.out.println(binarySearch(new int[]{1,2,5,7,8,10,12,16,19}, 11));
    }

    public static boolean binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length-1);
    }

    public static boolean binarySearch(int[] array, int value, int leftIndex, int rightIndex) {
        // CASI BASE
        if (array.length == 0) return false;
        // gli indici si "accavallano", ovvero la metà è stata superata e l'elemento cercato non è stato trovato
        if (leftIndex > rightIndex) return false;

        // CASO RICORSIVO

        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

        if (value == array[midIndex]) return true;

        // se l'elemento cercato è più piccolo dell'attuale valore centrale,
        // allora potrà solo trovarsi nel sotto-array "di sinistra" (essendo ordinato)
        if (value < array[midIndex]) return binarySearch(array, value, leftIndex, midIndex-1);

        // viceversa, se l'elemento cercato è più grande
        // potrà solo trovarsi nel sotto-array "di destra" (essendo ordinato)
        return binarySearch(array, value, midIndex+1, rightIndex);
    }

}
