package billing.implementation.exemple.domain.port.repositories;

import billing.implementation.exemple.domain.exceptions.InvalidHiShoePriceException;
import billing.implementation.exemple.domain.model.Client;
import billing.implementation.exemple.domain.model.HiShoe;
import order.domain.exceptions.HiShoeNotFoundException;

import java.util.UUID;

public interface InvoiceHiShoeRepository {
    HiShoe findById(UUID shoeId) throws HiShoeNotFoundException;
}
