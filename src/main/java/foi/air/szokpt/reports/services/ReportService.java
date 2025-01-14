package foi.air.szokpt.reports.services;

import foi.air.szokpt.reports.clients.MockTransactionClient;
import foi.air.szokpt.reports.dtos.responses.SuccessReportData;
import foi.air.szokpt.reports.entities.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

import static foi.air.szokpt.reports.util.ResponseCodeConstants.*;

@Service
public class ReportService {

    private final MockTransactionClient client;

    public ReportService(MockTransactionClient client) {
        this.client = client;
    }

    public SuccessReportData getSuccessReport(){
        List<Transaction> transactions = client.getUnprocessedTransactions();

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
