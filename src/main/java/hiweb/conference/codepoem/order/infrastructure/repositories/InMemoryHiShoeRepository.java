package hiweb.conference.codepoem.order.infrastructure.repositories;

import hiweb.conference.codepoem.order.domain.model.HISHOE_COLOR;
import hiweb.conference.codepoem.order.domain.model.HISHOE_MODEL;
import hiweb.conference.codepoem.order.domain.model.HiShoe;
import hiweb.conference.codepoem.order.domain.port.repositories.HiShoeNotFoundException;
import hiweb.conference.codepoem.order.domain.port.repositories.HiShoeRepository;

import java.util.HashMap;

public class InMemoryHiShoeRepository implements HiShoeRepository {

    private final HashMap<Integer, HiShoe> hiShoes;

    public InMemoryHiShoeRepository() {
        this.hiShoes = new HashMap<>();
        this.hiShoes.put(1, new HiShoe(1, HISHOE_MODEL.BISTRO_CLOG, HISHOE_COLOR.BLUE, 35.5F));
        this.hiShoes.put(2, new HiShoe(2, HISHOE_MODEL.CLASSIC_CLOG, HISHOE_COLOR.YELLOW, 39.5F));
        this.hiShoes.put(3, new HiShoe(3, HISHOE_MODEL.hiShoeBAND_CLOG, HISHOE_COLOR.BLUE, 31.5F));
        this.hiShoes.put(4, new HiShoe(4, HISHOE_MODEL.BISTRO_CLOG, HISHOE_COLOR.BLACK, 35F));
    }

    @Override
    public HiShoe get(int hiShoeReference) throws HiShoeNotFoundException {
        if(hiShoes.containsKey(hiShoeReference)) {
            return this.hiShoes.get(hiShoeReference);
        }
        throw new HiShoeNotFoundException(hiShoeReference);
    }

}
