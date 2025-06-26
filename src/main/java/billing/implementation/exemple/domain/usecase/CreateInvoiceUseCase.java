package billing.implementation.exemple.domain.usecase;

import billing.implementation.exemple.domain.exceptions.InvalidInvoiceItemListException;
import billing.implementation.exemple.domain.exceptions.InvalidInvoiceListQuantityException;

/**
 * Interface représentant le cas d'utilisation pour créer une facture.
 * Elle définit les méthodes nécessaires pour initier une facture dans le domaine.
 */
public interface CreateInvoiceUseCase {
    void handle(CreateInvoiceCommand command) throws InvalidInvoiceItemListException, InvalidInvoiceListQuantityException;
}


