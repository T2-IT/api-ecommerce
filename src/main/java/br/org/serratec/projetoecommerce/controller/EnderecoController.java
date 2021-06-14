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

import br.org.serratec.projetoecommerce.dto.EnderecoDTO;
import br.org.serratec.projetoecommerce.model.Endereco;
import br.org.serratec.projetoecommerce.repository.EnderecoRepository;
import br.org.serratec.projetoecommerce.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco inserir(@Valid @RequestBody Endereco endereco) {
		return enderecoService.inserir(endereco);
	}

	@GetMapping("{cep}")
	public Endereco buscar(@PathVariable String cep) {
		return enderecoService.buscar(cep);
	}

	@PutMapping("{id}")
	public ResponseEntity<Endereco> atualizar(@Valid @RequestBody Endereco endereco, @PathVariable Long id) {
		return enderecoService.atualizar(endereco, id);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		return enderecoService.deletar(id);
	}

}
