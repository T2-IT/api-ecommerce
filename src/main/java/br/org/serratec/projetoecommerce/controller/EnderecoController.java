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
	private EnderecoService enderecoService ;
	
	@Autowired
	private EnderecoRepository enderecoRepository ;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<EnderecoDTO> inserir(@Valid @RequestBody Endereco endereco){
		EnderecoDTO enderecoDTO= enderecoService.inserir(endereco);
		return ResponseEntity.ok(enderecoDTO);
	}
	@GetMapping("{cep}")
	public ResponseEntity<EnderecoDTO> buscar(@PathVariable String cep){
		EnderecoDTO enderecoDTO = enderecoService.buscar(cep);
		if (enderecoDTO == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(enderecoDTO);
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Endereco> atualizar(@Valid @RequestBody Endereco endereco,@PathVariable Long id){
		if (!enderecoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		endereco.setId(id);
		endereco= enderecoRepository.save(endereco);
		return ResponseEntity.ok(endereco);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		if (!enderecoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		enderecoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
