package store;

public class Product {
    private int eventQuantity;
    private int quantity;
    private int price;
    private String name;

    public Product(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(String name, int eventQuantity, int price, String event) {
        this.name = name;
        this.price = price;
        this.eventQuantity = eventQuantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getEventQuantity() {
        return this.eventQuantity;
    }

    public String getName() {
        return this.name;
    }

    public void addQuantity(int volume) {
        this.quantity = quantity + volume;
    }

    public void addEventQuantity(int volume) {
        this.eventQuantity = eventQuantity + volume;
    }

}
