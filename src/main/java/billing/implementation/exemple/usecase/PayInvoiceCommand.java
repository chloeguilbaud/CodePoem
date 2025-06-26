package billing.implementation.exemple.usecase;

import billing.implementation.exemple.domain.model.Invoice;
import billing.implementation.exemple.domain.model.PayerInformations;
import billing.implementation.exemple.domain.model.PaymentDetail;

/**
 * Commande utilisée pour payer une facture.
 * Elle contient les informations nécessaires pour traiter le paiement.
 */
public class PayInvoiceCommand {

    private final Invoice invoice;
    private final PaymentDetail paymentDetail;
    private final PayerInformations payerInformations;

    public PayInvoiceCommand(Invoice invoice, PaymentDetail paymentDetail, PayerInformations payerInformations) {
        this.invoice = invoice;
        this.paymentDetail = paymentDetail;
        this.payerInformations = payerInformations;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public PayerInformations getPayerInformations() {
        return payerInformations;
    }
}

