package foi.air.szokpt.reports.dtos.responses;

import java.time.LocalDateTime;
import java.util.Map;

public class TransactionsPerDayReportData {
    private int totalTransactions;
    private Map<LocalDateTime, Integer> transactionsPerDay;

    public TransactionsPerDayReportData(int totalTransactions, Map<LocalDateTime, Integer> transactionsPerDay) {
        this.totalTransactions = totalTransactions;
        this.transactionsPerDay = transactionsPerDay;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public Map<LocalDateTime, Integer> getTransactionsPerDay() {
        return transactionsPerDay;
    }

    public void setTransactionsPerDay(Map<LocalDateTime, Integer> transactionsPerDay) {
        this.transactionsPerDay = transactionsPerDay;
    }
}
