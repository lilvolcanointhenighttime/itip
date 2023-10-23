public class Main {
    public static void main(String[] args) {
        // 1
        System.out.println("Task 1");
        System.out.println(nonRepeatable("hello"));
        System.out.println(alphabeticRow("abcdejuwx"));
    }

    // 1
    public static String nonRepeatable(String input) {
        if (input.length() <= 1) {
            return input;
        }
        char firstChar = input.charAt(0);
        String remaining = input.substring(1).replaceAll(String.valueOf(firstChar), "");
        return firstChar + nonRepeatable(remaining);
    }

    // 4
    public static String alphabeticRow(String input) {
        if (input == null || input.isEmpty()) {
            return ""; // Возвращаем пустую строку, если входная строка пуста или null
        }
    
        String currentRow = String.valueOf(input.charAt(0)); // Текущий последовательный ряд
        String longestRow = currentRow; // Самый длинный последовательный ряд
    
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(i - 1);
    
            if (currentChar == previousChar + 1 || currentChar == previousChar - 1) {
                // Если текущий символ продолжает последовательный ряд, добавляем его к текущему ряду
                currentRow += currentChar;
            } else {
                // Если текущий символ не продолжает последовательный ряд, начинаем новый ряд
                currentRow = String.valueOf(currentChar);
            }
    
            // Сравниваем текущий ряд с самым длинным
            if (currentRow.length() > longestRow.length()) {
                longestRow = currentRow;
            }
        }
    
        return longestRow;
    }
    
}
