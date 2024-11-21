package hiweb.conference.codepoem.order.domain.port.repositories;

import hiweb.conference.codepoem.order.domain.model.Client;

public interface ClientRepository {

    Client get(int clientId);

}
