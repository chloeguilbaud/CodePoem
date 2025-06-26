package billing.implementation.exemple.domain.model;

import order.domain.model.HISHOE_COLOR;
import order.domain.model.HISHOE_MODEL;

import java.util.UUID;

public class InvoiceItem {

    private final String description;

    public InvoiceItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static String createShoeDescription(HISHOE_MODEL model, HISHOE_COLOR color, double size) {
        return model + " - " + color + " (taille : " + size + ")";
    }
}
