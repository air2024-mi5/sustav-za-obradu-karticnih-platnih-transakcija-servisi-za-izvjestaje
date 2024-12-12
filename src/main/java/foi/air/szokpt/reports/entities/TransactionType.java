package foi.air.szokpt.reports.entities;

public enum TransactionType {
    SUCCESSFUL("Successful"),
    REJECTED("Rejected"),
    CANCELED("Canceled");

    private final String displayName;

    TransactionType(String displayName) {
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
