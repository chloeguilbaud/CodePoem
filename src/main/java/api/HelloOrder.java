package api;

public class HelloOrder {

    public final String mail;
    public final int quantity;
    public final String address;

    public HelloOrder(String mail, int quantity, String address) {
        this.mail = mail;
        this.quantity = quantity;
        this.address = address;
    }
}
