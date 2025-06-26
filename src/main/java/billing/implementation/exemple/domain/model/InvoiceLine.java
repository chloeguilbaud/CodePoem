package billing.implementation.exemple.domain.model;

import billing.implementation.exemple.domain.exceptions.InvalidInvoiceListQuantityException;
import order.domain.model.HISHOE_COLOR;
import order.domain.model.HISHOE_MODEL;

import java.util.Objects;

public class InvoiceLine {

    private final String productReference;
    private final String description;
    private final double pricePerUnit;
    private int quantity;
    private double total;


    public InvoiceLine(String description, String productReference, double pricePerUnit, int quantity) {
        this.description = description;
        this.productReference = productReference;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.total = 0;
    }

    public String getDescription() {
        return description;
    }

    public static String createShoeDescription(HISHOE_MODEL model, HISHOE_COLOR color, double size) {
        return model + " - " + color + " (taille : " + size + ")";
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setQuantity(int quantity) throws InvalidInvoiceListQuantityException {
        if (quantity < 0) {
            throw new InvalidInvoiceListQuantityException();
        }
        this.quantity += quantity;
        this.total = this.quantity * pricePerUnit;
    }

    public String getProductReference() {
        return productReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceLine)) return false;
        InvoiceLine that = (InvoiceLine) o;
        return Objects.equals(productReference, that.productReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productReference);
    }


    public double getTotal() {
        return total;
    }
}
