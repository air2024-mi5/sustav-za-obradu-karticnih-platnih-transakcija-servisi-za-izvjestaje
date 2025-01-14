package foi.air.szokpt.reports.dtos.responses;

public class CardBrandsReportData {

    private int totalTransactions;
    private int visaCount;
    private int masterCardCount;
    private int dinersCount;
    private int discoverCount;
    private int maestroCount;
    private int amexCount;


    public CardBrandsReportData(int totalTransactions, int visa, int masterCard, int diners, int discover, int maestro, int amex){
        this.totalTransactions = totalTransactions;
        this.visaCount = visa;
        this.masterCardCount = masterCard;
        this.dinersCount = diners ;
        this.discoverCount = discover;
        this.maestroCount = maestro ;
        this.amexCount = amex;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public int getVisaCount() {
        return visaCount;
    }

    public int getDinersCount() {
        return dinersCount;
    }

    public int getDiscoverCount() {
        return discoverCount;
    }

    public int getMastercardCount() {
        return masterCardCount;
    }

    public int getMaestroCount() {
        return maestroCount;
    }

    public int getAmexCount() {
        return amexCount;
    }
}
