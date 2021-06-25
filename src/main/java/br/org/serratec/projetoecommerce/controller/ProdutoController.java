package br.org.serratec.projetoecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.projetoecommerce.model.Produto;
import br.org.serratec.projetoecommerce.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere os dados de um produto", notes = "Cadastrar Produto")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Produto cadastrado"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public Produto inserir(@RequestBody Produto produto) {
		return produtoService.inserir(produto);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna os dados de um produto", notes = "Buscar Produto")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Produto encontrado"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public ResponseEntity<Produto> buscar(@PathVariable Long id) {
		return produtoService.buscar(id);
	}

	@GetMapping
	@ApiOperation(value = "Retorna os dados de todos os produtos", notes = "Listar Produtos")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Produtos encontrados"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public ResponseEntity<List<Produto>> listar() {
		return produtoService.listar();
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza os dados de um produto", notes = "Atualizar Produto")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Produto atualizado"),
			@ApiResponse(code = 201, message = "Produto cadastrado"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public ResponseEntity<Produto> atualizar(Long id, Produto produto) {
		return produtoService.atualizar(id, produto);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove os dados de um produto", notes = "Remover Produto")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Produto removido"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção")
		})
	public ResponseEntity<Void> delete(Long id) {
		return produtoService.delete(id);
	}
}
