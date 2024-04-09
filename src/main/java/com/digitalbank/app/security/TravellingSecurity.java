package com.digitalbank.app.security;

import com.digitalbank.app.entity.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class TravellingSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean freeForPremiumClients;
    private double optionalFeeForCommonAndSuperClients;
    

    @OneToOne
    private Client client;
    
    
    // Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isFreeForPremiumClients() {
		return freeForPremiumClients;
	}

	public void setFreeForPremiumClients(boolean freeForPremiumClients) {
		this.freeForPremiumClients = freeForPremiumClients;
	}

	public double getOptionalFeeForCommonAndSuperClients() {
		return optionalFeeForCommonAndSuperClients;
	}

	public void setOptionalFeeForCommonAndSuperClients(double optionalFeeForCommonAndSuperClients) {
		this.optionalFeeForCommonAndSuperClients = optionalFeeForCommonAndSuperClients;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


}
