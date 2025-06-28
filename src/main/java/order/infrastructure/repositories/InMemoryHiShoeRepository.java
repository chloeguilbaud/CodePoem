package order.infrastructure.repositories;

import order.domain.model.HISHOE_COLOR;
import order.domain.model.HISHOE_MODEL;
import order.domain.model.HiShoe;
import order.domain.exceptions.InvalidShoeSizeException;
import order.domain.exceptions.HiShoeNotFoundException;
import order.domain.port.repositories.HiShoeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class InMemoryHiShoeRepository implements HiShoeRepository {

    private final HashMap<UUID, HiShoe> hiShoes;

    public InMemoryHiShoeRepository() throws InvalidShoeSizeException {
        this.hiShoes = new HashMap<>();

        UUID idA = UUID.fromString("A1111111-1111-1111-1111-111111111111");
        this.hiShoes.put(idA, new HiShoe(idA, HISHOE_MODEL.BISTRO_CLOG, HISHOE_COLOR.BLUE, 35.5F, 69.00));

        UUID idB = UUID.fromString("B1111111-1111-1111-1111-111111111111");
        this.hiShoes.put(idB, new HiShoe(idB, HISHOE_MODEL.CLASSIC_CLOG, HISHOE_COLOR.YELLOW, 39.5F, 65.98));

        UUID idC = UUID.fromString("C1111111-1111-1111-1111-111111111111");
        this.hiShoes.put(idC, new HiShoe(idC, HISHOE_MODEL.hiShoeBAND_CLOG, HISHOE_COLOR.BLUE, 31.5F, 65.97));

        UUID idD = UUID.fromString("D1111111-1111-1111-1111-111111111111");
        this.hiShoes.put(idD, new HiShoe(idD, HISHOE_MODEL.BISTRO_CLOG, HISHOE_COLOR.BLACK, 35F, 34.00));
    }

    @Override
    public HiShoe get(UUID hiShoeReference) throws HiShoeNotFoundException {
        if(hiShoes.containsKey(hiShoeReference)) {
            return this.hiShoes.get(hiShoeReference);
        }
        throw new HiShoeNotFoundException(hiShoeReference);
    }

}
