package hiweb.conference.codepoem.order.domain.port.repositories;

import hiweb.conference.codepoem.order.domain.exceptions.HiShoeNotFoundException;
import hiweb.conference.codepoem.order.domain.model.HiShoe;

public interface HiShoeRepository {

    HiShoe get(int hiShoeReference) throws HiShoeNotFoundException;

}
