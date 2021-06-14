package br.org.serratec.projetoecommerce.controller;

import java.util.List;
import java.util.Optional;

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

import br.org.serratec.projetoecommerce.model.Categoria;
import br.org.serratec.projetoecommerce.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria inserir (@RequestBody Categoria categoria) {
		return categoriaService.inserir(categoria);
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		return categoriaService.listar();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
		return categoriaService.buscar(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Categoria> editar(@PathVariable Long id, @RequestBody Categoria categoria) {
		return categoriaService.editar(id, categoria);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> excluir(Long id) {
		return categoriaService.excluir(id);
	}
}
