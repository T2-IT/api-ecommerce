package br.org.serratec.projetoecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetoecommerce.model.Cliente;
import br.org.serratec.projetoecommerce.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente inserir(Cliente cliente) {
		cliente=clienteRepository.save(cliente);
		return cliente;
	}
	
	public boolean buscar(Long id) {
		if (!clienteRepository.existsById(id)) {
			return false;
		}else {
			return true;
		}
	}
	public List<Cliente> listar(){
		List<Cliente> clientes = new ArrayList<>();
		return clientes;
	}
	
	public boolean deletar(Long id) {
		if (!clienteRepository.existsById(id)) {
			return false;
		}
		clienteRepository.deleteById(id);
		return true;
	}

}
