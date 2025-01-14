package foi.air.szokpt.reports.services;

import foi.air.szokpt.reports.clients.TransactionClient;
import foi.air.szokpt.reports.dtos.responses.CardBrandsReportData;
import foi.air.szokpt.reports.dtos.responses.SuccessReportData;
import foi.air.szokpt.reports.entities.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

import static foi.air.szokpt.reports.util.ResponseCodeConstants.*;

@Service
public class ReportService {

    private final TransactionClient client;

    public ReportService(TransactionClient client) {
        this.client = client;
    }

    public SuccessReportData getSuccessReport(String authorizationHeader){
        List<Transaction> transactions = client.getTransactions(authorizationHeader);

        if(transactions == null)
            return new SuccessReportData(0, 0, 0, 0);

        int successfulTransactions = (int) transactions.stream()
                .filter(t -> SUCCESS_CODES.contains(t.getResponseCode()))
                .count();

        int rejectedTransactions = (int) transactions.stream()
                .filter(t -> REJECTED_CODES.contains(t.getResponseCode()))
                .count();

        int canceledTransactions = (int) transactions.stream()
                .filter(t -> CANCELED_CODES.contains(t.getResponseCode()))
                .count();


        return new SuccessReportData(
                transactions.size(),
                successfulTransactions,
                rejectedTransactions,
                canceledTransactions
        );
    }

    public CardBrandsReportData getCardBrandsReport(String authorizationHeader){
        List<Transaction> transactions = client.getTransactions(authorizationHeader);

        if(transactions == null)
            return new CardBrandsReportData(0, 0, 0, 0, 0, 0, 0);

        int visaCount = (int) transactions.stream()
                .filter(t -> "Visa".equalsIgnoreCase(t.getCardBrand().toString()))
                .count();

        int dinersCount = (int) transactions.stream()
                .filter(t -> "Diners".equalsIgnoreCase(t.getCardBrand().toString()))
                .count();

        int discoverCount = (int) transactions.stream()
                .filter(t -> "Discover".equalsIgnoreCase(t.getCardBrand().toString()))
                .count();

        int mastercardCount = (int) transactions.stream()
                .filter(t -> "Mastercard".equalsIgnoreCase(t.getCardBrand().toString()))
                .count();

        int maestroCount = (int) transactions.stream()
                .filter(t -> "Maestro".equalsIgnoreCase(t.getCardBrand().toString()))
                .count();

        int amexCount = (int) transactions.stream()
                .filter(t -> "Amex".equalsIgnoreCase(t.getCardBrand().toString()))
                .count();

        return new CardBrandsReportData(
                transactions.size(),
                visaCount,
                dinersCount,
                discoverCount,
                mastercardCount,
                maestroCount,
                amexCount
        );
    }

}
