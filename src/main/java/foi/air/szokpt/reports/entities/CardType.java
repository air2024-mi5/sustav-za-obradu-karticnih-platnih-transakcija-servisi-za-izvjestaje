package foi.air.szokpt.reports.entities;

public enum CardType {
    VISA("VISA"),
    MASTERCARD("MasterCard"),
    AMEX("American Express"),
    DISCOVER("Discover"),
    MAESTRO("Maestro");

    private final String displayName;

    CardType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
