package order.domain.port.dispatchers;

import order.domain.events.OrderHasBeenCreated;

public interface EventDispatcher {

    void dispatch(OrderHasBeenCreated orderHasBeenCreated);

} 
