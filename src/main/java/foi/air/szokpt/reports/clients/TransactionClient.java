package foi.air.szokpt.reports.clients;

import foi.air.szokpt.reports.dtos.TransactionPageData;
import foi.air.szokpt.reports.dtos.responses.TransactionsResponse;
import foi.air.szokpt.reports.entities.Transaction;
import foi.air.szokpt.reports.exceptions.ExternalServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class TransactionClient {

    private final RestTemplate restTemplate;

    @Value("${Transaction.api.base.url}")
    private String baseUrl;

    public TransactionClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Transaction> getTransactions(String authorizationHeader) {
        LocalDateTime after = LocalDate.now().atStartOfDay();
        LocalDateTime before = LocalDateTime.now();

        String url = baseUrl + "/transactions" + "?after=" + after + "&before=" + before;


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<TransactionsResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    TransactionsResponse.class);

            TransactionPageData transactionPageData = response.getBody().getTransactionPage();
            if(transactionPageData != null)
                return transactionPageData.getTransactions();

        } catch (Exception e) {
            throw new ExternalServiceException(e.getMessage());
        }
        return null;
    }
}

