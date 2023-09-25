class Ten {
    public static void main(String[] args) {
        System.out.println(tables(5, 3));
    }

    public static int tables(int students_count, int tables_count) {
        return (students_count > tables_count*2) ? students_count % (tables_count*2) :0;
    }
}