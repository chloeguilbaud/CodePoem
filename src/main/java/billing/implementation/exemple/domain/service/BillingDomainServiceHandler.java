package billing.implementation.exemple.domain.service;

import billing.implementation.exemple.domain.exceptions.InvalidInvoiceItemListException;
import billing.implementation.exemple.domain.exceptions.InvalidInvoiceListQuantityException;
import billing.implementation.exemple.domain.model.*;
import billing.implementation.exemple.domain.port.repositories.InvoiceClientRepository;
import billing.implementation.exemple.domain.port.repositories.InvoiceHiShoeRepository;
import billing.implementation.exemple.domain.port.repositories.InvoiceRepository;
import billing.implementation.exemple.domain.usecase.*;
import order.domain.exceptions.HiShoeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BillingDomainServiceHandler implements CreateInvoiceUseCase, GetInvoiceByIdUseCase {


    private InvoiceRepository invoiceRepository;
    private InvoiceClientRepository clientRepository;
    private InvoiceHiShoeRepository hiShoeRepository;

    public BillingDomainServiceHandler(InvoiceRepository invoiceRepository, InvoiceClientRepository clientRepository, InvoiceHiShoeRepository hiShoeRepository) {
        this.invoiceRepository = invoiceRepository;
        this.clientRepository = clientRepository;
        this.hiShoeRepository = hiShoeRepository;
    }

    @Override
    public Invoice handle(CreateInvoiceCommand command) throws InvalidInvoiceItemListException, InvalidInvoiceListQuantityException, HiShoeNotFoundException {
        // prend une commande validée,


        // génèrer une facture
        HashMap<String, HiShoe> orderProductList = new HashMap<>();

        List<InvoiceLine> invoiceLines = new ArrayList<>();

        for (Map.Entry<UUID, Integer> entry : command.getProducts().entrySet()) {
            UUID hishoeRef = entry.getKey();
            Integer qt = entry.getValue();
            HiShoe shoe = null;
            shoe = hiShoeRepository.findById(hishoeRef);
            // Si le produit existe déjà sur la facture, augmenter la quantité produit
            // sur la ligne de facturation
            addOrUpdateLine(invoiceLines,
                    new InvoiceLine(
                            InvoiceLine.createShoeDescription(
                                    shoe.getModel(), shoe.getColor(), shoe.getSize()),
                            shoe.getReferenceProduit(),
                            shoe.getPrice(),
                            qt
                    ));
        }
        Client client = clientRepository.findById(command.getClient());
        Invoice invoice = new Invoice(
                UUID.randomUUID(), new Date(),
                invoiceLines, client);

        // et la sauvegarde,
        invoiceRepository.save(invoice);

        return invoice;
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
    public Invoice handle(InvoiceQuery query) {

        // Récupérer la facture
        return invoiceRepository.findById(query.getInvoiceId());

    }
}
