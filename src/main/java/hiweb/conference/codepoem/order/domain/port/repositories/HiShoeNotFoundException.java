package hiweb.conference.codepoem.order.domain.port.repositories;

public class HiShoeNotFoundException extends Exception {

    public HiShoeNotFoundException(int hiShoeReference) {
        super("Reference " + hiShoeReference + " was not found");
    }
}
