package billing.implementation.exemple.application.controllers;


import billing.implementation.exemple.domain.model.HiShoe;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class InvoiceRequest {
    private UUID clientId;
    private HashMap<UUID, Integer> products;
    private List<UUID> productsIds;
    private List<Integer> qts;

    public InvoiceRequest(UUID clientId, HashMap<UUID, Integer> products, List<UUID> productsIds, List<Integer> qts) {
        this.clientId = clientId;
        this.products = products;
        this.productsIds = productsIds;
        this.qts = qts;
    }

    public UUID getClientId() {
        return clientId;
    }

    public HashMap<UUID, Integer> getProducts() {
        return products;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public void setProducts(HashMap<UUID, Integer> products) {
        this.products = products;
    }

    public List<UUID> getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(List<UUID> productsIds) {
        this.productsIds = productsIds;
    }

    public List<Integer> getQts() {
        return qts;
    }

    public void setQts(List<Integer> qts) {
        this.qts = qts;
    }
}
