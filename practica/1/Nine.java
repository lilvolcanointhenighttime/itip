public class Nine {
    public static void main(String[] args) {
        System.out.println(ticketSaler(2, 1));
    }

    public static int ticketSaler(int selled_tickets_count, int ticket_cost) {
        return selled_tickets_count*ticket_cost;
    }
}
