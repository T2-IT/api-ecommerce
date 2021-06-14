package br.org.serratec.projetoecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetoecommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
