package order.domain.events;

import java.util.UUID;

public class OrderHasBeenCreated {

    private UUID orderId;

    public OrderHasBeenCreated(UUID orderId) {
        this.orderId = orderId;
    }
}
