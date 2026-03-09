package com.library.model;

import java.time.LocalDate;

public class LibraryCard {
    private int cardId;
    private String cardNumber;
    private LocalDate issueDate;

    public LibraryCard(){
    }

    public LibraryCard(int cardId, LocalDate issueDate, String cardNumber) {
        this.cardId = cardId;
        this.issueDate = issueDate;
        this.cardNumber = cardNumber;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
                "cardId=" + cardId +
                ", cardNumber='" + cardNumber + '\'' +
                ", issueDate=" + issueDate +
                '}';
    }
}
