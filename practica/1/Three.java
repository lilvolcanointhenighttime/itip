public class Three {
    public static void main(String[] args) {
        System.out.println(containers(1, 1, 1));
    }

    public static int containers(int boxes_count, int bags_count, int barrels_count) {
        return boxes_count*20 + bags_count*50 + barrels_count*100;

    }
}
