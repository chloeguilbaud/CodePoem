package billing.implementation.exemple.domain.model;

import billing.implementation.exemple.domain.exceptions.InvalidHiShoePriceException;
import order.domain.model.HISHOE_COLOR;
import order.domain.model.HISHOE_MODEL;

import java.util.UUID;

public class HiShoe {

    private UUID hiShoeId;
    private final double price;
    private final HISHOE_MODEL model;
    private final HISHOE_COLOR color;
    private final double size;

    public HiShoe(UUID hiShoeId, double price, String description, HISHOE_MODEL model, HISHOE_COLOR color, double size) throws InvalidHiShoePriceException {
        this.model = model;
        this.color = color;
        this.size = size;
        if(price < 0) throw new InvalidHiShoePriceException(hiShoeId);
        this.price = price;
    }

    public UUID getHiShoeId() {
        return hiShoeId;
    }

    public double getPrice() {
        return price;
    }

    public HISHOE_MODEL getModel() {
        return model;
    }

    public HISHOE_COLOR getColor() {
        return color;
    }

    public double getSize() {
        return size;
    }
}
