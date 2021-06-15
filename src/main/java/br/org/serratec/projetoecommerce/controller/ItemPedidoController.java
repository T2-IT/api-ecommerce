package br.org.serratec.projetoecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.projetoecommerce.model.ItemPedido;
import br.org.serratec.projetoecommerce.service.ItemPedidoService;

@RestController
@RequestMapping("/itemPedido")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoService itemPedidoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ItemPedido inserir(@RequestBody ItemPedido itemPedido) {
		ItemPedido i = itemPedidoService.inserir(itemPedido);
		return i;
	}

	@GetMapping
	public ResponseEntity<List<ItemPedido>> listar() {
		return itemPedidoService.listar();
	}
}
