package order.domain.port.repositories;

import order.domain.model.Client;

public interface ClientRepository {

    Client get(int clientId);
    void save(Client client);

}
