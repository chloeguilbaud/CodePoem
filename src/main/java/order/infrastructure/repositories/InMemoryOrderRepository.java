package order.infrastructure.repositories;

import jakarta.annotation.PostConstruct;
import order.domain.exceptions.HiShoeNotFoundException;
import order.domain.model.Client;
import order.domain.model.Order;
import order.domain.port.repositories.ClientRepository;
import order.domain.port.repositories.HiShoeRepository;
import order.domain.port.repositories.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private ClientRepository clientRepository;
    private HiShoeRepository hiShoeRepository;

    private Map<UUID, Order> orders;

    public InMemoryOrderRepository(ClientRepository clientRepository, HiShoeRepository hiShoeRepository) {
        this.clientRepository = clientRepository;
        this.hiShoeRepository = hiShoeRepository;
    }

    @PostConstruct
    public void init() throws HiShoeNotFoundException {
        orders = new HashMap<>();

        UUID order1Id = UUID.fromString("aaaaaaa1-0000-0000-0000-000000000001");
        orders.put(order1Id, new Order(order1Id, clientRepository.get(UUID.fromString("99999999-9999-9999-9999-999999999999")), hiShoeRepository.get(UUID.fromString("D1111111-1111-1111-1111-111111111111"))));

        UUID order2Id = UUID.fromString("aaaaaaa2-0000-0000-0000-000000000002");
        orders.put(order2Id, new Order(order2Id, clientRepository.get(UUID.fromString("99999999-9999-9999-9999-999999999999")), hiShoeRepository.get(UUID.fromString("B1111111-1111-1111-1111-111111111111"))));

        UUID order3Id = UUID.fromString("aaaaaaa3-0000-0000-0000-000000000003");
        orders.put(order3Id, new Order(order3Id, clientRepository.get(UUID.fromString("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa")), hiShoeRepository.get(UUID.fromString("C1111111-1111-1111-1111-111111111111"))));

        UUID order4Id = UUID.fromString("aaaaaaa4-0000-0000-0000-000000000004");
        orders.put(order4Id, new Order(order4Id, clientRepository.get(UUID.fromString("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa")), hiShoeRepository.get(UUID.fromString("A1111111-1111-1111-1111-111111111111"))));

        UUID order5Id = UUID.fromString("aaaaaaa5-0000-0000-0000-000000000005");
        orders.put(order5Id, new Order(order5Id, clientRepository.get(UUID.fromString("bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb")), hiShoeRepository.get(UUID.fromString("D1111111-1111-1111-1111-111111111111"))));
    }

    @Override
    public void save(Order order) throws HiShoeNotFoundException {
        orders.put(order.getId(), order);
    }


}
