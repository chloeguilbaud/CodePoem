package order.application.controllers;

import order.domain.exceptions.HiShoeNotFoundException;
import order.domain.model.Client;
import order.domain.port.repositories.ClientRepository;
import order.domain.port.usecases.RegisterOrderCommand;
import order.domain.port.usecases.RegisterOrderUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class OrderController {

    private RegisterOrderUseCase registerOrderUseCase;
    private ClientRepository clientRepository;

    public OrderController(RegisterOrderUseCase registerOrderUseCase, ClientRepository clientRepository) {
        this.registerOrderUseCase = registerOrderUseCase;
        this.clientRepository = clientRepository;
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createOrder(
            @RequestParam(value = "clientId") UUID clientId,
            @RequestParam(value = "hiShoeReference") int hiShoeReference
    ) {

        // registerOrderUseCase.handle(clientId, hiShoeReference);
        try {
            registerOrderUseCase.handle(new RegisterOrderCommand(clientId, hiShoeReference));
            Client client = clientRepository.get(clientId);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    String.format("Commande de hiShoes %s de la part de %s %s.", hiShoeReference, client.getFirstName(), client.getLastName())
            );
        } catch (HiShoeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    String.format("Commande impossible : %s", e.getMessage())
            );
        }
    }

}

