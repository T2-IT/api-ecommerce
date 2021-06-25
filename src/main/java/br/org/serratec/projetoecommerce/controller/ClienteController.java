package br.org.serratec.projetoecommerce.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.org.serratec.projetoecommerce.dto.ClienteDTO;
import br.org.serratec.projetoecommerce.exception.ClienteException;
import br.org.serratec.projetoecommerce.exception.EmailException;
import br.org.serratec.projetoecommerce.model.Cliente;
import br.org.serratec.projetoecommerce.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// alterar
@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "https://ecommerce-tdois.herokuapp.com")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insere os dados de um cliente", notes = "Cadastrar Cliente")
    @ApiResponses(value = { 
            @ApiResponse(code = 201, message = "Cliente cadastrado"),
            @ApiResponse(code = 401, message = "Erro de Autenticação"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Quando ocorre uma exceção")
        })
    public ResponseEntity<Cliente> inserir(@Valid @RequestBody Cliente cliente) throws EmailException, ClienteException {
        return clienteService.inserir(cliente);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Retorna os dados de um cliente", notes = "Buscar Cliente")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Cliente encontrado"),
            @ApiResponse(code = 401, message = "Erro de Autenticação"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
        })
    public ResponseEntity<ClienteDTO> buscar(@PathVariable Long id) {
        return clienteService.buscar(id);
    }

    @GetMapping
    @ApiOperation(value = "Retorna os dados de todos os clientes", notes = "Listar Clientes")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Clientes encontrados"),
            @ApiResponse(code = 401, message = "Erro de Autenticação"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
        })
    public ResponseEntity<List<Cliente>> listar() {
        return clienteService.listar();
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Atualiza os dados de um cliente", notes = "Atualizar Cliente")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Cliente atualizado"),
            @ApiResponse(code = 201, message = "Cliente cadastrado"),
            @ApiResponse(code = 401, message = "Erro de Autenticação"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Quando ocorre uma exceção") 
        })
    public ResponseEntity<Cliente> atualizar(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
        return clienteService.atualizar(cliente, id);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Remove os dados de um cliente", notes = "Remover Cliente")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Cliente removido"),
            @ApiResponse(code = 401, message = "Erro de Autenticação"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Quando ocorre uma exceção")
        })
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        return clienteService.excluir(id);
    }

}
