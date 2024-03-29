package DATA_STRUCTURE.Recursion;

public class palindromeString {
    static boolean isPlaindrome(String str, int s, int e) {
        if (s >= e) {
            return true;
        }
        if (str.charAt(s) != str.charAt(e)) {
            return false;
        }
        return isPlaindrome(str, s + 1, e - 1);
    }

    public static void main(String[] args) {
        String str = "pppaaappp";
        String str1 = "doggy";
        System.out.println(isPlaindrome(str, 0, str.length() - 1));
        System.out.println(isPlaindrome(str1, 0, str1.length() - 1));
    }
}
