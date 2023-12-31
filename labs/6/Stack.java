import java.util.Arrays;

public class Stack<T> {
    private Object[] data;
    private int size;

    public Stack(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size] = element;
        size++;
    }

    public T pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("stack is empty");
        }
        @SuppressWarnings("unchecked")
        T item = (T) data[size - 1];
        data[size - 1] = null;
        size--;
        return item;
    }

    public T peek() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("stack is empty");
        }
        @SuppressWarnings("unchecked")
        T item = (T) data[size - 1];
        return item;
    }


    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>(5);

        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        // Выводим верхний элемент стека
        System.out.println("Peek: " + intStack.peek());

        // Удаляем элемент из стека
        int poppedItem = intStack.pop();
        System.out.println("Popped item: " + poppedItem);

        System.out.println("Peek after pop: " + intStack.peek());

        intStack.push(40);
        intStack.push(50);

        System.out.println("Stack elements:");
        while (intStack.size > 0) {
            System.out.println(intStack.pop());
        }
    }
}
