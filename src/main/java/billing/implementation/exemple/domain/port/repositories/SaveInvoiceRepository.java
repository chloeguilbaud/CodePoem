package billing.implementation.exemple.domain.port.repositories;

import billing.implementation.exemple.domain.model.Invoice;

public interface SaveInvoiceRepository {
    void save(Invoice invoice);
}
