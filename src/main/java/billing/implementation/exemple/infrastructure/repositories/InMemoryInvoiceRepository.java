package billing.implementation.exemple.infrastructure.repositories;

import billing.implementation.exemple.domain.exceptions.InvalidHiShoePriceException;
import billing.implementation.exemple.domain.exceptions.InvalidInvoiceItemListException;
import billing.implementation.exemple.domain.model.*;
import billing.implementation.exemple.domain.port.repositories.InvoiceRepository;
import order.domain.model.HISHOE_COLOR;
import order.domain.model.HISHOE_MODEL;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryInvoiceRepository implements InvoiceRepository {

    private final HashMap<UUID, Invoice> invoices;

    public InMemoryInvoiceRepository() throws InvalidHiShoePriceException, InvalidInvoiceItemListException {
        this.invoices = new HashMap<>();

        // ===== FACTURE 1 =====
        Client client1 = new Client("John", "Doe", "john.doe@example.com", "123 Main Street, Paris");
        HiShoe shoe1 = new HiShoe(UUID.randomUUID(), "HS-001", 79.99, HISHOE_MODEL.BISTRO_CLOG, HISHOE_COLOR.BLACK, 42);
        InvoiceLine line1 = new InvoiceLine(shoe1.getReferenceProduit(), "Black sneakers", shoe1.getPrice(), 2);
        List<InvoiceLine> itemList1 = List.of(line1);
        double total1 = itemList1.stream().mapToDouble(InvoiceLine::getTotal).sum();
        PayerInformations payer1 = new PayerInformations("John", "Doe", "john.doe@example.com", "123 Main Street, Paris");
        PaymentDetail payment1 = new PaymentDetail(100.0, new Date(), PaymentMethod.CREDIT_CARD, payer1);
        UUID invoiceId1 = UUID.fromString("11111111-1111-1111-1111-111111111111");
        Invoice invoice1 = new Invoice(
                invoiceId1,
                new Date(),
                itemList1,
                client1
        );
        invoices.put(invoiceId1, invoice1);

        // ===== FACTURE 2 =====
        Client client2 = new Client("Alice", "Smith", "alice.smith@example.com", "456 Oak Avenue, Lyon");
        HiShoe shoe2 = new HiShoe(UUID.randomUUID(), "HS-002", 129.99, HISHOE_MODEL.CLASSIC_CLOG, HISHOE_COLOR.RED, 39);
        InvoiceLine line2 = new InvoiceLine(shoe2.getReferenceProduit(), "Brown leather boots", shoe2.getPrice(), 1);
        List<InvoiceLine> itemList2 = List.of(line2);
        double total2 = itemList2.stream().mapToDouble(InvoiceLine::getTotal).sum();
        UUID invoiceId2 = UUID.randomUUID();
        Invoice invoice2 = new Invoice(
                invoiceId2,
                new Date(),
                itemList2,
                client2
        );
        invoices.put(invoiceId2, invoice2);

        // ===== FACTURE 3 =====
        Client client3 = new Client("Marc", "Durand", "marc.durand@example.com", "789 Rue Bleue, Marseille");
        HiShoe shoe3a = new HiShoe(UUID.randomUUID(), "HS-003", 49.99, HISHOE_MODEL.LITERIDE_CLOG, HISHOE_COLOR.WHITE, 43);
        HiShoe shoe3b = new HiShoe(UUID.randomUUID(), "HS-004", 59.99, HISHOE_MODEL.BISTRO_CLOG, HISHOE_COLOR.RED, 44);
        InvoiceLine line3a = new InvoiceLine(shoe3a.getReferenceProduit(), "White loafers", shoe3a.getPrice(), 1);
        InvoiceLine line3b = new InvoiceLine(shoe3b.getReferenceProduit(), "Red sneakers", shoe3b.getPrice(), 2);
        List<InvoiceLine> itemList3 = List.of(line3a, line3b);
        double total3 = itemList3.stream().mapToDouble(InvoiceLine::getTotal).sum();
        PayerInformations payer3 = new PayerInformations("Marc", "Durand", "marc.durand@example.com", "789 Rue Bleue, Marseille");
        PaymentDetail payment3 = new PaymentDetail(total3, new Date(), PaymentMethod.BANK_TRANSFER, payer3);
        UUID invoiceId3 = UUID.randomUUID();
        Invoice invoice3 = new Invoice(
                invoiceId3,
                new Date(),
                itemList3,
                client3
        );
        invoices.put(invoiceId3, invoice3);

    }


    @Override
    public void save(Invoice invoice) {
        this.invoices.put(invoice.getInvoiceId(), invoice);
    }

    @Override
    public Invoice findById(UUID id) {
        return this.invoices.get(id);
    }
}
