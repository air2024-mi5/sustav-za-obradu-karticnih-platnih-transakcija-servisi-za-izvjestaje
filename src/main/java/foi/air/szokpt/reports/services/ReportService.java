package foi.air.szokpt.reports.services;

import foi.air.szokpt.reports.clients.MockTransactionClient;
import foi.air.szokpt.reports.dtos.responses.SuccessReportData;
import foi.air.szokpt.reports.entities.Transaction;
import foi.air.szokpt.reports.entities.TransactionType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final MockTransactionClient client;

    public ReportService(MockTransactionClient client) {
        this.client = client;
    }

    public SuccessReportData getSuccessReport(){
        List<Transaction> transactions = client.getUnprocessedTransactions();

        HashMap<TransactionType, Long> transactionCounts = (HashMap<TransactionType, Long>) transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getTransactionType, Collectors.counting()));

        int successfulTransactions = transactionCounts.getOrDefault(TransactionType.SUCCESSFUL, 0L).intValue();
        int rejectedTransactions = transactionCounts.getOrDefault(TransactionType.REJECTED, 0L).intValue();
        int canceledTransactions = transactionCounts.getOrDefault(TransactionType.CANCELED, 0L).intValue();
        return new SuccessReportData(
                transactions.size(),
                successfulTransactions,
                rejectedTransactions,
                canceledTransactions
        );
    }

}
