package api.domain;

public class Order {

    public final String mail;
    public final int quantity;
    public final String address;

    public Order(String mail, int quantity, String address) {
        this.mail = mail;
        this.quantity = quantity;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "email='" + mail + '\'' +
                ", quantity=" + quantity +
                ", address='" + address + '\'' +
                '}';
    }
}
