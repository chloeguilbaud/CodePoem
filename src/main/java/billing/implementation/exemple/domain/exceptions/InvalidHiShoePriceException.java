package billing.implementation.exemple.domain.exceptions;

import java.util.UUID;

public class InvalidHiShoePriceException extends Exception {

    public InvalidHiShoePriceException(UUID hiShoeId) {
        super("HiShoe référence n°" + hiShoeId + " has illegal argument." +
                "Le prix d'une chaussure est strictement suppérieur à 0€.");
    }

}