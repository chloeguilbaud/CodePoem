package billing.implementation.exemple.application.controllers;

import billing.implementation.exemple.domain.exceptions.InvalidInvoiceListQuantityException;
import billing.implementation.exemple.domain.model.Invoice;
import billing.implementation.exemple.domain.usecase.CreateInvoiceCommand;
import billing.implementation.exemple.domain.usecase.CreateInvoiceUseCase;
import billing.implementation.exemple.domain.usecase.GetInvoiceByIdUseCase;
import billing.implementation.exemple.domain.usecase.InvoiceQuery;
import order.domain.exceptions.HiShoeNotFoundException;
import order.domain.model.Client;
import order.domain.port.repositories.ClientRepository;
import order.domain.port.usecases.RegisterOrderCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class BillingController {

    private CreateInvoiceUseCase createInvoiceUseCase;
    private GetInvoiceByIdUseCase getInvoiceByIdUseCase;
    private ClientRepository clientRepository;

    /*@PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createInvoice(
            @RequestBody InvoiceRequest request
    ) {

        *//*UUID clientId = request.getClientId();
        HashMap<Integer, Integer> products = request.getProducts();

        try {
            createInvoiceUseCase.handle(new CreateInvoiceCommand(clientId, products));
            Client client = clientRepository.get(clientId);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    String.format("Facturation de hiShoes pour %s %s \n%s.",
                            client.getFirstName(), client.getLastName(), products)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    String.format("Facturation impossible : %s", e.getMessage())
            );
        }*//*
    }
*/
    @GetMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice getInvoice(
            @RequestParam(value = "invoiceId") UUID invoiceId
    ) {
        System.out.println("Invoice ID: " + invoiceId);
        return getInvoiceByIdUseCase.handle(new InvoiceQuery(invoiceId));
    }

}

