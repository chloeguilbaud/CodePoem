package billing.implementation.exemple.domain.model;

import billing.implementation.exemple.domain.exceptions.InvalidPaymentDetailException;

import java.util.Date;
import java.util.Objects;

public class PaymentDetail {

    private double amount;
    private Date paymentDate;
    private PaymentMethod paymentMethod;
    private PayerDetails payerDetails;

    public void PaymentDetail(double amount, Date paymentDate, PaymentMethod paymentMethod, PayerDetails payerDetails) {
        if (amount <= 0) {
            throw new InvalidPaymentDetailException("Amount must be positive.");
        }
        this.amount = amount;

        if (Objects.isNull(paymentDate)) throw new InvalidPaymentDetailException("Payment date is required");
        this.paymentDate = paymentDate;

        if (Objects.isNull(paymentMethod)) throw new InvalidPaymentDetailException("Payment method is required");
        this.paymentMethod = paymentMethod;

        this.payerDetails = payerDetails;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PayerDetails getPayerDetails() {
        return payerDetails;
    }
}
