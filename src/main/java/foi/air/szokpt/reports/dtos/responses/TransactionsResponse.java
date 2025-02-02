package foi.air.szokpt.reports.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import foi.air.szokpt.reports.dtos.TransactionPageData;

import java.util.List;

public class TransactionsResponse {
    @JsonProperty("data")
    List<TransactionPageData> transactionPageData;

    public TransactionPageData getTransactionPage(){
        return transactionPageData.getFirst();
    }
}
