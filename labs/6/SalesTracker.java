import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }
}

public class SalesTracker {
    private TreeSet<Product> soldProducts = new TreeSet<>(Comparator.comparing(Product::getName));
    private double totalSales = 0;

    public void addSale(Product product) {
        soldProducts.add(product);
        totalSales += product.getPrice();
    }

    public void displaySales() {
        System.out.println("List of sold products:");
        for (Product product : soldProducts) {
            System.out.println(product.toString());
        }
    }

    public double getTotalSales() {
        return totalSales;
    }

    public Product getMostPopularProduct() {
        return soldProducts.last();
    }

    public static void main(String[] args) {
        SalesTracker salesTracker = new SalesTracker();

        salesTracker.addSale(new Product("Product1", 20.0));
        salesTracker.addSale(new Product("Product2", 15.0));
        salesTracker.addSale(new Product("Product3", 25.0));

        // Проданные товары
        salesTracker.displaySales();

        System.out.println("Total Sales: " + salesTracker.getTotalSales());
        System.out.println("Most Popular Product: " + salesTracker.getMostPopularProduct());
    }
}
