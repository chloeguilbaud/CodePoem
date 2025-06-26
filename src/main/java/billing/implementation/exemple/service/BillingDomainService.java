package billing.implementation.exemple.service;

import billing.implementation.exemple.domain.exceptions.InvalidInvoiceItemListException;
import billing.implementation.exemple.domain.model.HiShoe;
import billing.implementation.exemple.domain.model.Invoice;
import billing.implementation.exemple.domain.model.InvoiceItem;
import billing.implementation.exemple.domain.port.repositories.SaveInvoiceRepository;
import billing.implementation.exemple.usecase.CreateInvoiceCommand;
import billing.implementation.exemple.usecase.CreateInvoiceUseCase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BillingDomainService implements CreateInvoiceUseCase {


    private SaveInvoiceRepository saveInvoiceRepository;

    @Override
    public void handle(CreateInvoiceCommand command) throws InvalidInvoiceItemListException {
        // prend une commande validée,

        // génère une facture
        List<InvoiceItem> invoiceItems = new ArrayList<>();
        for (HiShoe shoe : command.getProducts()) {
            invoiceItems.add(
                    new InvoiceItem(
                            InvoiceItem.createShoeDescription(
                                    shoe.getModel(), shoe.getColor(), shoe.getSize())));
        }
        Invoice invoice = new Invoice(UUID.randomUUID(), new Date(), invoiceItems, command.getClient());

        // et la sauvegarde,
        saveInvoiceRepository.save(invoice);

    }
}
