package esercizi.binary_search;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1}, 1));
        System.out.println(binarySearch(new int[]{1,3,6}, 2));
        System.out.println(binarySearch(new int[]{1,3,6}, 3));
        System.out.println(binarySearch(new int[]{1,2,5,7,8,10,12,16,19}, 10));
        System.out.println(binarySearch(new int[]{1,2,5,7,8,10,12,16,19}, 11));
    }

    // assumiamo che l'array in input sia ordinato
    public static boolean binarySearch(int[] arrayOrdinato, int valueToFind) {
        return binarySearch(arrayOrdinato, valueToFind, 0, arrayOrdinato.length-1);
    }

    public static boolean binarySearch(int[] arrayOrdinato, int valueToFind, int leftIndex, int rightIndex) {
        // CASI BASE
        if (arrayOrdinato.length == 0) return false;
        if (leftIndex > rightIndex) return false;

        // CASO RICORSIVO
        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

        if (valueToFind == arrayOrdinato[midIndex]) return true;

        // se l'elemento cercato è più piccolo dell'attuale valore centrale,
        // allora potrà solo trovarsi nel sotto-array "di sinistra" (essendo ordinato)
        if (valueToFind < arrayOrdinato[midIndex])
            return binarySearch(arrayOrdinato, valueToFind, leftIndex, midIndex-1);

        // viceversa, se l'elemento cercato è più grande
        // potrà solo trovarsi nel sotto-array "di destra" (essendo ordinato)
        return binarySearch(arrayOrdinato, valueToFind, midIndex+1, rightIndex);
    }

}
