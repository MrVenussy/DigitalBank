package com.digitalbank.app.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.digitalbank.app.entity.Client;
import com.digitalbank.app.service.ClientService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addClient(@RequestBody Client client) {
		
		Client clientAdded = clientService.saveClient(
				client.getName(), 
				client.getCPF(), 
				client.getDateOfBirth(),
				client.getAddress()				
				);
		
		if(clientAdded != null) {
			
			return new ResponseEntity<>(
					"Client added!",
					HttpStatus.CREATED
					);
			
		}
		else {
			
			return new ResponseEntity<>(
					"Client not added!",
					HttpStatus.NOT_ACCEPTABLE
					);
			
		}
	}
	
	@GetMapping("/ListAll")
	public ResponseEntity<List<Client>> getAllCients(){
		
		List<Client> clients  = clientService.getClients();
		return new ResponseEntity<List<Client>>(
				clients,
				HttpStatus.OK
				);
		
		
	}

}