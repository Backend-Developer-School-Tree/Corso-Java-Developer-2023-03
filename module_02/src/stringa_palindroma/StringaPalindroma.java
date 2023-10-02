package stringa_palindroma;

public class StringaPalindroma {

    public static void main(String[] args) {
        System.out.println(isPalindroma("itopinonavevanonipoti"));
        System.out.println(isPalindroma("ailatiditalia"));
        System.out.println(isPalindroma("nonsonopalindroma"));
        System.out.println(isPalindroma("paliilap"));

        System.out.println("");

        System.out.println(isPalindroma2("itopinonavevanonipoti"));
        System.out.println(isPalindroma2("ailatiditalia"));
        System.out.println(isPalindroma2("nonsonopalindroma"));
        System.out.println(isPalindroma2("paliilap"));
    }

    public static boolean isPalindroma(String str) {
        // CASI BASE
        if (str.length() == 0) return true;
        if (str.length() == 1) return true;

        if (str.charAt(0) != str.charAt(str.length()-1)) return false;

        // CHIAMATA RICORSIVA
        return isPalindroma(str.substring(1, str.length()-1));
    }

    public static boolean isPalindroma2(String str) {
        return isPalindroma2(str, 0, str.length()-1);
    }

    public static boolean isPalindroma2(String str, int startIndex, int endIndex) {
        // CASI BASE
        if (startIndex == endIndex) return true;
        if (startIndex > endIndex) return true;

        if (str.charAt(startIndex) != str.charAt(endIndex)) return false;

        // CHIAMATA RICORSIVA
        return isPalindroma2(str, startIndex+1, endIndex-1);
    }
}
