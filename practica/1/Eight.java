public class Eight {
    public static void main(String[] args) {
        System.out.println(gcd(64, 28));
    }

    public static int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
