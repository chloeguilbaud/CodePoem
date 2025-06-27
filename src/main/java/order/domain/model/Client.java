package order.domain.model;

import java.util.UUID;

public class Client {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final boolean isLoyal;
    private final String address;

    public Client(UUID id, String firstName, String lastName, String email, boolean isLoyal, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isLoyal = isLoyal;
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

    public boolean isLoyal() {
        return isLoyal;
    }

    public UUID getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}
