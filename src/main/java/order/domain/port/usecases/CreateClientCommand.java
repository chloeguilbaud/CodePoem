package order.domain.port.usecases;

public class CreateClientCommand {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;

    public CreateClientCommand(String firstName, String lastName, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
