package com.digitalbank.app.bankcard;

import com.digitalbank.app.entity.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BankCreditCard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cardNumber;
    private double credit_limit;
    private double creditUtilizationRate;
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
	public double getLimit() {
		return credit_limit;
	}
	public void setLimit(double limit) {
		this.credit_limit = limit;
	}
	public double getCreditUtilizationRate() {
		return creditUtilizationRate;
	}
	public void setCreditUtilizationRate(double creditUtilizationRate) {
		this.creditUtilizationRate = creditUtilizationRate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}


    
}