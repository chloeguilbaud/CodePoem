package billing.implementation.exemple.domain.exceptions;

import java.util.UUID;

public class InvalidPaymentException extends RuntimeException {
    public InvalidPaymentException(UUID invoiceReference) {
      super("Invoice n°" + invoiceReference + " has payment argument." +
              "« la somme des paiements ne peut pas dépasser le montant dû »");
    }
}
