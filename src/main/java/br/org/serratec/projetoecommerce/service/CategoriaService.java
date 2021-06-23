package br.org.serratec.projetoecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.org.serratec.projetoecommerce.model.Categoria;
import br.org.serratec.projetoecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria inserir(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> categoria = categoriaRepository.findAll();
		return ResponseEntity.ok(categoria);
	}

	public ResponseEntity<Categoria> buscar(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return ResponseEntity.ok(categoria.get());
	}

	public ResponseEntity<Categoria> editar(Long id, Categoria categoria) {
		if (!categoriaRepository.existsById(id))
			return ResponseEntity.notFound().build();

		categoria.setId(id);
		categoria = categoriaRepository.save(categoria);
		return ResponseEntity.ok(categoria);
	}

	public ResponseEntity<Void> excluir(Long id) {
		if (!categoriaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		categoriaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
