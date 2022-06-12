package DATA_STRUCTURE.LeetCode.Easy;

public class ReverseString {
    static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "pavitra";
        char c[] = str.toCharArray();
        reverseString(c);
        str = "";
        for (int i = 0; i < c.length; i++) {
            str += c[i];
        }
        System.out.println(str);

    }
}
