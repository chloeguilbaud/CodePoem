package hiweb.conference.codepoem.order.application.controllers;

import hiweb.conference.codepoem.order.domain.port.repositories.HiShoeNotFoundException;
import hiweb.conference.codepoem.order.domain.port.usecases.RegisterOrderCommand;
import hiweb.conference.codepoem.order.domain.port.usecases.RegisterOrderUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private RegisterOrderUseCase registerOrderUseCase;

    public OrderController(RegisterOrderUseCase registerOrderUseCase) {
        this.registerOrderUseCase = registerOrderUseCase;
    }

    @GetMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public String hello(
            @RequestParam(value = "clientId") int clientId,
            @RequestParam(value = "hiShoeReference") int hiShoeReference
    ) {

        // registerOrderUseCase.handle(clientId, hiShoeReference);
        try {
            registerOrderUseCase.handle(new RegisterOrderCommand(clientId, hiShoeReference));
        } catch (HiShoeNotFoundException e) {
            String.format("Commande de hiShoes %s de la part de %s impossible. Référence indisponible.",
                    hiShoeReference, clientId);
        }

        return String.format("Commande de hiShoes %s de la part de %s.",
                hiShoeReference, clientId);
    }

}

