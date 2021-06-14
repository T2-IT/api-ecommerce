package br.org.serratec.projetoecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetoecommerce.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
