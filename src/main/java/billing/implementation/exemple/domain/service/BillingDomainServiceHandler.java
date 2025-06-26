package billing.implementation.exemple.domain.service;

import billing.implementation.exemple.domain.exceptions.InvalidInvoiceItemListException;
import billing.implementation.exemple.domain.exceptions.InvalidInvoiceListQuantityException;
import billing.implementation.exemple.domain.model.HiShoe;
import billing.implementation.exemple.domain.model.Invoice;
import billing.implementation.exemple.domain.model.InvoiceLine;
import billing.implementation.exemple.domain.model.InvoiceStatus;
import billing.implementation.exemple.domain.port.repositories.InvoiceRepository;
import billing.implementation.exemple.domain.usecase.*;

import java.util.*;

public class BillingDomainServiceHandler implements CreateInvoiceUseCase, PayInvoiceUseCase, GetInvoiceByIdUseCase {


    private InvoiceRepository invoiceRepository;

    @Override
    public void handle(CreateInvoiceCommand command) throws InvalidInvoiceItemListException, InvalidInvoiceListQuantityException {
        // prend une commande validée,



        // génère une facture
        HashMap<String, HiShoe> orderProductList = new HashMap<>();

        List<InvoiceLine> invoiceLines = new ArrayList<>();

        for (HiShoe shoe : command.getProducts()) {
            // Si le produit existe déjà sur la facture, augmenter la quantité produit
            // sur la ligne de facturation
            addOrUpdateLine(invoiceLines,
                    new InvoiceLine(
                            InvoiceLine.createShoeDescription(
                                    shoe.getModel(), shoe.getColor(), shoe.getSize()),
                            shoe.getReferenceProduit(),
                            shoe.getPrice(),
                            1
                    ));
        }
        Invoice invoice = new Invoice(
                UUID.randomUUID(), new Date(),
                invoiceLines, command.getClient(),
                InvoiceStatus.ISSUED);

        // et la sauvegarde,
        invoiceRepository.save(invoice);

    }

    public void addOrUpdateLine(List<InvoiceLine> lines, InvoiceLine newLine) throws InvalidInvoiceListQuantityException {
        for (InvoiceLine line : lines) {
            if (line.equals(newLine)) {
                line.setQuantity(line.getQuantity() + newLine.getQuantity());
                return; // doublon trouvé, quantité mise à jour
            }
        }
        lines.add(newLine); // pas de doublon, on ajoute
    }

    @Override
    public void handle(PayInvoiceCommand command) {
        // Ajouter un paiement à la facture
        Invoice invoice = command.getInvoice();
        invoice.pay(command.getPaymentDetail());

        // Persister l'information en base de donneés
        invoiceRepository.save(invoice);

    }

    @Override
    public Invoice handle(InvoiceQuery query) {

        // Récupérer la facture
        return invoiceRepository.findById(query.getInvoiceId());

    }
}
