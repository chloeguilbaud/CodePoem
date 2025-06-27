package api;

public class Order {

    public final String mail;
    public final int quantity;
    public final String address;

    public Order(String mail, int quantity, String address) {
        this.mail = mail;
        this.quantity = quantity;
        this.address = address;
    }
}
