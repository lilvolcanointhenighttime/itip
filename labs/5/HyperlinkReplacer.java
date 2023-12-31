import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HyperlinkReplacer {
    public static void main(String[] args) {
        String inputText = "http://www.example.com and http://anotherlink.com";

        try {
            String replacedText = replaceLinks(inputText);

            System.out.println("Text with replaced links:");
            System.out.println(replacedText);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static String replaceLinks(String text) throws Exception {
        try {
            // Регулярное выражение для поиска ссылок
            String regex = "\\b(?:https?|http):\\/\\/\\S+\\b";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            // Замена найденных ссылок на гиперссылки
            StringBuffer replacedText = new StringBuffer();
            while (matcher.find()) {
                String link = matcher.group();
                String hyperlink = "<a href=\"" + link + "\">" + link + "</a>";
                matcher.appendReplacement(replacedText, hyperlink);
            }
            matcher.appendTail(replacedText);

            return replacedText.toString();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
