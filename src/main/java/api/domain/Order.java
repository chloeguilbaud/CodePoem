package api.domain;

public class Order {

    public String mail;
    public int quantity;
    public String address;

    public Order(String mail, int quantity, String address) {
        this.mail = mail;
        this.quantity = quantity;
        this.address = address;
    }
}
