package order.domain.exceptions;

import java.util.UUID;

public class InvalidShoeSizeException  extends Exception {

    public InvalidShoeSizeException(UUID hiShoeReference) {
        super("Reference " + hiShoeReference + " has illegal argument." +
                "La taille de chaussure doit être un nombre entier ou une demi-pointure (ex: 42, 42.5).");
    }

}
