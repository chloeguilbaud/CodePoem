package order.domain.exceptions;

import java.util.UUID;

public class HiShoeNotFoundException extends Exception {

    public HiShoeNotFoundException(UUID hiShoeReference) {
        super("Reference " + hiShoeReference + " was not found");
    }
}
