package billing.implementation.exemple.usecase;

/**
 * Interface représentant le cas d'utilisation pour payer une facture.
 * Elle assure que la logique métier liée au paiement est centralisée et indépendante des détails techniques.
 */
public interface PayInvoiceUseCase {
    void handle(PayInvoiceCommand command);
}

