import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 1
        System.out.println("Task: 1");
        System.out.println(duplicateChars("Aa"));
        // 2
        System.out.println("Task: 2");
        System.out.println(getInitials("Aa A"));
        // 3
        System.out.println("Task: 3");
        System.out.println(differenceEvenvOdd(new int[] {44, 32, 86, 19}));
        // 4
        System.out.println("Task: 4");
        System.out.println(equalToAvg(new int[] {1,2,3,4,5}));
        // 5
        System.out.println("Task: 5");
        System.out.println(Arrays.toString(indexMult(new int[] {1,2,3})));
        // 6
        System.out.println("Task: 6");
        System.out.println(reverse("Hello"));
        // 7
        System.out.println("Task: 7");
        System.out.println(Tribonacci(11));
        // 8
        System.out.println("Task: 8");
        System.out.println(pseudoHash(18));
        // 9
        System.out.println("Task: 9");
        System.out.println(botHelper("Help me pleasy"));
        // 10
        System.out.println("Task: 10");
        System.out.println(isAnagram("listen", "silent"));
    }

    // 1
    public static boolean duplicateChars(String str) {
        Set<Character> seen = new HashSet<>();

        str = str.toLowerCase();

        for (char c : str.toCharArray()) {
            if (seen.contains(c)) {
                return true;
            }
            seen.add(c);
        }

        return false;
    }
    
    // 2
    public static String getInitials(String str) {
        String upper_case_alphabet = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String initials = "";
        String spaces = "";
        try {
            for (char c: str.toCharArray()) {
                if (upper_case_alphabet.contains(String.valueOf(c))) {
                    initials += String.valueOf(c);
                }
                if (c == ' ') {
                    spaces += String.valueOf(c);
                }
            }
            if (spaces.length() == 1) {
                return initials;
            }
            else {
                throw new Exception("You should enter only Name and Surname with one space");
            }
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    // 3
    public static int differenceEvenvOdd(int[] arr) {
        int even = 0;
        int odd = 0;
        for (int i: arr) {
            if (i % 2 == 0){
                even += i;
            }
            else {
                odd += i;
            }
        }
        return Math.abs(even - odd);
    }

    // 4
    public static boolean equalToAvg(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
    
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
    
        int average = sum / arr.length;
    
        for (int num : arr) {
            if (num == average) {
                return true;
            }
        }
    
        return false;
    }

    // 5
    public static int[] indexMult(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * i;
        }
        return arr;
    }
    
    // 6
    public static String reverse(String str) {

        str = str.toLowerCase();

        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    // 7
    public static int Tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
    
        int[] tribonacciNumbers = new int[n + 1];
        tribonacciNumbers[0] = 0;
        tribonacciNumbers[1] = 1;
        tribonacciNumbers[2] = 1;
    
        for (int i = 3; i <= n; i++) {
            tribonacciNumbers[i] = tribonacciNumbers[i - 1] + tribonacciNumbers[i - 2] + tribonacciNumbers[i - 3];
        }
    
        return tribonacciNumbers[n];
    }
    
    // 8
    public static String pseudoHash(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be a positive number");
        }
        String characters = "0123456789abcdef";
        StringBuilder quasiHash = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            quasiHash.append(randomChar);
        }
        return quasiHash.toString();
    }


    // 9
    public static String botHelper(String str) {
        str = str.toLowerCase();
        String[] arr_str = str.split(" ");

        if (arr_str.length != 1) {
            for (String word : arr_str) {
                if (word.equals("help")) {
                    return "Calling for a staff member";
                }
            }
        }
        return "Keep waiting";
    }

    // 10
    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
}