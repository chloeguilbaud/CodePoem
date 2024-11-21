package hiweb.conference.codepoem.order.domain.port.usecases;

import hiweb.conference.codepoem.ddd.Command;

public class RegisterOrderCommand implements Command {

    private final int clientId;
    private final int hiShoeReference;

    public RegisterOrderCommand(int clientId, int hiShoeReference) {
        this.clientId = clientId;
        this.hiShoeReference = hiShoeReference;
    }

    public int getClientId() {
        return clientId;
    }

    public int getHiShoeReference() {
        return hiShoeReference;
    }

}
