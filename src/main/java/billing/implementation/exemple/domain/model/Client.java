package billing.implementation.exemple.domain.model;

public class Client {

    private final String name;
    private final String surname;
    private final String mail;
    private final String address;

    public Client(String name, String surname, String mail, String address) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public String getAddress() {
        return address;
    }
}
