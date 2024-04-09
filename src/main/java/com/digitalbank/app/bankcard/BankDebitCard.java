package com.digitalbank.app.bankcard;

import com.digitalbank.app.entity.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BankDebitCard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cardNumber;
    private double dailyTransactionLimit;
    private boolean active;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    // getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public double getDailyTransactionLimit() {
		return dailyTransactionLimit;
	}
	public void setDailyTransactionLimit(double dailyTransactionLimit) {
		this.dailyTransactionLimit = dailyTransactionLimit;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

    
}