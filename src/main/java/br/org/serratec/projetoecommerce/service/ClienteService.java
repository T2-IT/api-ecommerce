package br.org.serratec.projetoecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.org.serratec.projetoecommerce.dto.ClienteDTO;
import br.org.serratec.projetoecommerce.exception.ClienteException;
import br.org.serratec.projetoecommerce.exception.EmailException;
import br.org.serratec.projetoecommerce.model.Cliente;
import br.org.serratec.projetoecommerce.repository.ClienteRepository;

// alterar
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ResponseEntity<Cliente> inserir(Cliente cliente) throws ClienteException, EmailException {
		Cliente clienteEmail = clienteRepository.findByEmail(cliente.getEmail());
		Cliente clienteCPF = clienteRepository.findByCpf(cliente.getCpf());

		if (clienteEmail != null)
			throw new EmailException("E-mail já cadastrado!");

		if (clienteCPF != null)
			throw new ClienteException("CPF já cadastrado!");

		clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}

	public ResponseEntity<ClienteDTO> buscar(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		Cliente cliente1 = cliente.get();
		ClienteDTO clienteDTO = new ClienteDTO(cliente1);

		if (cliente.isPresent())
			return ResponseEntity.ok(clienteDTO);
		else
			return null;
	}

	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> clientes = clienteRepository.findAll();

		return ResponseEntity.ok(clientes);
	}

	public ResponseEntity<Cliente> atualizar(Cliente cliente, Long id) {

		if (!clienteRepository.existsById(id))
			return ResponseEntity.notFound().build();

		cliente.setId(id);
		cliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}

	public ResponseEntity<Void> excluir(Long id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
