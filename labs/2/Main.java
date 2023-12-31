public class Main {
    public static void main(String[] args) {
        PassengerCar car1 = new PassengerCar("Toyota", 2023, 25000, 4);
        System.out.println(car1.getPrice());
        car1.start();
        car1.stop();
        Transport car2 = new PassengerCar("Honda", 2022, 22000, 5);
        Transport car3 = new PassengerCar();
        car3.setModel("emptyModel");
        System.out.println("Car3 model is: " + car3.getModel());
        Transport truck1 = new Truck("Volvo", 2021, 75000, 20.5);
        
        System.out.println("Total objects created: " + Transport.getCount());
    }
}

abstract class Transport {
    // Поля
    private String model;
    private int year;
    private double price;
    private static int counter;

    // Конструктор по умолчанию
    public Transport() {
        this.model = "Transport";
        this.year = 2023;
        this.price = 0.00;
        incrementCount();
    }

    // Конструктор
    public Transport(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
        incrementCount();
    }

    // Методы
    public abstract void start(); // Метод для запуска транспортного средства

    public abstract void stop();  // Метод для остановки транспортного средства

    private static void incrementCount() {
        counter++;
    }

    // Геттеры и сеттеры

    public static int getCount() {
        return counter;
    }

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

    // Конструктор по умолчанию
    public PassengerCar() {
        super("model", 2004, 5.00);
        // String model = "PassengerCar";
        // int year = 2023;
        // double price = 0.00;
        this.passengerCapacity = 0;
        System.out.println("PassengerCar with passengerCapacity = " + this.passengerCapacity + " created");
    }
    // Конструктор
    public PassengerCar(String model, int year, double price, int passengerCapacity) {
        super(model, year, price);
        this.passengerCapacity = passengerCapacity;
        System.out.println("PassengerCar with passengerCapacity = " + this.passengerCapacity + " created");
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

    public Truck() {
        this.cargoCapacity = 0.00;
        System.out.println("Truck with cargoCapacity = " + this.cargoCapacity + " created");
    }

    // Конструктор
    public Truck(String model, int year, double price, double cargoCapacity) {
        super(model, year, price);
        this.cargoCapacity = cargoCapacity;
        System.out.println("Truck with cargoCapacity = " + this.cargoCapacity + " created");
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

    public Motorcycle() {
        this.type = "Motorcycle";
        System.out.println("Motorcycle with type = " + this.type + " created");
    }

    // Конструктор
    public Motorcycle(String model, int year, double price, String type) {
        super(model, year, price);
        this.type = type;
        System.out.println("Motorcycle with type = " + this.type + " created");
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
