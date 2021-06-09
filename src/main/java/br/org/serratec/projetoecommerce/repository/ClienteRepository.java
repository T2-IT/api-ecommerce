package br.org.serratec.projetoecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetoecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
