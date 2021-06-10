package br.org.serratec.projetoecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.projetoecommerce.dto.ClienteDTO;
import br.org.serratec.projetoecommerce.exception.EmailException;
import br.org.serratec.projetoecommerce.model.Cliente;
import br.org.serratec.projetoecommerce.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public Cliente inserir(Cliente user) throws EmailException {
		Cliente cliente = clienteRepository.findByEmail(user.getEmail());
		if (cliente != null) {
			throw new EmailException("Email já cadastrado");
		}
		user.setSenha(passwordEncoder.encode(user.getSenha()));
		return clienteRepository.save(user);
	}

	public boolean buscar(Long id) {
		if (!clienteRepository.existsById(id))
			return false;
		else
			return true;
	}

	public List<ClienteDTO> listar() {
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();

		for (Cliente cliente : clientes) {
			ClienteDTO dto = new ClienteDTO();
			clientesDTO.add(dto);
		}

		return clientesDTO;
	}

	public boolean excluir(Long id) {
		if (!clienteRepository.existsById(id)) {
			return false;
		}
		clienteRepository.deleteById(id);
		return true;
	}

}
