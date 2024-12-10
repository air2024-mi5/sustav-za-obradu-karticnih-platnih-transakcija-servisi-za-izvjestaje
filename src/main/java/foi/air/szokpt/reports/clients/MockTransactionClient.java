package foi.air.szokpt.reports.clients;

import foi.air.szokpt.reports.entities.CardType;
import foi.air.szokpt.reports.entities.Transaction;
import foi.air.szokpt.reports.entities.TransactionType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockTransactionClient {
    public List<Transaction> getUnprocessedTransactions(){
        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(
                CardType.VISA,
                "4111111111111111",
                "TXN123456789",
                100.50,
                "2024-12-07T10:00:00",
                TransactionType.SUCCESSFUL,
                true
        ));

        transactions.add(new Transaction(
                CardType.MASTERCARD,
                "5500000000000004",
                "TXN123456790",
                200.75,
                "2024-12-07T10:30:00",
                TransactionType.REJECTED,
                false
        ));

        transactions.add(new Transaction(
                CardType.AMEX,
                "340000000000009",
                "TXN123456791",
                300.00,
                "2024-12-07T11:00:00",
                TransactionType.CANCELED,
                false
        ));

        transactions.add(new Transaction(
                CardType.VISA,
                "4111111111111112",
                "TXN123456792",
                50.25,
                "2024-12-07T11:30:00",
                TransactionType.SUCCESSFUL,
                true
        ));

        transactions.add(new Transaction(
                CardType.MASTERCARD,
                "5500000000000005",
                "TXN123456793",
                75.00,
                "2024-12-07T12:00:00",
                TransactionType.SUCCESSFUL,
                true
        ));

        transactions.add(new Transaction(
                CardType.AMEX,
                "340000000000010",
                "TXN123456794",
                250.00,
                "2024-12-07T12:30:00",
                TransactionType.REJECTED,
                false
        ));

        transactions.add(new Transaction(
                CardType.VISA,
                "4111111111111113",
                "TXN123456795",
                500.00,
                "2024-12-07T13:00:00",
                TransactionType.CANCELED,
                false
        ));

        transactions.add(new Transaction(
                CardType.MASTERCARD,
                "5500000000000006",
                "TXN123456796",
                120.00,
                "2024-12-07T13:30:00",
                TransactionType.SUCCESSFUL,
                true
        ));

        transactions.add(new Transaction(
                CardType.AMEX,
                "340000000000011",
                "TXN123456797",
                150.25,
                "2024-12-07T14:00:00",
                TransactionType.REJECTED,
                false
        ));

        transactions.add(new Transaction(
                CardType.VISA,
                "4111111111111114",
                "TXN123456798",
                200.00,
                "2024-12-07T14:30:00",
                TransactionType.SUCCESSFUL,
                true
        ));

        return transactions;
    }
}
