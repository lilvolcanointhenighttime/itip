import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1
        System.out.println("Task1");
        List<Integer> encryptedMessage = encrypt("Hello");
        System.out.println("Encrypted: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted: " + decryptedMessage);

        // 2
        System.out.println("Task2");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));

        // 3
        System.out.println("Task3");
        System.out.println(canComplete("butl", "beautiful")); 
        System.out.println(canComplete("butlz", "beautiful")); 
        System.out.println(canComplete("tulb", "beautiful")); 
        System.out.println(canComplete("bbutl", "beautiful")); 

        // 4
        System.out.println("Task4");
        System.out.println(sumDigProd(16, 28));
        System.out.println(sumDigProd(0));
        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));

        // 5
        System.out.println("Task5");
        System.out.println(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"})); // ["toe", "ocelot"]
        System.out.println(sameVowelGroup(new String[]{"many", "carriage", "emit", "apricot", "animal"})); // ["many"]
        System.out.println(sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"})); // ["hoops", "bot", "bottom"]

        // 6
        System.out.println("Task6");
        System.out.println(validateCard(1234567890123456l)); 
        System.out.println(validateCard(1234567890123452l)); 

        // 7
        System.out.println("Task7");
        System.out.println(numToEng(0));
        System.out.println(numToEng(18));
        System.out.println(numToEng(126));
        System.out.println(numToEng(909));

        // 8
        System.out.println("Task8");
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(getSha256Hash("Hey dude!"));

        // 9
        System.out.println("Task9");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));

        // 10
        System.out.println("Task10");
        System.out.println(gen(genN(7)));
        System.out.println();

    }

    // 1
    public static List<Integer> encrypt(String message) {
        List<Integer> result = new ArrayList<>();
        if (message.length() > 0) {
            result.add((int) message.charAt(0));
            for (int i = 1; i < message.length(); i++) {
                result.add((int) message.charAt(i) - (int) message.charAt(i - 1));
            }
        }
        return result;
    }

    public static String decrypt(List<Integer> encodedMessage) {
        StringBuilder result = new StringBuilder();
        if (!encodedMessage.isEmpty()) {
            result.append((char) encodedMessage.get(0).intValue());
            int currentChar = encodedMessage.get(0);
            for (int i = 1; i < encodedMessage.size(); i++) {
                currentChar += encodedMessage.get(i);
                result.append((char) currentChar);
            }
        }
        return result.toString();
    }

    // 2
    public static boolean canMove(String figure, String currentPosition, String targetPosition) {
        int currentX = currentPosition.charAt(0) - 'A' + 1;
        int currentY = currentPosition.charAt(1) - '0';

        int targetX = targetPosition.charAt(0) - 'A' + 1;
        int targetY = targetPosition.charAt(1) - '0';

        int deltaX = Math.abs(targetX - currentX);
        int deltaY = Math.abs(targetY - currentY);

        switch (figure.toLowerCase()) {
            case "pawn":
                return deltaX == 0 && deltaY == 1;
            case "knight":
                return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
            case "bishop":
                return deltaX == deltaY;
            case "rook":
                return deltaX == 0 || deltaY == 0;
            case "queen":
                return deltaX == deltaY || deltaX == 0 || deltaY == 0;
            case "king":
                return deltaX <= 1 && deltaY <= 1;
            default:
                return false;
        }
    }

    // 3
    public static boolean canComplete(String input, String word) {
        int inputIndex = 0;
        int wordIndex = 0;

        while (wordIndex < word.length() && inputIndex < input.length()) {
            if (input.charAt(inputIndex) == word.charAt(wordIndex)) {
                inputIndex++;
            }
            wordIndex++;
        }

        return inputIndex == input.length();
    }

    // 4
    public static int sumDigProd(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        int product = 1;
        String sumAsString = String.valueOf(sum);
        for (int i = 0; i < sumAsString.length(); i++) {
            int digit = Character.getNumericValue(sumAsString.charAt(i));
            product *= digit;
        }

        if (product >= 10) {
            return sumDigProd(product);
        } else {
            return product;
        }
    }

    // 5
    public static List<String> sameVowelGroup(String[] words) {
        if (words.length == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        String firstWord = words[0];
        String vowelsInFirstWord = extractVowels(firstWord);

        for (String word : words) {
            if (hasSameVowels(word, vowelsInFirstWord)) {
                result.add(word);
            }
        }

        return result;
    }

    private static String extractVowels(String word) {
        return word.replaceAll("[^aeiouAEIOU]", "");
    }

    private static boolean hasSameVowels(String word, String targetVowels) {
        String wordVowels = extractVowels(word);
        return wordVowels.equalsIgnoreCase(targetVowels);
    }

    // 6
    public static boolean validateCard(long cardNumber) {
        String cardNumberStr = Long.toString(cardNumber);

        if (cardNumberStr.length() < 14 || cardNumberStr.length() > 19) {
            return false;
        }

        int checkDigit = Character.getNumericValue(cardNumberStr.charAt(cardNumberStr.length() - 1));

        String reversedNumberStr = new StringBuilder(cardNumberStr.substring(0, cardNumberStr.length() - 1))
                .reverse().toString();

        int[] digits = new int[reversedNumberStr.length()];
        for (int i = 0; i < reversedNumberStr.length(); i++) {
            digits[i] = Character.getNumericValue(reversedNumberStr.charAt(i));
        }

        // Удвоение в нечетных позициях
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 != 0) {
                digits[i] *= 2;
                if (digits[i] > 9) {
                    digits[i] = digits[i] / 10 + digits[i] % 10;
                }
            }
        }

        int sum = Arrays.stream(digits).sum();

        // условии Луна
        return (10 - sum % 10) % 10 == checkDigit;
    }

    // 7
    // private static final String[] UNITS = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    // private static final String[] NOTTENS = {"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    // private static final String[] TENS = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто".};

    private static final String[] UNITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] NOTTENS = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static String numToEng(int num) {
        if (num == 0) {
            return "zero";
        }
        return convertToWords(num);
    }

    private static String convertToWords(int num) {
        if (num < 10) {
            return UNITS[num];
        } else if (num < 20) {
            return NOTTENS[num - 10];
        } else if (num < 100) {
            return TENS[num / 10] + (num % 10 != 0 ? " " + UNITS[num % 10] : "");
        } else {
            return UNITS[num / 100] + " hundred" + (num % 100 != 0 ? " " + convertToWords(num % 100) : "");
        }
    }

    // 8
    public static String getSha256Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());

            // Преобразование байтов в шестнадцатеричную строку
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 9
    public static String correctTitle(String input) {
        String[] words = input.toLowerCase().split("\\s+");

        for (int i = 0; i < words.length; i++) {
            if (i == 0 || i == words.length - 1 || !words[i].matches("^(and|the|of|in)$")) {
                words[i] = capitalize(words[i]);
            }
        }

        return String.join(" ", words);
    }

    private static String capitalize(String word) {
        if (word.isEmpty()) {
            return word;
        }
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    // 10
    public static String repeat(String s, int n) {
        return new String(new char[n]).replace("\0", s);
    }
 
    public static String gen(int n) {
        int b;
        final String CHAR = ".", NULL_CHAR = " ", CON_CHAR = NULL_CHAR + CHAR;
        if (--n % 6 != 0 | (b = (int) (1 + Math.sqrt(n /= 3))) * (b - 1) != n) {
            return "Invalid";
        }
        StringBuilder str = new StringBuilder();
        for (int i = b; i < 2 * b - 1; ++i) {
            str.append(repeat(NULL_CHAR, 2 * b - 2 - i)).append(repeat(CON_CHAR, i)).append(System.lineSeparator());
        }
        // str.append(".").append(repeat(CON_CHAR, 2 * b - 2)).append(System.lineSeparator());
        // for (int i = 2 * b - 2; i >= b; --i) {
        //     str.append(repeat(NULL_CHAR, 2 * b - 2 - i)).append(repeat(CON_CHAR, i)).append(System.lineSeparator());
        // }
        return str.toString();
    }
 
    public static int genN(int n) {
        return 1 + 3 * n * (n - 1);
    }
}
