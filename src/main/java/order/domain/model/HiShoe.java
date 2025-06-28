package order.domain.model;

import order.domain.exceptions.InvalidShoeSizeException;

import java.util.UUID;

public class HiShoe {

    private UUID reference;
    private HISHOE_MODEL model;
    private HISHOE_COLOR color;
    private float size;
    private double price;

    public HiShoe(UUID reference, HISHOE_MODEL model, HISHOE_COLOR color, float size, double price) throws InvalidShoeSizeException {
        this.reference = reference;
        this.model = model;
        this.color = color;
        this.price = price;
        if (!validSize(size)) throw new InvalidShoeSizeException(reference);
        this.size = size;
    }

    private boolean validSize(double size) {
        return size >= 0 && (size * 2) == Math.floor(size * 2);
    }

    public UUID getReference() {
        return reference;
    }

    public HISHOE_MODEL getModel() {
        return model;
    }

    public HISHOE_COLOR getColor() {
        return color;
    }

    public float getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}
