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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.org.serratec.projetoecommerce.model.Produto;
import br.org.serratec.projetoecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto inserir(@RequestPart Produto produto, @RequestParam MultipartFile file) throws IOException {
		return produtoService.inserir(produto, file);
	}

	@GetMapping("{id}")
	public ResponseEntity<Produto> buscar(@PathVariable Long id) {
		return produtoService.buscar(id);
	}

	@GetMapping
	public ResponseEntity<List<Produto>> listar() {
		return produtoService.listar();
	}

	@PutMapping("{id}")
	public ResponseEntity<Produto> atualizar(Long id, Produto produto) {
		return produtoService.atualizar(id, produto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(Long id) {
		return produtoService.delete(id);
	}
}
