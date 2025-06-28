package billing.implementation.exemple.domain.model;

import billing.implementation.exemple.domain.exceptions.InvalidPaymentDetailException;

import java.util.Date;
import java.util.Objects;

public class PaymentDetail {

    private double amount;
    private Date paymentDate;
    private PaymentMethod paymentMethod;
    private PayerInformations payerInformations;

    public PaymentDetail(double amount, Date paymentDate, PaymentMethod paymentMethod, PayerInformations payerInformations) {
        if (amount <= 0) {
            throw new InvalidPaymentDetailException("Amount must be positive.");
        }
        this.amount = amount;

        if (Objects.isNull(paymentDate)) throw new InvalidPaymentDetailException("Payment date is required");
        this.paymentDate = paymentDate;

        if (Objects.isNull(paymentMethod)) throw new InvalidPaymentDetailException("Payment method is required");
        this.paymentMethod = paymentMethod;

        this.payerInformations = payerInformations;
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

    public PayerInformations getPayerDetails() {
        return payerInformations;
    }

    @Override
    public String toString() {
        return "PaymentDetail{" +
                "amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod=" + paymentMethod +
                ", payerInformations=" + payerInformations +
                '}';
    }
}
