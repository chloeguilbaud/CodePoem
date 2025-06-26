package order.application.controllers;

import order.domain.exceptions.HiShoeNotFoundException;
import order.domain.port.usecases.RegisterOrderCommand;
import order.domain.port.usecases.RegisterOrderUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private RegisterOrderUseCase registerOrderUseCase;

    public OrderController(RegisterOrderUseCase registerOrderUseCase) {
        this.registerOrderUseCase = registerOrderUseCase;
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createOrder(
            @RequestParam(value = "clientId") int clientId,
            @RequestParam(value = "hiShoeReference") int hiShoeReference
    ) {

        // registerOrderUseCase.handle(clientId, hiShoeReference);
        try {
            registerOrderUseCase.handle(new RegisterOrderCommand(clientId, hiShoeReference));
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    String.format("Commande de hiShoes %s de la part de %s.", hiShoeReference, clientId)
            );
        } catch (HiShoeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    String.format("Commande impossible : %s", e.getMessage())
            );
        }
    }

}

