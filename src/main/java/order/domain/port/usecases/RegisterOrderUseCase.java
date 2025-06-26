package order.domain.port.usecases;

import order.domain.model.Client;
import order.domain.model.HiShoe;
import order.domain.model.Order;
import order.domain.events.OrderHasBeenCreated;
import order.domain.port.dispatchers.EventDispatcher;
import order.domain.port.repositories.ClientRepository;
import order.domain.exceptions.HiShoeNotFoundException;
import order.domain.port.repositories.HiShoeRepository;
import order.domain.port.repositories.OrderRepository;
import order.domain.service.CreateOrderService;

public class RegisterOrderUseCase {

    private ClientRepository clientRepository;
    private HiShoeRepository hiShoeRepository;
    private CreateOrderService createOrderService;
    private OrderRepository orderRepository;
    private EventDispatcher eventDispatcher;

    public RegisterOrderUseCase(ClientRepository clientRepository, HiShoeRepository hiShoeRepository,
                                CreateOrderService createOrderService, OrderRepository orderRepository,
                                EventDispatcher eventDispatcher) {
        this.clientRepository = clientRepository;
        this.hiShoeRepository = hiShoeRepository;
        this.createOrderService = createOrderService;
        this.orderRepository = orderRepository;
        this.eventDispatcher = eventDispatcher;
    }

    public void handle(RegisterOrderCommand registerOrderCommand) throws HiShoeNotFoundException {

        // identifier le client
        Client client = this.clientRepository.get(registerOrderCommand.getClientId());

        // identifier le produit
        HiShoe hiShoe = this.hiShoeRepository.get(registerOrderCommand.getHiShoeReference());

        // créer une commmande
        Order order = this.createOrderService.createOrder(client, hiShoe);

        // enregistrer la commande
        this.orderRepository.save(order);

        // dire à tout le monde que les hiShoes c'est cool et que les gens en commande !
        this.eventDispatcher.dispatch(new OrderHasBeenCreated(order.getId()));

        // en cas d'erreur, le domaine renvoie au controlleur l'erreur métier qui le transforme en erreur utilisateur
        // chaque couche sa responsabilité

    }


}
