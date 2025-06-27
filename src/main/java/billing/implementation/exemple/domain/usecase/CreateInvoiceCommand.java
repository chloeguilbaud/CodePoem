package billing.implementation.exemple.domain.usecase;

import billing.implementation.exemple.domain.model.Client;
import billing.implementation.exemple.domain.model.HiShoe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Commande utilisée pour créer une facture.
 * Elle encapsule les données nécessaires à l'exécution du cas d'utilisation CreateInvoiceUseCase.
 */
public class CreateInvoiceCommand {

    private final UUID client;
    private final List<HiShoe> products;

    public CreateInvoiceCommand(UUID clientId, List<HiShoe> products) {
        this.client = clientId;
        this.products = products;
    }

    public UUID getClient() {
        return client;
    }

    public List<HiShoe> getProducts() {
        return products;
    }
}

