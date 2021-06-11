package br.org.serratec.projetoecommerce.model;

public enum StatusPedido {
ENVIADO("ENVIADO"), ENCAMINHADO("ENVIADO") , ENTREGUE("ENVIADO"), PROCESSANDO("ENVIADO");
	
	private String status;

	private StatusPedido(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
