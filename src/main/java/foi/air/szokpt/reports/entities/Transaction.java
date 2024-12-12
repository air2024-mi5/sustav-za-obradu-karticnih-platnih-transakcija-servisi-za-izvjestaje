package foi.air.szokpt.reports.entities;

import java.time.LocalDateTime;

public class Transaction{
    private CardType cardType;
    private String cardNumber;
    private String transactionNumber;
    private Double amount;
    private LocalDateTime dateTime;
    private TransactionType transactionType;
    private boolean success;

    public Transaction(CardType cardType, String cardNumber, String transactionNumber,
                       Double amount, String dateTimeStr, TransactionType transactionType, boolean success) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.transactionNumber = transactionNumber;
        this.amount = amount;
        this.dateTime = LocalDateTime.parse(dateTimeStr);
        this.transactionType = transactionType;
        this.success = success;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
