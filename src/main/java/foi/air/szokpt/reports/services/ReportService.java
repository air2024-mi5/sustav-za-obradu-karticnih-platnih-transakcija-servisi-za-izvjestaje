package foi.air.szokpt.reports.services;

import foi.air.szokpt.reports.clients.TransactionClient;
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

}
