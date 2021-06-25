package br.org.serratec.projetoecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.projetoecommerce.model.Categoria;
import br.org.serratec.projetoecommerce.service.CategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere os dados de uma categoria", notes = "Cadastrar Categoria")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Categoria cadastrada"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção")
		})
	public Categoria inserir(@RequestBody Categoria categoria) {
		return categoriaService.inserir(categoria);
	}

	@GetMapping
	@ApiOperation(value = "Retorna os dados de todas as categorias", notes = "Listar Categorias")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Categorias encontradas"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção")
		})
	public ResponseEntity<List<Categoria>> listar() {
		return categoriaService.listar();
	}

	@GetMapping("{id}")
	@ApiOperation(value = "Retorna os dados de uma categoria", notes = "Buscar Categoria")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Categoria encontrada"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
		return categoriaService.buscar(id);
	}

	@PutMapping("{id}")
	@ApiOperation(value = "Atualiza os dados de uma categoria", notes = "Atualizar Categoria")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Categoria atualizada"),
			@ApiResponse(code = 201, message = "Categoria cadastrada"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção")
		})
	public ResponseEntity<Categoria> editar(@PathVariable Long id, @RequestBody Categoria categoria) {
		return categoriaService.editar(id, categoria);
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "Remove os dados de uma categoria", notes = "Remover Categoria")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Categoria removida"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção")
		})
	public ResponseEntity<Void> excluir(Long id) {
		return categoriaService.excluir(id);
	}
}
