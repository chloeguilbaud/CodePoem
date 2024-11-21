package hiweb.conference.codepoem.order.domain.service;

import hiweb.conference.codepoem.order.domain.model.Client;
import hiweb.conference.codepoem.order.domain.model.HiShoe;
import hiweb.conference.codepoem.order.domain.model.Order;

import java.util.UUID;

public class CreateOrderService {

    public Order createOrder(Client client, HiShoe hiShoe) {

        // éventuel traitement métier
        // ...

        // génération de l'identifiant de commande
        UUID orderID = UUID.randomUUID();

        return new Order(orderID, client, hiShoe);

    }

}
