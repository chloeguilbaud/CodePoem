package billing.implementation.exemple.usecase;

/**
 * Commande utilisée pour créer une facture.
 * Elle encapsule les données nécessaires à l'exécution du cas d'utilisation CreateInvoiceUseCase.
 */
public class CreateInvoiceCommand {
    private final String clientId;
    private final double amount;

    public CreateInvoiceCommand(String clientId, double amount) {
        this.clientId = clientId;
        this.amount = amount;
    }

    public String getClientId() {
        return clientId;
    }

    public double getAmount() {
        return amount;
    }
}

