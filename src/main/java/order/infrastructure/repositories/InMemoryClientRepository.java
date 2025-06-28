package order.infrastructure.repositories;

import order.domain.exceptions.ClientNotFoundException;
import order.domain.model.Client;
import order.domain.port.repositories.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class InMemoryClientRepository implements ClientRepository {

    private final HashMap<UUID, Client> clients;

    public InMemoryClientRepository() {
        this.clients = new HashMap<>();

        UUID id1 = UUID.fromString("11111111-1111-1111-1111-111111111111");
        this.clients.put(id1, new Client(id1, "Alice", "Dupont", "alice.dupont@example.com", true, "12 rue des Lilas, 75020 Paris, France"));

        UUID id2 = UUID.fromString("22222222-2222-2222-2222-222222222222");
        this.clients.put(id2, new Client(id2, "Bob", "Martin", "bob.martin@example.com", false, "8 avenue Victor Hugo, 33000 Bordeaux, France"));

        UUID id3 = UUID.fromString("33333333-3333-3333-3333-333333333333");
        this.clients.put(id3, new Client(id3, "Charlie", "Durand", "charlie.durand@example.com", true, "25 boulevard Saint-Michel, 75005 Paris, France"));

        UUID id4 = UUID.fromString("44444444-4444-4444-4444-444444444444");
        this.clients.put(id4, new Client(id4, "Diana", "Lemoine", "diana.lemoine@example.com", false, "5 impasse des Acacias, 69008 Lyon, France"));

        UUID id5 = UUID.fromString("55555555-5555-5555-5555-555555555555");
        this.clients.put(id5, new Client(id5, "Eric", "Moreau", "eric.moreau@example.com", true, "17 rue de la République, 13001 Marseille, France"));

        UUID id6 = UUID.fromString("66666666-6666-6666-6666-666666666666");
        this.clients.put(id6, new Client(id6, "Fiona", "Roux", "fiona.roux@example.com", true, "42 allée des Cerisiers, 44300 Nantes, France"));

        UUID id7 = UUID.fromString("77777777-7777-7777-7777-777777777777");
        this.clients.put(id7, new Client(id7, "George", "Bernard", "george.bernard@example.com", false, "10 chemin du Vieux Moulin, 31000 Toulouse, France"));

        UUID id8 = UUID.fromString("88888888-8888-8888-8888-888888888888");
        this.clients.put(id8, new Client(id8, "Helen", "Petit", "helen.petit@example.com", true, "3 place de la Mairie, 67000 Strasbourg, France"));

        UUID id9 = UUID.fromString("99999999-9999-9999-9999-999999999999");
        this.clients.put(id9, new Client(id9, "Ivan", "Blanc", "ivan.blanc@example.com", false, "88 rue du Général Leclerc, 80000 Amiens, France"));

        UUID id10 = UUID.fromString("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");
        this.clients.put(id10, new Client(id10, "Julia", "Garcia", "julia.garcia@example.com", true, "19 rue des Écoles, 21000 Dijon, France"));

        UUID id11 = UUID.fromString("bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb");
        this.clients.put(id11, new Client(id11, "Kevin", "Noir", "kevin.noir@example.com", true, "6 square Jean Jaurès, 06000 Nice, France"));


    }

    @Override
    public Client get(UUID clientId) {
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
