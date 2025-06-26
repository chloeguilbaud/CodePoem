package hiweb.conference.codepoem.order.domain.model;

import hiweb.conference.codepoem.order.domain.exceptions.InvalidShoeSizeException;

public class HiShoe {

    private int reference;
    private HISHOE_MODEL model;
    private HISHOE_COLOR color;
    private float size;

    public HiShoe(int reference, HISHOE_MODEL model, HISHOE_COLOR color, float size) throws InvalidShoeSizeException {
        this.reference = reference;
        this.model = model;
        this.color = color;
        if (!validSize(size)) throw new InvalidShoeSizeException(reference);
        this.size = size;
    }

    private boolean validSize(double size) {
        return size >= 0 && (size * 2) == Math.floor(size * 2);
    }

    public int getReference() {
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
}
