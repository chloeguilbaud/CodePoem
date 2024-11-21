package hiweb.conference.codepoem.order.domain.port.dispatchers;

import hiweb.conference.codepoem.order.domain.model.events.OrderHasBeenCreated;

public interface EventDispatcher {

    void dispatch(OrderHasBeenCreated orderHasBeenCreated);

}
