package billing.implementation.exemple.application.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InvoiceRequest {
    private UUID clientId;
    private HashMap<Integer, Integer> products;

    public InvoiceRequest(UUID clientId, HashMap<Integer, Integer> products) {
        this.clientId = clientId;
        this.products = products;
    }

    public UUID getClientId() {
        return clientId;
    }

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }
}
