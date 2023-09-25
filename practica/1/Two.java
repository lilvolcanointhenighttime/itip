class Two {
    public static void main(String[] args) {
        System.out.println(fitCalc(15, 5));
    }

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
}