package order.domain.port.usecases;

import billing.implementation.exemple.domain.usecase.CreateInvoiceCommand;
import billing.implementation.exemple.domain.usecase.CreateInvoiceUseCase;
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
import org.springframework.stereotype.Service;

@Service
public class RegisterOrderUseCase {

    private ClientRepository clientRepository;
    private HiShoeRepository hiShoeRepository;
    private CreateOrderService createOrderService;
    private OrderRepository orderRepository;
    //private EventDispatcher eventDispatcher;
    private CreateInvoiceUseCase createInvoiceUseCase;

    public RegisterOrderUseCase(ClientRepository clientRepository, HiShoeRepository hiShoeRepository,
                                CreateOrderService createOrderService, OrderRepository orderRepository) {
        this.clientRepository = clientRepository;
        this.hiShoeRepository = hiShoeRepository;
        this.createOrderService = createOrderService;
        this.orderRepository = orderRepository;
        //this.eventDispatcher = eventDispatcher;
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
        // TODO : gestion des events dans le domaine (mais ça sera pour l'année prochaine, prochaine conf? v2?)
        // this.eventDispatcher.dispatch(new OrderHasBeenCreated(order.getId()));
        // En attendant on va le faire à la mano ici
        // A la commande génération d'une facture
        // this.createInvoiceUseCase.handle(new CreateInvoiceCommand(order.getClient().getId(), order.getProduct().getReference());
        /*
        1️⃣ Le système de gestion des commandes envoie un message avec l’identifiant de la commande validée.
        2️⃣ Le module Facturation récupère les détails de la commande (lignes de commande, montant, taxes).
        3️⃣ Le module Facturation calcule le montant total de la facture.
        4️⃣ Le module crée une facture avec un identifiant unique, les lignes, le montant total et le statut `EN_ATTENTE`.
        5️⃣ La facture est persistée dans le système de facturation.
        6️⃣ La facture est rendue disponible pour consultation (par exemple via un portail client ou un envoi par email).
         */

        // en cas d'erreur, le domaine renvoie au controlleur l'erreur métier qui le transforme en erreur utilisateur
        // chaque couche sa responsabilité

    }


}
