package order.domain.port.usecases;

import common.Command;

import java.util.UUID;

public class RegisterOrderCommand implements Command {

    private final UUID clientId;
    private final UUID hiShoeReference;

    public RegisterOrderCommand(UUID clientId, UUID hiShoeReference)
    {
        this.clientId = clientId;
        this.hiShoeReference = hiShoeReference;
    }

    public UUID getClientId() {
        return clientId;
    }

    public UUID getHiShoeReference() {
        return hiShoeReference;
    }

}
