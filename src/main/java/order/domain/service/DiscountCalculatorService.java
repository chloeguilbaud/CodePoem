package order.domain.service;

import order.domain.model.Client;

public class DiscountCalculatorService {

    /**
     * Calculate discount based on the total amount and the client's loyalty status.
     *
     * @param totalAmount The total amount of the order.
     * @param client The client placing the order.
     * @return The discount amount to be applied.
     */
    public double calculateDiscount(double totalAmount, Client client) {
        // Example: 10% discount for loyal clients
        if (client.isLoyal()) {
            return totalAmount * 0.1; // 10% discount
        }
        return 0; // No discount for non-loyal clients
    }
}