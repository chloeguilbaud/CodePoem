package billing.implementation.exemple.domain.model;

public enum InvoiceStatus {
    DRAFT,         // Brouillon : non finalisée
    ISSUED,        // Émise : envoyée au client
    SENT,          // Envoyée : par email ou autre canal
    PAID,          // Payée
    PARTIALLY_PAID,// Partiellement payée
    CANCELLED      // Annulée
}
