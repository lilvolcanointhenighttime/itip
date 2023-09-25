public class Main {
    public static void main(String[] args) {
        
    }
}

abstract class Transport {
    // Поля
    private String model;
    private int year;
    private double price;

    // Конструктор
    public Transport(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Методы
    public abstract void start(); // Метод для запуска транспортного средства

    public abstract void stop();  // Метод для остановки транспортного средства

    // Геттеры и сеттеры
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Переопределение метода toString() для вывода информации о транспортном средстве
    @Override
    public String toString() {
        return "Model: " + model + ", Year: " + year + ", Price: $" + price;
    }
}


// Дочерний класс: Легковой автомобиль
class PassengerCar extends Transport {
    // Дополнительные поля для легкового автомобиля
    private int passengerCapacity;

    // Конструктор
    public PassengerCar(String model, int year, double price, int passengerCapacity) {
        super(model, year, price);
        this.passengerCapacity = passengerCapacity;
    }

    // Перегрузка метода start() для легкового автомобиля
    @Override
    public void start() {
        System.out.println("Passenger car is starting...");
    }

    // Перегрузка метода stop() для легкового автомобиля
    @Override
    public void stop() {
        System.out.println("Passenger car is stopping...");
    }

    // Геттер и сеттер для поля passengerCapacity
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    // Переопределение метода toString() для вывода информации о легковом автомобиле
    @Override
    public String toString() {
        return "Passenger Car - " + super.toString() + ", Passenger Capacity: " + passengerCapacity;
    }
}

// Дочерний класс: Грузовой автомобиль
class Truck extends Transport {
    // Дополнительные поля для грузового автомобиля
    private double cargoCapacity;

    // Конструктор
    public Truck(String model, int year, double price, double cargoCapacity) {
        super(model, year, price);
        this.cargoCapacity = cargoCapacity;
    }

    // Перегрузка метода start() для грузового автомобиля
    @Override
    public void start() {
        System.out.println("Truck is starting...");
    }

    // Перегрузка метода stop() для грузового автомобиля
    @Override
    public void stop() {
        System.out.println("Truck is stopping...");
    }

    // Геттер и сеттер для поля cargoCapacity
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    // Переопределение метода toString() для вывода информации о грузовом автомобиле
    @Override
    public String toString() {
        return "Truck - " + super.toString() + ", Cargo Capacity: " + cargoCapacity + " tons";
    }
}

// Дочерний класс: Мотоцикл
class Motorcycle extends Transport {
    // Дополнительные поля для мотоцикла
    private String type;

    // Конструктор
    public Motorcycle(String model, int year, double price, String type) {
        super(model, year, price);
        this.type = type;
    }

    // Перегрузка метода start() для мотоцикла
    @Override
    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    // Перегрузка метода stop() для мотоцикла
    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    // Геттер и сеттер для поля type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Переопределение метода toString() для вывода информации о мотоцикле
    @Override
    public String toString() {
        return "Motorcycle - " + super.toString() + ", Type: " + type;
    }
}
