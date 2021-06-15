package br.org.serratec.projetoecommerce.dto;

import br.org.serratec.projetoecommerce.model.Cliente;
import br.org.serratec.projetoecommerce.model.Endereco;
import io.swagger.annotations.ApiModelProperty;

public class ClienteDTO {

	@ApiModelProperty(value = "Identificador único do cliente")
	private Long id;

	@ApiModelProperty(value = "Email do cliente", required = true)
	private String email;

	@ApiModelProperty(value = "Nome completo do cliente", required = true)
	private String nomeCompleto;

	@ApiModelProperty(value = "Telefone do cliente", required = true)
	private String telefone;

	@ApiModelProperty(value = "Endereço do cliente")
	private Endereco endereco;

	public ClienteDTO() {

	}

	public ClienteDTO(Long id, String email, String nomeCompleto, String telefone, Endereco endereco) {
		super();
		this.id = id;
		this.email = email;
		this.nomeCompleto = nomeCompleto;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public ClienteDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.email = cliente.getEmail();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.telefone = cliente.getTelefone();
		this.endereco = cliente.getEndereco();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
