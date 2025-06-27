package api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public String hello(
            @RequestParam(value = "mail") String mail,
            @RequestParam(value = "quantity") int quantity,
            @RequestParam(value = "address") String address
    ) {
        Order order = new api.Order(mail, quantity, address);
        return String.format("Commande de %s pairs de hiShoes de la part de %s. " +
                "Adresse de livraison : %s.",
                order.quantity, order.mail, order.address);
    }

}
