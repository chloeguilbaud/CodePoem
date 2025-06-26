package billing.implementation.exemple.domain.usecase;

import billing.implementation.exemple.domain.model.Invoice;

// « Je veux retrouver une facture »
public interface GetInvoiceByIdUseCase {

    Invoice handle(InvoiceQuery query);
}
