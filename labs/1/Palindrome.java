public class Palindrome {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg + " is a palindrome: " + isPalindrome(arg));
        }
    }

    public static String reverseString(String str) {
        str = str.toLowerCase();

        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static boolean isPalindrome(String s) {
        return s.toLowerCase().equals(reverseString(s));
    }
}