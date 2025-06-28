package order.domain.model;

import java.util.List;
import java.util.UUID;

public class Order {

    private UUID id;
    private Client client;
    private HiShoe product;

    public Order(UUID id, Client client, HiShoe product) {
        this.id = id;
        this.client = client;
        this.product = product;
    }

    public UUID getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public HiShoe getProduct() {
        return product;
    }

}
