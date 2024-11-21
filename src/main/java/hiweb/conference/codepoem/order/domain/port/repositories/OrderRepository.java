package hiweb.conference.codepoem.order.domain.port.repositories;

import hiweb.conference.codepoem.order.domain.model.Order;

public interface OrderRepository {

    void save(Order order);

}
