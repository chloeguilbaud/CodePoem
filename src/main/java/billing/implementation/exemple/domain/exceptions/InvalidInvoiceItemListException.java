package billing.implementation.exemple.domain.exceptions;

import java.util.UUID;

public class InvalidInvoiceItemListException extends Exception {

    public InvalidInvoiceItemListException(UUID invoiceReference) {
        super("Invoice n°" + invoiceReference + " has illegal argument." +
                "Une facture doit contenir au moins une ligne");
    }

}
