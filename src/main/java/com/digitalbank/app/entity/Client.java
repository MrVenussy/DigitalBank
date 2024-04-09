package com.digitalbank.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
//import java.time.LocalDate;
import java.time.Period;

import com.digitalbank.app.category.ClientCategory;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private Long CPFnumber;
    private LocalDate dateOfBirth;
    private String address;
    private ClientCategory category; // Add the category field


    // Common, super, and premium category
    public void defineCategory() {
        if (calculateTotalSpending() > 1000) {
            category = ClientCategory.Premium;
        } else if (calculateSeniority(dateOfBirth) > 2) {
            category = ClientCategory.Super;
        } else {
            category = ClientCategory.Common;
        }
    }
    
    // Getters and Setters
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return clientName;
	}

	public void setName(String name) {
		this.clientName = name;
	}

	public Long getCPF() {
		return CPFnumber;
	}

	public void setCPF(Long cPF) {
		CPFnumber = cPF;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ClientCategory getCategory() {
		return category;
	}

	public void setCategory(ClientCategory category) {
		this.category = category;
	}

	// Calculate total spending (replace with actual logic)
	  private List<Double> transactions = Arrays.asList(100.0, 50.0, 200.0, 75.0);

	    // Calculate total spending
	    private double calculateTotalSpending() {
	        double totalSpending = transactions.stream()
	                .mapToDouble(Double::doubleValue)
	                .sum();
	        return totalSpending;
	    }

	    public static void main(String[] args) {
	        Client client = new Client();
	        double totalSpending = client.calculateTotalSpending();
	        System.out.printf("Total spending: $%.2f%n", totalSpending);
	    }
	
	 // Calculate seniority (replace with actual logic)
	    private int calculateSeniority(LocalDate registrationDate) {
	        LocalDate currentDate = LocalDate.now();
	        Period period = Period.between(registrationDate, currentDate);
	        return period.getYears();
	    }


	    
}
