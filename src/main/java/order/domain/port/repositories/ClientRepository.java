package order.domain.port.repositories;

import order.domain.model.Client;

import java.util.UUID;

public interface ClientRepository {

    Client get(UUID clientId);
    void save(Client client);

}
