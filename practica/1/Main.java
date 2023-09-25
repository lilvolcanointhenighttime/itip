public class Main {
    public static void main(String[] args) {
        // 1
        System.out.println("Task: 1");
        System.out.println(convert(5));
        // 2
        System.out.println("Task: 2");
        System.out.println(fitCalc(15, 1));
        // 3
        System.out.println("Task: 3");
        System.out.println(containers(1, 1, 1));
        // 4
        System.out.println("Task: 4");
        System.out.println(triangleType(3, 4, 5));
        // 5
        System.out.println("Task: 5");
        System.out.println(terrnaryEvaluation(5, 6));
        // 6
        System.out.println("Task: 6");
        System.out.println(howManyItems(45, 1.8, 1.9));
        // 7
        System.out.println("Task: 7");
        System.out.println(factorial(3));
        // 8
        System.out.println("Task: 8");
        System.out.println(gcd(64, 28));
        // 9
        System.out.println("Task: 9");
        System.out.println(ticketSaler(2, 1));
        // 10
        System.out.println("Task: 10");
        System.out.println(tables(9, 3));
    }

    // 1
    public static float convert(int x){
        return x*3.78541f;
    }

    // 2
    public static String fitCalc(int time, int intensity) {
        try{
            if (intensity > 0 && intensity <= 3) {
            return String.valueOf(time*intensity);
            }
            else {
                throw new IllegalAccessException("You should inter intensity equal 1, 2 or 3");
            }
        }
        catch (IllegalAccessException e){
            return e.getMessage();
        }
    }

    // 3
    public static int containers(int boxes_count, int bags_count, int barrels_count) {
        return boxes_count*20 + bags_count*50 + barrels_count*100;

    }

    // 4
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

    // 5
    public static int terrnaryEvaluation(int a, int b) {
        return (a>b) ? a :b;

    }

    // 6
    public static int howManyItems(int textile_len, double with, double len) {
        return (int) (textile_len/20*with*len);
    }

    // 7
    public static int factorial(int number) {
        return (number == 0) ? 1 :number*factorial(number-1);
    }

    // 8
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

    // 9
    public static int ticketSaler(int selled_tickets_count, int ticket_cost) {
        return selled_tickets_count*ticket_cost;
    }

    // 10
    public static int tables(int students_count, int tables_count) {
        int tables_needed = (int) Math.ceil((double) students_count / 2);

        return (tables_count < tables_needed) ? (tables_needed - tables_count) :0;
    }
}