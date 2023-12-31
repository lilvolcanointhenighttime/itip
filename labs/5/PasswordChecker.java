public class PasswordChecker {
    public static void main(String[] args) {

        String password = "12345678Aa";

        try {
            checkPasswordValidity(password);
            System.out.println("Correct.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void checkPasswordValidity(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";

        if (!password.matches(regex)) {
            throw new IllegalArgumentException("not Correct");
        }
    }
}
