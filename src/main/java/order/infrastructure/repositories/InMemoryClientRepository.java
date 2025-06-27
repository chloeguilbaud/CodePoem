package order.infrastructure.repositories;

import order.domain.model.Client;
import order.domain.port.repositories.ClientRepository;

import java.util.HashMap;
import java.util.UUID;

public class InMemoryClientRepository implements ClientRepository {

    private final HashMap<UUID, Client> clients;

    public InMemoryClientRepository() {
        this.clients = new HashMap<>();
        this.clients.put(1, new Client(UUID.randomUUID(), "Alice", "Dupont", "alice.dupont@example.com", true, "12 rue des Lilas, 75020 Paris, France"));
        this.clients.put(2, new Client(UUID.randomUUID(), "Bob", "Martin", "bob.martin@example.com", false, "8 avenue Victor Hugo, 33000 Bordeaux, France"));
        this.clients.put(3, new Client(UUID.randomUUID(), "Charlie", "Durand", "charlie.durand@example.com", true, "25 boulevard Saint-Michel, 75005 Paris, France"));
        this.clients.put(4, new Client(UUID.randomUUID(), "Diana", "Lemoine", "diana.lemoine@example.com", false, "5 impasse des Acacias, 69008 Lyon, France"));
        this.clients.put(5, new Client(UUID.randomUUID(), "Eric", "Moreau", "eric.moreau@example.com", true, "17 rue de la République, 13001 Marseille, France"));
        this.clients.put(6, new Client(UUID.randomUUID(), "Fiona", "Roux", "fiona.roux@example.com", true, "42 allée des Cerisiers, 44300 Nantes, France"));
        this.clients.put(7, new Client(UUID.randomUUID(), "George", "Bernard", "george.bernard@example.com", false, "10 chemin du Vieux Moulin, 31000 Toulouse, France"));
        this.clients.put(8, new Client(UUID.randomUUID(), "Helen", "Petit", "helen.petit@example.com", true, "3 place de la Mairie, 67000 Strasbourg, France"));
        this.clients.put(9, new Client(UUID.randomUUID(), "Ivan", "Blanc", "ivan.blanc@example.com", false, "88 rue du Général Leclerc, 80000 Amiens, France"));
        this.clients.put(10, new Client(UUID.randomUUID(), "Julia", "Garcia", "julia.garcia@example.com", true, "19 rue des Écoles, 21000 Dijon, France"));
        this.clients.put(11, new Client(UUID.randomUUID(), "Kevin", "Noir", "kevin.noir@example.com", true, "6 square Jean Jaurès, 06000 Nice, France"));
    }

    @Override
    public Client get(int clientId) {
        if(clients.containsKey(clientId)) {
            return this.clients.get(clientId);
        }
        throw new ClientNotFoundException(clientId);
    }

    @Override
    public void save(Client client) {
        this.clients.put(UUID.randomUUID(), client);
    }

}
