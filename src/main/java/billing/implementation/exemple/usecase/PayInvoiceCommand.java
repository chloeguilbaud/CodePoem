package billing.implementation.exemple.usecase;

/**
 * Commande utilisée pour payer une facture.
 * Elle contient les informations nécessaires pour traiter le paiement.
 */
public class PayInvoiceCommand {
    private final String invoiceId;

    public PayInvoiceCommand(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }
}

