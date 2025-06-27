package order.domain.exceptions;

import java.util.UUID;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(UUID clientReference) {
        super("Reference client " + clientReference + " was not found");
    }
}
