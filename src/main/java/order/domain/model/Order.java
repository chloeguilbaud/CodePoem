package order.domain.model;

import java.util.UUID;

public class Order {

    private UUID id;
    private Client client;
    private HiShoe products;

    public Order(UUID id, Client client, HiShoe product) {
        this.id = id;
        this.client = client;
        this.products = product;
    }

    public UUID getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public HiShoe getProducts() {
        return products;
    }

}
