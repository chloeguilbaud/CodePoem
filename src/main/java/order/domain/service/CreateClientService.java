package order.domain.service;

import order.domain.model.Client;
import order.domain.model.Order;

import java.util.UUID;

public class CreateClientService {

    public Client createClient(String firstName, String lastName, String email, String address) {
        // éventuel traitement métier
        // ...

        // génération de l'identifiant de commande
        UUID clientID = UUID.randomUUID();

        return new Client(clientID, firstName, lastName, email, false, address);
    }

}
