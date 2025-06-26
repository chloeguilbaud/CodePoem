package order.domain.port.repositories;

import order.domain.model.Order;

public interface OrderRepository {

    void save(Order order);

}
