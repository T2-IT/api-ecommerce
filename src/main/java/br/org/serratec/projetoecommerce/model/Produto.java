package br.org.serratec.projetoecommerce.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	@ApiModelProperty(value = "Identificador único do produto")
	private Long id;

	@ApiModelProperty(value = "Nome do produto", required = true)
	private String nome;
	
	@ApiModelProperty(value = "Descrição do produto")
	private String descricao;
	
	@Column(name = "qtd_estoque")
	@ApiModelProperty(value = "Quantidade do produto em estoque", required = true)
	private Integer qtdEstoque;
	
	@Column(name = "data_cadastro")
	@ApiModelProperty(value = "Data de cadastro do produto", required = true)
	private LocalDate dataCadastro;
	
	@Column(name = "valor_unitario")
	@ApiModelProperty(value = "Valor do produto", required = true)
	private Double valorUnitario;
	
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@Override
	public String toString() {
		return "Produto [nome=" + nome + "]";
	}

	public Produto(Long id, String nome, String descricao, Integer qtdEstoque, LocalDate dataCadastro,
			Double valorUnitario, String url, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.url = url;
		this.categoria = categoria;
	}

	public Produto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
