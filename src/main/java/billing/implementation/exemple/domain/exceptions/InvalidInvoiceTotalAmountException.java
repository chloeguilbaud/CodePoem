package billing.implementation.exemple.domain.exceptions;

public class InvalidInvoiceTotalAmountException extends Exception {

    public InvalidInvoiceTotalAmountException(int invoiceReference) {
        super("Invoice n°" + invoiceReference + " has illegal argument." +
                "La somme des paiements ne peut pas dépasser le montant dû.");
    }

}