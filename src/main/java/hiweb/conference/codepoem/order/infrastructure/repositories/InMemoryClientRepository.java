package hiweb.conference.codepoem.order.infrastructure.repositories;

import hiweb.conference.codepoem.order.domain.model.Client;
import hiweb.conference.codepoem.order.domain.port.repositories.ClientRepository;

import java.util.HashMap;

public class InMemoryClientRepository implements ClientRepository {

    private final HashMap<Integer, Client> clients;

    public InMemoryClientRepository() {
        this.clients = new HashMap<>();
        this.clients.put(1, new Client("Alice", "Dupont", "alice.dupont@example.com", true));
        this.clients.put(2, new Client("Bob", "Martin", "bob.martin@example.com", false));
        this.clients.put(3, new Client("Charlie", "Durand", "charlie.durand@example.com", true));
        this.clients.put(4, new Client("Diana", "Lemoine", "diana.lemoine@example.com", false));
        this.clients.put(5, new Client("Eric", "Moreau", "eric.moreau@example.com", true));
        this.clients.put(6, new Client("Fiona", "Roux", "fiona.roux@example.com", true));
        this.clients.put(7, new Client("George", "Bernard", "george.bernard@example.com", false));
        this.clients.put(8, new Client("Helen", "Petit", "helen.petit@example.com", true));
        this.clients.put(9, new Client("Ivan", "Blanc", "ivan.blanc@example.com", false));
        this.clients.put(10, new Client("Julia", "Garcia", "julia.garcia@example.com", true));
        this.clients.put(11, new Client("Kevin", "Noir", "kevin.noir@example.com", true));
    }

    @Override
    public Client get(int clientId) {
        if(clients.containsKey(clientId)) {
            return this.clients.get(clientId);
        }
        throw new ClientNotFoundException(clientId);
    }

}
