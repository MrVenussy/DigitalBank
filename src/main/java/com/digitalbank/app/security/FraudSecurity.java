package com.digitalbank.app.security;

import com.digitalbank.app.entity.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class FraudSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double baseCoverageAmount;

    @OneToOne
    private Client client; // Assuming this is the relationship you intended
    
    // Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBaseCoverageAmount() {
		return baseCoverageAmount;
	}

	public void setBaseCoverageAmount(double baseCoverageAmount) {
		this.baseCoverageAmount = baseCoverageAmount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


}
