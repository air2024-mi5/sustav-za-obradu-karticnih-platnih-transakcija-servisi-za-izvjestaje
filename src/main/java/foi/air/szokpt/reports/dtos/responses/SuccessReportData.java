package foi.air.szokpt.reports.dtos.responses;

public class SuccessReportData {
    private int totalTransactions;
    private int successfulTransactions;
    private int rejectedTransactions;
    private int canceledTransactions;

    public SuccessReportData(int totalTransactions, int successfulTransactions, int rejectedTransactions, int canceledTransactions){
        this.totalTransactions = totalTransactions;
        this.successfulTransactions = successfulTransactions;
        this.rejectedTransactions = rejectedTransactions;
        this.canceledTransactions = canceledTransactions;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public int getSuccessfulTransactions() {
        return successfulTransactions;
    }

    public void setSuccessfulTransactions(int successfulTransactions) {
        this.successfulTransactions = successfulTransactions;
    }

    public int getRejectedTransactions() {
        return rejectedTransactions;
    }

    public void setRejectedTransactions(int rejectedTransactions) {
        this.rejectedTransactions = rejectedTransactions;
    }

    public int getCanceledTransactions() {
        return canceledTransactions;
    }

    public void setCanceledTransactions(int canceledTransactions) {
        this.canceledTransactions = canceledTransactions;
    }
}
