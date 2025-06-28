package billing.implementation.exemple.domain.service;

import billing.implementation.exemple.domain.model.Invoice;
import billing.implementation.exemple.domain.port.repositories.InvoiceRepository;
import billing.implementation.exemple.domain.usecase.PayInvoiceCommand;
import billing.implementation.exemple.domain.usecase.PayInvoiceUseCase;
import org.springframework.stereotype.Service;

@Service
public class PaymentHandler implements PayInvoiceUseCase {

    private InvoiceRepository invoiceRepository;

    public PaymentHandler(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public void handle(PayInvoiceCommand command) {
        // Ajouter un paiement à la facture
        Invoice invoice = command.getInvoice();
        invoice.pay(command.getPaymentDetail());

        // Persister l'information en base de donneés
        invoiceRepository.save(invoice);

    }
}
