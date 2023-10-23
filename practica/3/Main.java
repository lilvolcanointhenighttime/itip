import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1
        System.out.println("Task 1");
        System.out.println(replaceVowels("apple"));

        // 2
        System.out.println("Task 2");
        System.out.println(stringTransform("hhellooo"));

        // 3
        System.out.println("Task 3");
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));

        // 4
        System.out.println("Task 4");
        System.out.println(numCheck(243));

        // 5
        System.out.println("Task 5");
        System.out.println(countRoots(new int[] {1, -3, 2}));

        // 6
        System.out.println("Task 6");
        System.out.println(salesData(new String[][] {
            {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
            {"Banana", "Shop2", "Shop3", "Shop4"},
            {"Orange", "Shop1", "Shop3", "Shop4"},
            {"Pear", "Shop2", "Shop4"}
        }));

        // 7
        System.out.println("Task 7");
        System.out.println(validSplit("apple eagle egg goat"));

        // 8
        System.out.println("Task 8");
        System.out.println(waveForm(new int[] {1, 2, -6, 10, 3}));

        // 9
        System.out.println("Task 9");
        System.out.println(commonVowel("Actions speak louder than words."));

        // 10
        System.out.println("Task 10");
        int[][] arrays = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        dataScience(arrays);

        // Выводим измененные массивы
        for (int[] arr : arrays) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // 1
    public static String replaceVowels(String str) {
        StringBuilder result = new StringBuilder(str);
        String vowels_alphabet = "AEIOUYaeiouy";
    
        for (int i = 0; i < result.length(); i++) { // Change to < instead of <=
            char current_char = result.charAt(i);
            if (vowels_alphabet.contains(String.valueOf(current_char))) {
                result.setCharAt(i, '*'); // Fix this line
            }
        }
        return result.toString(); // Use toString() to convert StringBuilder to String
    }
    
    // 2
    public static String stringTransform(String input) {
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();

        for (int i = 0; i < input.length(); i++) {
            String double_founded = "Double" + String.valueOf(chars[i]).toUpperCase();
            if ( i < chars.length - 1 && chars[i] == chars[i + 1]) {
                result.append(double_founded);
                i++;
            } else {
                result.append(chars[i]);
            }
        }
        return result.toString();
    }

    // 3    container (2?)
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        Integer[]  hole_sides = {w, h};
        Integer[] sides = {a, b, c};
        Arrays.sort(sides, Collections.reverseOrder());
        Arrays.sort(hole_sides, Collections.reverseOrder());
        return (sides[2] <= hole_sides[1]) && (sides[1] <= hole_sides[0]);
    }

    // 4
    public static boolean numCheck(int number) {
        int sumOfSquares = 0;
        int tempNumber = Math.abs(number);

        while (tempNumber > 0) {
            int digit = tempNumber % 10;
            sumOfSquares += digit * digit;
            tempNumber /= 10;
        }
        boolean number_parity = (number % 2 == 0);
        boolean sumOfSquares_parity = (sumOfSquares % 2 == 0);
        return number_parity && sumOfSquares_parity;
    }

    // 5
    public static int countRoots(int[] coefficients) {
        if (coefficients.length != 3) {
            throw new IllegalArgumentException("Array must contains only 3 elements");
        }

        int a = coefficients[0];
        int b = coefficients[1];
        int c = coefficients[2];

        int discriminant = b * b - 4 * a * c;
        
        double x1 = (b*(-1) - Math.sqrt(discriminant));
        double x2 = (b*(-1) + Math.sqrt(discriminant));

        boolean x1_bool = x1 % 1 == 0;
        boolean x2_bool = x2 % 1 == 0;

        if (x1_bool && x2_bool) {
            return 2;
        }
        if (x1_bool || x2_bool) {
            return 1;
        }
        else {
            return 0;
        }
    }

    // 6
    public static List<String> salesData(String[][] data) {
        Map<String, Set<String>> storeItems = new HashMap<>();

        for (int i = 0; i < data.length; i++) {
            String[] row = data[i];
            String item = row[0];
            
            for (int j = 1; j < row.length; j++) {
                String store = row[j];
                storeItems.computeIfAbsent(store, k -> new HashSet<>()).add(item);
            }
        }

        Set<String> commonItems = null;
        for (Set<String> items : storeItems.values()) {
            if (commonItems == null) {
                commonItems = new HashSet<>(items);
            } else {
                commonItems.retainAll(items);
            }
        }
        return new ArrayList<>(commonItems);
    }

    // 7
    public static boolean validSplit(String sentence) {
        String[] words = sentence.split(" ");

        if (words.length <= 1) {
            return true;
        }

        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String currentWord = words[i];

            if (prevWord.charAt(prevWord.length() - 1) != currentWord.charAt(0)) {
                return false;
            }
        }

        return true;
    }

    // 8
    public static boolean waveForm(int[] arr) {
        if (arr.length < 2) {
            return true;
        }

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];

            if (diff > 0 && decreasing) {
                increasing = true;
                decreasing = false;
            } else if (diff < 0 && increasing) {
                increasing = false;
                decreasing = true;
            } else {
                return false; // Найдена последовательность, не соответствующая волнообразной
            }
        }

        return true; // Весь массив соответствует волнообразной последовательности
    }

    // 9
    public static String commonVowel(String sentence) {
        sentence = sentence.toLowerCase();

        String vowels = "aeiouy";

        int[] counts = new int[6];

        for (char c : sentence.toCharArray()) {
            if (vowels.indexOf(c) != -1) { // indexOf ???
                // Если символ является гласной, увеличиваем соответствующий счетчик
                counts[vowels.indexOf(c)]++;
            }
        }

        // Находим индекс гласной с максимальной частотой
        int maxCountIndex = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > counts[maxCountIndex]) {
                maxCountIndex = i;
            }
        }

        return String.valueOf(vowels.charAt(maxCountIndex));
    }

    // 10   return int[][]
    public static int[][] dataScience(int[][] matrix) {
        int n = matrix.length;
        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            int average = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][j];
                average = sum / n;
            }
            matrix[j][j] = average;
        }
        return matrix;
    }
}





