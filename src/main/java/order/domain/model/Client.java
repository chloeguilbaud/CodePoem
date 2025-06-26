package order.domain.model;

public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isLoyal;

    public Client(String firstName, String lastName, String email, boolean isLoyal) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isLoyal = isLoyal;
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

    public int getId() {
        return id;
    }
}
