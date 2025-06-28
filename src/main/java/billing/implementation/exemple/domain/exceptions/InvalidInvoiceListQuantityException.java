package billing.implementation.exemple.domain.exceptions;

public class InvalidInvoiceListQuantityException extends Exception {

    public InvalidInvoiceListQuantityException() {
        super("Cannot add negative quantity.");
    }


}
