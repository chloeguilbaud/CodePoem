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

    public BillingController(GetInvoiceByIdUseCase getInvoiceByIdUseCase, ClientRepository clientRepository) {
        this.getInvoiceByIdUseCase = getInvoiceByIdUseCase;
        this.clientRepository = clientRepository;
    }

//    @PostMapping("/invoice")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity createInvoice(
//            @RequestBody InvoiceRequest request
//    ) {
//        // TODO
//    }


    @GetMapping("/invoice")
    public ResponseEntity getInvoice(
            @RequestParam(value = "invoiceId") UUID invoiceId
    ) {

        Invoice invoice = getInvoiceByIdUseCase.handle(new InvoiceQuery(invoiceId));
        return ResponseEntity.status(HttpStatus.CREATED).body(
                String.format("Facture n' %s du client %s %s pour un montant total de %s.",
                        invoice.getInvoiceId(), invoice.getClient().getName(),
                        invoice.getClient().getSurname(), invoice.getTotalAmount())
        );
    }

}

