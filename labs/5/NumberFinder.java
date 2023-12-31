import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $19.99 22";

        String regex = "\\b\\d+(?:\\.\\d+)?\\b";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            try {
                System.out.println(matcher.group());
            } catch (NumberFormatException e) {
                System.out.println("Error parsing number: " + matcher.group());
            }
        }
    }
}
