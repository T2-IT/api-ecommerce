package br.org.serratec.projetoecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.projetoecommerce.dto.ClienteDTO;
import br.org.serratec.projetoecommerce.exception.ClinteException;
import br.org.serratec.projetoecommerce.exception.EmailException;
import br.org.serratec.projetoecommerce.model.Cliente;
import br.org.serratec.projetoecommerce.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public ResponseEntity<Cliente> inserir(Cliente cliente){
		Cliente clienteEmail = clienteRepository.findByEmail(cliente.getEmail());
		Cliente clienteCPF = clienteRepository.findByCpf(cliente.getCpf());
		
		try {
			if (clienteEmail != null)
				throw new EmailException("E-mail já cadastrado!");
			
			if (clienteCPF != null)
				throw new ClinteException("CPF já cadastrado!");
				
			clienteRepository.save(cliente);
		} catch (ClinteException e) {
			e.getMessage();
		} catch (EmailException e) {
			e.getMessage();
		}
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

	public ResponseEntity<List<ClienteDTO>> listar() {
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();

		for (Cliente cliente : clientes) {
			ClienteDTO dto = new ClienteDTO();
			clientesDTO.add(dto);
		}

		return ResponseEntity.ok(clientesDTO);
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
