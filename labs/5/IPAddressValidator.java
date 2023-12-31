import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidator {
    private static final String IP_ADDRESS_REGEX =
            "^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])$";

    public static boolean isValidIPAddress(String ipAddress) {
        try {
            Pattern pattern = Pattern.compile(IP_ADDRESS_REGEX);
            Matcher matcher = pattern.matcher(ipAddress);

            return matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String ipAddress = "192.168.0.1";

        try {
            if (isValidIPAddress(ipAddress)) {
                System.out.println("IP address is valid.");
            } else {
                System.out.println("Invalid IP address.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
