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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/itemPedido")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoService itemPedidoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere os dados de um item do pedido", notes = "Cadastrar Item do Pedido")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Item inserido"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public ItemPedido inserir(@RequestBody ItemPedido itemPedido) {
		ItemPedido i = itemPedidoService.inserir(itemPedido);
		return i;
	}

	@GetMapping
	@ApiOperation(value = "Retorna os dados de todos os itens de um pedido", notes = "Listar Itens do Pedido")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Itens listados"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção")
		})
	public ResponseEntity<List<ItemPedido>> listar() {
		return itemPedidoService.listar();
	}
}
