package order.domain.exceptions;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String clientReference) {
        super("Reference client " + clientReference + " was not found");
    }
}
