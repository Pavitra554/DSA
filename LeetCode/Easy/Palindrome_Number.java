package DATA_STRUCTURE.LeetCode.Easy;

public class Palindrome_Number {
    public static boolean isPalindrome(int x) {
        int reversed = 0;
        int originalNUM = x;
        if (x < 0) {
            return false;
        }
        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        if (originalNUM == reversed) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
    }
}
