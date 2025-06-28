package billing.implementation.exemple.domain.exceptions;

public class InvalidPaymentDetailException extends RuntimeException {
    public InvalidPaymentDetailException(String message) {
        super(message);
    }
}
