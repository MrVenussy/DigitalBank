package com.digitalbank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbank.app.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByCPF(Long cpf);

    // Other repository methods...
}
