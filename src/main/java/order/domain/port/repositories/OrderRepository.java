package order.domain.port.repositories;

import order.domain.exceptions.HiShoeNotFoundException;
import order.domain.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {

    void save(Order order) throws HiShoeNotFoundException;

}
