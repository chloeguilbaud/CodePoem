package billing.implementation.exemple.service;

import billing.implementation.exemple.model.Invoice;
import billing.implementation.exemple.usecase.CreateInvoiceUseCase;

import java.util.Date;
import java.util.List;

public class CreateInvoiceService implements CreateInvoiceUseCase {

    @Override
    public Invoice createInvoice(String invoiceId, List<String> items, double totalAmount) {
        return new Invoice(invoiceId, new Date(), items, totalAmount);

    }
}
