package order.domain.model;

public enum HISHOE_MODEL {

        CLASSIC_CLOG("Classic Clog", 29.99),
        LITERIDE_CLOG("LiteRide Clog", 39.99),
        CLASSIC_BAE_CLOG("Classic Bae Clog", 49.99),
        BISTRO_CLOG("Bistro Clog", 34.99),
        SWIFTWATER_SANDAL("Swiftwater Sandal", 44.99),
        hiShoeBAND_CLOG("hiShoeband Clog", 32.99);

        // Champs pour la description et le prix
        private final String description;
        private final double price;

        // Constructeur de l'énumération
        HISHOE_MODEL(String description, double price) {
            this.description = description;
            this.price = price;
        }

        // Méthodes pour accéder aux champs
        public String getDescription() {
            return description;
        }

        public double getPrice() {
            return price;
        }

}
