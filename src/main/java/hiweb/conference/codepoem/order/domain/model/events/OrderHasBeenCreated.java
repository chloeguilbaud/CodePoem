package hiweb.conference.codepoem.order.domain.model.events;

import java.util.UUID;

public class OrderHasBeenCreated {

    private UUID orderId;

    public OrderHasBeenCreated(UUID orderId) {
        this.orderId = orderId;
    }
}
