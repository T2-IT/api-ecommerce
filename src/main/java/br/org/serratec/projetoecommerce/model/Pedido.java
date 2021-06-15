package br.org.serratec.projetoecommerce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	@ApiModelProperty(value = "Identificador único do pedido")
	private Long id;

	@Column(name = "data_pedido")
	@ApiModelProperty(value = "Data do pedido")
	private LocalDate dataPedido;

	@Column(name = "data_entrega")
	@ApiModelProperty(value = "Data de entrega do pedido")
	private LocalDate dataEntrega;

	@Column(name = "data_envio")
	@ApiModelProperty(value = "Data de envio do pedido")
	private LocalDate dataEnvio;

	@Transient
	@ApiModelProperty(value = "Total geral do pedido")
	private Double totalGeral;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<ItemPedido> itemPedido = new ArrayList<ItemPedido>();

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	@JsonBackReference
	private Cliente cliente;

	private StatusPedido statusPedido;

	public Pedido() {
	}

	public Pedido(Long id, LocalDate dataPedido, LocalDate dataEntrega, LocalDate dataEnvio, Double totalGeral,
			List<ItemPedido> itemPedido, Cliente cliente, StatusPedido statusPedido) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.totalGeral = totalGeral;
		this.itemPedido = itemPedido;
		this.cliente = cliente;
		this.statusPedido = statusPedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Transient
	public Double getTotalGeral() {
		double soma = 0;
		for (ItemPedido item : itemPedido) {
			soma += item.getSubTotal();
		}
		return soma;
	}

	public void setTotalGeral(Double totalGeral) {
		this.totalGeral = totalGeral;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
