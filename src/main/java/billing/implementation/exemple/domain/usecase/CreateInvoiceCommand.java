package billing.implementation.exemple.domain.usecase;

import billing.implementation.exemple.domain.model.Client;
import billing.implementation.exemple.domain.model.HiShoe;

import java.util.List;

/**
 * Commande utilisée pour créer une facture.
 * Elle encapsule les données nécessaires à l'exécution du cas d'utilisation CreateInvoiceUseCase.
 */
public class CreateInvoiceCommand {

    private final Client client;
    private final List<HiShoe> products;

    public CreateInvoiceCommand(Client client, List<HiShoe> products) {
        this.client = client;
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public List<HiShoe> getProducts() {
        return products;
    }
}

