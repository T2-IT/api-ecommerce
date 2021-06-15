package br.org.serratec.projetoecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.projetoecommerce.model.Endereco;
import br.org.serratec.projetoecommerce.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere os dados de endereço", notes = "Cadastrar Endereço")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Endereço cadastrado"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public Endereco inserir(@Valid @RequestBody Endereco endereco) {
		return enderecoService.inserir(endereco);
	}

	@GetMapping("{cep}")
	@ApiOperation(value = "Retorna os dados de um endereço", notes = "Buscar Endereço")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Endereço encontrado"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public Endereco buscar(@PathVariable String cep) {
		return enderecoService.buscar(cep);
	}

	@PutMapping("{id}")
	@ApiOperation(value = "Atualiza os dados de um endereço", notes = "Atualizar Endereço")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Endereço atualizado"),
			@ApiResponse(code = 201, message = "Endereço cadastrado"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public ResponseEntity<Endereco> atualizar(@Valid @RequestBody Endereco endereco, @PathVariable Long id) {
		return enderecoService.atualizar(endereco, id);
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "Remove os dados de um endereço", notes = "Remover Endereço")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Endereço removido"),
			@ApiResponse(code = 401, message = "Erro de Autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
		})
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		return enderecoService.deletar(id);
	}

}
