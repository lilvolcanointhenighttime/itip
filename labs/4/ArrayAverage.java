public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        String arr2 = "asd";
        int sum = 0;
        int n = arr.length;

        try {
            // ArrayIndexOutOfBoundsException
            int value3 = arr[999];

            // NumberFormatException
            int value2 = Integer.parseInt(arr2);
            sum += value2;

            for (int value : arr) {
                sum += value;
            }

            if (n == 0) {
                throw new ArithmeticException("Деление на ноль. Массив пуст.");
            }

            double average = (double) sum / n;
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива.");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверные данные в массиве.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
