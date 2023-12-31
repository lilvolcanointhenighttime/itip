import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            // Пытаемся преобразовать строку в число
            String str = "abc";
            int number = parseNumber(str);

            System.out.println("Parsed number: " + number);
        } catch (CustomNumberFormatException e) {
            logException(e);
        }
    }

    private static int parseNumber(String str) throws CustomNumberFormatException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException("Invalid number format: " + str);
        }
    }

    private static void logException(Exception e) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("exceptionLog.txt", true))) {
            writer.write("Exception: " + e.getMessage());
            writer.newLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

class CustomNumberFormatException extends NumberFormatException {
    public CustomNumberFormatException(String message) {
        super(message);
    }
}

