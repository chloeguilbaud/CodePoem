package billing.implementation.exemple.infrastructure.repositories;

import billing.implementation.exemple.domain.exceptions.InvalidHiShoePriceException;
import billing.implementation.exemple.domain.model.HiShoe;
import billing.implementation.exemple.domain.port.repositories.InvoiceHiShoeRepository;
import order.domain.exceptions.HiShoeNotFoundException;
import order.infrastructure.repositories.InMemoryHiShoeRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class InMemoryInvoiceHiShoeRepository implements InvoiceHiShoeRepository {

    private InMemoryHiShoeRepository hiShoeRepository;

    public InMemoryInvoiceHiShoeRepository(InMemoryHiShoeRepository hiShoeRepository) {
        this.hiShoeRepository = hiShoeRepository;
    }

    @Override
    public HiShoe findById(UUID shoeId) throws HiShoeNotFoundException {
        try {
            return contextMapper(hiShoeRepository.get(shoeId));
        } catch (InvalidHiShoePriceException e) {
            throw new RuntimeException(e);
        }
    }

    HiShoe contextMapper(order.domain.model.HiShoe shoe) throws InvalidHiShoePriceException {
        return new HiShoe(shoe.getReference(), shoe.getReference().toString(),
                shoe.getPrice(), shoe.getModel(), shoe.getColor(), shoe.getSize());
    }
}
