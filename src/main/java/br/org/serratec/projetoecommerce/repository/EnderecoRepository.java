package br.org.serratec.projetoecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetoecommerce.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
    public Endereco findByCep(String cep);
}
