package br.org.serratec.projetoecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.org.serratec.projetoecommerce.model.Endereco;
import br.org.serratec.projetoecommerce.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco inserir(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco buscar(String cep) {
		Optional<Endereco> endereco = Optional.ofNullable(enderecoRepository.findByCep(cep));
		if (endereco.isPresent()) {
			return endereco.get();
		} else {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://viacep.com.br/ws/" + cep + "/json/";
			Optional<Endereco> enderecoViaCep = Optional.ofNullable(restTemplate.getForObject(uri, Endereco.class));
			if (enderecoViaCep.get().getCep() != null) {
				String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
				enderecoViaCep.get().setCep(cepSemTraco);
				return inserir(enderecoViaCep.get());
			} else {
				return null;
			}
		}
	}

	public ResponseEntity<Endereco> atualizar(Endereco endereco, Long id) {
		if (!enderecoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		endereco.setId(id);
		endereco = enderecoRepository.save(endereco);
		return ResponseEntity.ok(endereco);
	}

	public ResponseEntity<Void> deletar(Long id) {
		if (!enderecoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		enderecoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
