package billing.implementation.exemple.usecase;

/**
 * Interface représentant le cas d'utilisation pour créer une facture.
 * Elle définit les méthodes nécessaires pour initier une facture dans le domaine.
 */
public interface CreateInvoiceUseCase {
    void handle(CreateInvoiceCommand command);
}


