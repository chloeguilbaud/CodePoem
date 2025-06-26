package billing.implementation.exemple.domain.usecase;

import billing.implementation.exemple.domain.exceptions.InvalidInvoiceItemListException;

import java.util.UUID;

public class InvoiceQuery {

    private final UUID invoiceId;

    public InvoiceQuery(UUID invoiceId) {
        this.invoiceId = invoiceId;
    }

    public UUID getInvoiceId() {
        return invoiceId;
    }
}
