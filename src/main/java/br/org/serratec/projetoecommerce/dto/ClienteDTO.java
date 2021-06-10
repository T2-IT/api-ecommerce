package br.org.serratec.projetoecommerce.dto;

import br.org.serratec.projetoecommerce.model.Cliente;

public class ClienteDTO {
	private Long id;
	private String email;
	private String nomeCompleto;
	private String telefone;
	public ClienteDTO() {
		// TODO Auto-generated constructor stub
	}
	public ClienteDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.email = cliente.getEmail();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.telefone = cliente.getTelefone();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
