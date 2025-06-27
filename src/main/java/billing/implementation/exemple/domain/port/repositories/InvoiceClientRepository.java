package billing.implementation.exemple.domain.port.repositories;

import billing.implementation.exemple.domain.model.Client;

import java.util.UUID;

public interface InvoiceClientRepository {
    Client findById(UUID clientId);
}
