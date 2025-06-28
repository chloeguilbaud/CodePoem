package order.domain.service;

import order.domain.model.Client;
import order.domain.model.HiShoe;
import order.domain.model.Order;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateOrderService {

    public Order createOrder(Client client, HiShoe hiShoe) {

        // éventuel traitement métier
        // ...

        // génération de l'identifiant de commande
        UUID orderID = UUID.randomUUID();

        return new Order(orderID, client, hiShoe);

    }

}
