package billing.implementation.exemple.service;

import billing.implementation.exemple.domain.exceptions.InvalidInvoiceItemListException;
import billing.implementation.exemple.domain.model.Client;
import billing.implementation.exemple.domain.model.Invoice;
import billing.implementation.exemple.domain.model.InvoiceItem;
import billing.implementation.exemple.usecase.CreateInvoiceUseCase;
import order.domain.model.HiShoe;
import order.domain.model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CreateInvoiceService implements CreateInvoiceUseCase {


    @Override
    public Invoice createInvoice(Order order) throws InvalidInvoiceItemListException {
        // prend une commande validée,
        // génère une facture

        List<InvoiceItem> invoiceItems = new ArrayList<>();
        for (HiShoe shoe : order.getProducts()) {
            invoiceItems.add(
                    new InvoiceItem(
                    InvoiceItem.createShoeDescription(
                            shoe.getModel(), shoe.getColor(), shoe.getSize())));
        }

        Client client = orderClientToBillingClientBoundContextMapper(order.getClient());

        Invoice invoice = new Invoice(UUID.randomUUID(), new Date(), invoiceItems, client);

        // et la sauvegarde,

        return new Invoice(invoiceId, new Date(), items, totalAmount);

    }

    private Client orderClientToBillingClientBoundContextMapper(order.domain.model.Client client) {
        return new Client
    }
}
