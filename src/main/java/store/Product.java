package store;

public class Product {
    public int eventQuantity;
    public int quantity;
    public int price;
    public String name;

    public Promotion promotion;

    public Product(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.promotion = Promotion.NULL;
    }

    public Product(String name, int eventQuantity, int price, String event) {
        this.name = name;
        this.price = price;
        this.eventQuantity = eventQuantity;
        this.promotion = Promotion.findByName(event);
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
