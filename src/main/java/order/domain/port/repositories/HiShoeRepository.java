package order.domain.port.repositories;

import order.domain.exceptions.HiShoeNotFoundException;
import order.domain.model.HiShoe;

public interface HiShoeRepository {

    HiShoe get(int hiShoeReference) throws HiShoeNotFoundException;

}
