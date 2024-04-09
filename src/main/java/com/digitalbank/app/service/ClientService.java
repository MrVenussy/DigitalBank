package com.digitalbank.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
//import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbank.app.entity.Client;
import com.digitalbank.app.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(String name, Long CPF, LocalDate dateOfBirth, String address) {
        // Validate fields
        validateCPF(CPF);
        validateName(name);
        validateDateOfBirth(dateOfBirth);
        validateAddress(address);

        Client client = new Client();
        client.setCPF(CPF);
        client.setName(name);
        client.setAddress(address);
        client.setDateOfBirth(dateOfBirth);

        return clientRepository.save(client);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    private void validateCPF(Long cpf) {
        // Check if CPF already exists in the repository
        if (clientRepository.existsByCPF(cpf)) {
            throw new IllegalArgumentException("CPF already in use");
        }

        // Validate CPF format (xxx.xxx.xxx-xx)
        String cpfString = String.valueOf(cpf);
        Pattern cpfPattern = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");
        Matcher matcher = cpfPattern.matcher(cpfString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid CPF format");
        }

        // TODO: Implement real CPF validation algorithm
    }

    private void validateName(String name) {
        // Validate name contains only letters and spaces
        if (!name.matches("^[A-Za-z\\s]+$")) {
            throw new IllegalArgumentException("Invalid name format");
        }

        // Validate name length
        if (name.length() < 2 || name.length() > 100) {
            throw new IllegalArgumentException("Name length must be between 2 and 100 characters");
        }
    }

    private void validateDateOfBirth(LocalDate dateOfBirth) {
        // Validate age (must be ? 18 years old)
        LocalDate today = LocalDate.now();
        if (dateOfBirth.isAfter(today.minusYears(18))) {
            throw new IllegalArgumentException("Client must be 18 years or older");
        }
    }

    private void validateAddress(String address) {
 
        // Validate CEP format (xxxxx-xxx)
        Pattern cepPattern = Pattern.compile("^\\d{5}-\\d{3}$");
        Matcher cepMatcher = cepPattern.matcher(address);
        if (!cepMatcher.matches()) {
            throw new IllegalArgumentException("Invalid CEP format");
        }

        // TODO: Validate other address components (street, number, complement, city, state)
    }
}
