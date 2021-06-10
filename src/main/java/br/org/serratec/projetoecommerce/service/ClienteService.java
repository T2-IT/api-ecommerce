package br.org.serratec.projetoecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.projetoecommerce.dto.ClienteDTO;
import br.org.serratec.projetoecommerce.model.Cliente;
import br.org.serratec.projetoecommerce.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO) throws EmailException {
	// 	Usuario u = usuarioRepository.findByEmail(usuarioInserirDTO.getEmail());

	// 	if (u != null) {
	// 		throw new EmailException("Email existente ! Insira outro");
	// 	}

	// 	Usuario usuario = new Usuario();
	// 	usuario.setNome(usuarioInserirDTO.getNome());
	// 	usuario.setEmail(usuarioInserirDTO.getEmail());
	// 	usuario.setPerfil("Usuário Padrão");
	// 	usuario.setSenha(bCryptPasswordEncoder.encode(usuarioInserirDTO.getSenha()));
	// 	usuario = usuarioRepository.save(usuario);
	// 	mailConfig.enviarEmail(usuarioInserirDTO.getEmail(), "Cadastro de Usuário!!", usuario.toString());
	// 	return new UsuarioDTO(usuario);

	// }
	
	// public ClienteDTO inserirCliente(ClienteDTO clienteDTO) throws EmailException {
	// 	Cliente cliente = clienteRepository.findByEmail(.getEmail());

	// }
	
	public boolean buscarCliente(Long id) {
		if (!clienteRepository.existsById(id)) {
			return false;
		}else {
			return true;
		}
	}
	public List<Cliente> listarClientes(){
		List<Cliente> clientes = new ArrayList<>();
		return clientes;
	}
	
	public boolean deletarCliente(Long id) {
		if (!clienteRepository.existsById(id)) {
			return false;
		}
		clienteRepository.deleteById(id);
		return true;
	}

}
