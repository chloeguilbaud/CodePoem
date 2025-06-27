package billing.implementation.exemple.infrastructure.repositories;

import billing.implementation.exemple.domain.model.Client;
import billing.implementation.exemple.domain.port.repositories.InvoiceClientRepository;
import order.domain.port.repositories.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class InMemoryInvoiceClientRepository implements InvoiceClientRepository {

    private ClientRepository repository;

    @Override
    public Client findById(UUID clientId) {

        order.domain.model.Client client = repository.get(clientId);

        return contextMapper(client);
    }

    Client contextMapper(order.domain.model.Client client) {
        return new Client(client.getFirstName(), client.getLastName(), client.getEmail(), client.getAddress());
    }
}
