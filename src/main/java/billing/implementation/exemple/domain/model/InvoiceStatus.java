package billing.implementation.exemple.domain.model;

public enum InvoiceStatus {
    PENDING,         // Brouillon : non finalisée EN_ATTENTE
    ISSUED,        // Émise : envoyée au client
    SENT,          // Envoyée : par email ou autre canal
    PAID,          // Payée
    PARTIALLY_PAID,// Partiellement payée
    CANCELLED      // Annulée
}
