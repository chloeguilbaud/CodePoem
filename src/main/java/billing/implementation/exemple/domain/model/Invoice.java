package billing.implementation.exemple.domain.model;

import billing.implementation.exemple.domain.exceptions.InvalidInvoiceItemListException;
import billing.implementation.exemple.domain.exceptions.InvalidPaymentException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Invoice {

    private final UUID invoiceId;
    private final Date issueDate;
    private final List<InvoiceLine> itemList; // List of item descriptions
    private double totalAmount;
    private double totalAmountPayed;
    private final Client client;
    private boolean isPaid;
    private final List<PaymentDetail> paiementDetails;
    private InvoiceStatus status;

    // Constructor
    public Invoice(UUID invoiceId, Date issueDate, List<InvoiceLine> itemList, Client client) throws InvalidInvoiceItemListException {
        this.checkData(itemList);
        this.client = client;
        this.invoiceId = invoiceId;
        this.issueDate = issueDate;
        this.itemList = itemList;
        this.totalAmount = calculateTotalAmount();
        this.isPaid = false; // Default state is unpaid
        this.paiementDetails = new ArrayList<PaymentDetail>();
    }

    private double calculateTotalAmount() {
        double invoiceTotal = 0;
        for (InvoiceLine item : itemList) {
            this.totalAmount += item.getTotal();
        }
        return invoiceTotal;
    }

    private void checkData(List<InvoiceLine> itemList) throws InvalidInvoiceItemListException {
        // « une facture doit contenir au moins une ligne »,
        if (itemList == null || itemList.isEmpty()) {
            throw new InvalidInvoiceItemListException(invoiceId);
        }
    }

    // Getters
    public UUID getInvoiceId() {
        return invoiceId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public List<InvoiceLine> getItemList() {
        return itemList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    // Business logic: Pay the invoice
    // « la somme des paiements ne peut pas dépasser le montant dû »
    public void pay(PaymentDetail paymentDetail) {

        if (isPaid) {
            throw new IllegalStateException("Invoice already paid.");
        }

        if (this.totalAmountPayed + paymentDetail.getAmount() > this.totalAmount)
            throw new InvalidPaymentException(invoiceId);

        this.totalAmountPayed += paymentDetail.getAmount();
        this.status = InvoiceStatus.PARTIALLY_PAID;

        if (this.totalAmountPayed == this.totalAmount) {
            this.isPaid = true;
            this.status = InvoiceStatus.PAID;
        }

        this.paiementDetails.add(paymentDetail);

    }

    public Client getClient() {
        return client;
    }

    public List<PaymentDetail> getPaiementDetails() {
        return paiementDetails;
    }

    public InvoiceStatus getStatus() {
        return status;
    }
}
