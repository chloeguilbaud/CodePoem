package hiweb.conference.codepoem.exercice.billing.domain.model;

import java.util.Date;
import java.util.List;

public class Invoice {
    private final String invoiceId;
    private final Date issueDate;
    private final List<String> itemList; // List of item descriptions
    private final double totalAmount;
    private boolean isPaid;

    // Constructor
    public Invoice(String invoiceId, Date issueDate, List<String> itemList, double totalAmount) {
        this.invoiceId = invoiceId;
        this.issueDate = issueDate;
        this.itemList = itemList;
        this.totalAmount = totalAmount;
        this.isPaid = false; // Default state is unpaid
    }

    // Getters
    public String getInvoiceId() {
        return invoiceId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    // Business logic: Pay the invoice
    public void pay() {
        if (isPaid) {
            throw new IllegalStateException("Invoice already paid.");
        }
        this.isPaid = true;
    }
}
