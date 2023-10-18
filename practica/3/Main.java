import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1
        System.out.println("Task 1");
        System.out.println(replaceVowels("apple"));

        // 2
        System.out.println("Task 2");
        System.out.println(stringTransform("hello"));

        // 3
        System.out.println("Task 3");
        System.out.println(doesBlockFit(1, 3, 5, 4, 5));

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

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char prevChar = input.charAt(i - 1);

            if (currentChar == prevChar) {
                result.append("Double").append(currentChar);
            } else {
                result.append(currentChar);
            }
        }

        result.insert(0, input.charAt(0));

        return result.toString();
    }

    // 3
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        boolean fitsInWidth = a <= w && b <= h;
        boolean fitsInHeight = a <= h && b <= w;
        boolean fitsInDepth = b <= w && c <= h;

        return fitsInWidth || fitsInHeight || fitsInDepth;
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

        return (number % 2 == 0 && sumOfSquares % 2 == 0) || (number % 2 != 0 && sumOfSquares % 2 != 0);
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

        if (discriminant > 0) {
            return 2;
        } else if (discriminant == 0) {
            return 1;
        } else {
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

        // Преобразуем результат в список
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
        // Приводим предложение к нижнему регистру, чтобы учесть все варианты
        sentence = sentence.toLowerCase();

        // Создаем строку, содержащую гласные
        String vowels = "aeiouy";

        // Создаем массив для подсчета частоты гласных
        int[] counts = new int[6]; // "aeiou" - 5 гласных

        // Перебираем символы предложения
        for (char c : sentence.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
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

        // Возвращаем гласную с максимальной частотой
        return String.valueOf(vowels.charAt(maxCountIndex));
    }

    // 10
    public static void dataScience(int[][] matrix) {
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
    }
}
// Этот код создает функцию dataScience, которая изменяет элементы последнего (n-го) массива в матрице на среднее арифметическое элементов в соответствующем столбце.






