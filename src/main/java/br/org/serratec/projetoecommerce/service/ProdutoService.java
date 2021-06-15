package br.org.serratec.projetoecommerce.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.projetoecommerce.model.Produto;
import br.org.serratec.projetoecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private FotoService fotoService;

	public Produto inserir(Produto produto, MultipartFile file) throws IOException {
		fotoService.inserir(produto, file);
		return adicionarFotoUrl(produto);
	}

	public Produto adicionarFotoUrl(Produto produto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produto/{id}/foto")
				.buildAndExpand(produto.getId()).toUri();

		System.out.println("URI" + uri);
		produto.setNome(produto.getNome());
		produto.setUrl(uri.toString());
		return produto;
	}

	public ResponseEntity<Produto> buscar(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return ResponseEntity.ok(produto.get());
	}

	public ResponseEntity<List<Produto>> listar() {
		List<Produto> produto = produtoRepository.findAll();
		return ResponseEntity.ok(produto);
	}

	public ResponseEntity<Produto> atualizar(Long id, Produto produto) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produto.setId(id);
		produto = produtoRepository.save(produto);
		return ResponseEntity.ok(produto);
	}

	public ResponseEntity<Void> delete(Long id) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
