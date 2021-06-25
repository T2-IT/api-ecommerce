package br.org.serratec.projetoecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// alterar
@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@PutMapping("/editarStatusPedido/{id}")
	@ApiOperation(value = "Atualiza o status de um pedido", notes = "Atualizar Status Pedido")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Status do pedido atualizado"),
			@ApiResponse(code = 201, message = "Status do pedido cadastrado"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public ResponseEntity<Pedido> editarStatusPedido(@PathVariable Long id, @RequestParam StatusPedido statusPedido) {
		return pedidoService.editarStatusPedido(id, statusPedido);
	}

	@PutMapping("/finalizarPedido/{id}")
	@ApiOperation(value = "Finaliza um pedido", notes = "Finalizar Pedido")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Pedido Finalizado"),
			@ApiResponse(code = 201, message = "Pedido cadastrado e finalizado"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public ResponseEntity<Pedido> finalizarPedido(@PathVariable Long id) {
		return pedidoService.finalizarPedido(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere os dados de um pedido", notes = "Cadastrar Pedido")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Pedido cadastrado"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public Pedido inserir(@RequestBody Pedido pedido) {
		return pedidoService.inserir(pedido);
	}
	
	@PutMapping("{id}")
	@ApiOperation(value = "Atualiza os dados de um pedido", notes = "Atualizar Pedido")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Pedido atualizado"),
			@ApiResponse(code = 201, message = "Pedido cadastrado"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção")
		})
	public ResponseEntity<Pedido> atualizar (@PathVariable Long id, @RequestBody Pedido pedido){ 
	if (!pedidoRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	pedido.setId(id);
	pedido = pedidoRepository.save(pedido);
	return ResponseEntity.ok(pedido);
	}
	
	@GetMapping("{id}")
	@ApiOperation(value = "Retorna os dados de um pedido", notes = "Buscar Pedido")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Pedido encontrado"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public ResponseEntity<Pedido> buscar(@PathVariable Long id){
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return ResponseEntity.ok(pedido.get());
	}
}
