import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Task1
        System.out.println("Task1");
        HashTable<String, Integer> table = new HashTable<String, Integer>();

        table.put("apple", 5);
        // table.put("banana", 3);
        // table.put("pear", 2);
        // table.put("cherry", 8);
        table.printTable();
        for (LinkedList<Entry<String, Integer>> chain : table.getTable()) {
            if (chain != null) {
                for (Entry<String, Integer> entry : chain) {
                    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                }
            }
        }

        // System.out.println("Value for 'apple': " + table.get("apple"));
        // System.out.println("Value for 'banana': " + table.get("banana"));
        // System.out.println("Value for 'cherry': " + table.get("cherry"));

        // table.remove("banana");
        // System.out.println("Value for 'banana' after removal: " + table.get("banana"));

        // System.out.println("Size of the table: " + table.size());
        // System.out.println("Is the table empty? " + table.isEmpty());


        // Task2
        System.out.println("\nTask2");
        BookHashTable library = new BookHashTable(100);

        Book book1 = new Book("Book 1", "Author 1", 5);
        Book book2 = new Book("Book 2", "Author 2", 3);
    
        library.put("ISBN1", book1);
        library.put("ISBN2", book2);
    
        Book retrievedBook = library.get("ISBN1");
        System.out.println("Retrieved Book: " + retrievedBook.getTitle());
        System.out.println("ISBN1 count: " + retrievedBook.getCopies());

        library.remove("ISBN2");
        System.out.println("ISBN2: " + library.get("ISBN2"));
    }
}

class HashTable<K, V> {
    private static final int TABLE_SIZE = 10;
    private LinkedList<Entry<K, V>>[] table;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        // Проверяем, есть ли элемент с таким ключом в цепочке
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        // Если элемент с таким ключом не найден, добавляем новую запись
        table[index].add(new Entry<K, V>(key, value));
    }


    public void printTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("Index " + i + ": ");
            LinkedList<Entry<K, V>> chain = table[i];
            if (chain != null) {
                for (Entry<K, V> entry : chain) {
                    System.out.print(entry.getKey() + " -> ");
                }
            }
            else {
                System.out.println("null");
            }
        }
    }
    
    public LinkedList<Entry<K, V>>[] getTable() {
    return table;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }

        // Поиск элемента по ключу в цепочке
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return;
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                table[index].remove(entry);
                return;
            }
        }
    }

    public int size() {
        int count = 0;
        for (LinkedList<Entry<K, V>> chain : table) {
            if (chain != null) {
                count += chain.size();
            }
        }
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int hash(K key) {
        // int hashCode = key.hashCode();
        // return Math.abs(hashCode) % TABLE_SIZE;
        return 0;
    }
}

class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

// Task 2
class Book {
    private String title;
    private String author;
    private int copies;

    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}

class BookHashTable {
    private Book[] table;

    public BookHashTable(int size) {
        table = new Book[size];
    }

    public void put(String isbn, Book book) {
        int index = hash(isbn);
        table[index] = book;
    }

    public Book get(String isbn) {
        int index = hash(isbn);
        return table[index];
    }

    public void remove(String isbn) {
        int index = hash(isbn);
        table[index] = null;
    }

    public int size() {
        return table.length;
    }

    private int hash(String isbn) {
        int hashCode = isbn.hashCode();
        int index = Math.abs(hashCode) % table.length;
        return index;
    }
}


