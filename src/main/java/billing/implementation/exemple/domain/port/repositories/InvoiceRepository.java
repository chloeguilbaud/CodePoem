package billing.implementation.exemple.domain.port.repositories;

import billing.implementation.exemple.domain.model.Invoice;

import java.util.UUID;

public interface InvoiceRepository {
    void save(Invoice invoice);
    Invoice findById(UUID id);
}
