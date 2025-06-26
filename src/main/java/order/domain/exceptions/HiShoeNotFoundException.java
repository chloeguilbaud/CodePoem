package order.domain.exceptions;

public class HiShoeNotFoundException extends Exception {

    public HiShoeNotFoundException(int hiShoeReference) {
        super("Reference " + hiShoeReference + " was not found");
    }
}
