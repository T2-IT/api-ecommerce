package br.org.serratec.projetoecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.projetoecommerce.model.Pedido;
import br.org.serratec.projetoecommerce.model.StatusPedido;
import br.org.serratec.projetoecommerce.repository.PedidoRepository;
import br.org.serratec.projetoecommerce.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@PutMapping("/editarStatusPedido/{id}")
	public ResponseEntity<Pedido> editarStatusPedido(@PathVariable Long id, @RequestParam StatusPedido statusPedido) {
		return pedidoService.editarStatusPedido(id, statusPedido);
	}

	@PutMapping("/finalizarPedido/{id}")
	public ResponseEntity<Pedido> finalizarPedido(@PathVariable Long id) {
		return pedidoService.finalizarPedido(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido inserir(@RequestBody Pedido pedido) {
		return pedidoService.inserir(pedido);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Pedido> atualizar (@PathVariable Long id, @RequestBody Pedido pedido){ 
	if (!pedidoRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	pedido.setId(id);
	pedido = pedidoRepository.save(pedido);
	return ResponseEntity.ok(pedido);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Pedido> buscar(@PathVariable Long id){
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return ResponseEntity.ok(pedido.get());
	}
}
