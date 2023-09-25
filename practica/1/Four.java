public class Four {
    public static void main(String[] args) {
        System.out.println(triangleType(3, 4, 5));
    }

    public static String triangleType(int x, int y, int z) {
        if (x==y && z==y) {
            return (String) "equilateral";
        }
        if (x==z && x!=y) {
            return "isosceles";
        }
        if (x+z>y && x+y>z) {
            return "different-sided";
        }
        else {
            return "not a triangle";
        }
    }
}
