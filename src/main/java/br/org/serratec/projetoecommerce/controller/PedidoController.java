package br.org.serratec.projetoecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.projetoecommerce.model.Pedido;
import br.org.serratec.projetoecommerce.model.StatusPedido;
import br.org.serratec.projetoecommerce.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PutMapping("/editarStatusPedido/{id}")
	public ResponseEntity<Pedido> editarStatusPedido(@PathVariable Long id, @RequestParam StatusPedido statusPedido) {
		return pedidoService.editarStatusPedido(id, statusPedido);
	}

	@PutMapping("/finalizarPedido/{id}")
	public ResponseEntity<Pedido> finalizarPedido(@PathVariable Long id) {
		return pedidoService.finalizarPedido(id);
	}

	@PostMapping
	public Pedido inserir(@RequestBody Pedido pedido) {
		return pedidoService.inserir(pedido);
	}
}
