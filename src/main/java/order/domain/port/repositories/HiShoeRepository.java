package order.domain.port.repositories;

import order.domain.exceptions.HiShoeNotFoundException;
import order.domain.model.HiShoe;

import java.util.UUID;

public interface HiShoeRepository {

    HiShoe get(UUID hiShoeReference) throws HiShoeNotFoundException;

}
