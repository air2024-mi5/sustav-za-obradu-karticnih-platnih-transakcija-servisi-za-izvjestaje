package foi.air.szokpt.reports.clients;

import foi.air.szokpt.reports.dtos.responses.TransactionPageData;
import foi.air.szokpt.reports.entities.Transaction;
import foi.air.szokpt.reports.exceptions.ExternalServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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

    public TransactionClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Transaction> getTransactions(){

        LocalDateTime after = LocalDate.now().atStartOfDay();
        LocalDateTime before = LocalDateTime.now();

        String url = baseUrl + "transactions" + "?after=" + after + "&before" + before;

        try{
            ResponseEntity<TransactionPageData> response = restTemplate.getForEntity(url, TransactionPageData.class);

            return response.getBody().getTransactions();
        }catch (Exception e){
            throw new ExternalServiceException(e.getMessage());
        }
    }
}
