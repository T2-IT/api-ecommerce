package br.org.serratec.projetoecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.org.serratec.projetoecommerce.config.MailConfig;
import br.org.serratec.projetoecommerce.model.Pedido;
import br.org.serratec.projetoecommerce.model.StatusPedido;
import br.org.serratec.projetoecommerce.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private MailConfig mailConfig;

	public ResponseEntity<Pedido> editarStatusPedido(Long id, StatusPedido statusPedido) {
		Pedido pedido = pedidoRepository.getById(id);
		if (pedido != null) {
			pedido.setId(id);
			pedido.setStatusPedido(statusPedido);
			pedidoRepository.save(pedido);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	public ResponseEntity<Pedido> finalizarPedido(Long id) {
		Pedido pedido = pedidoRepository.getById(id);
		if (pedido != null) {
			pedido.setStatusPedido(StatusPedido.FINALIZADO);
			pedidoRepository.save(pedido);
			mailConfig.finalizarPedido(pedido.getCliente().getEmail(),
					"Pedido finalizado \nn° pedido:" + pedido.getId(),
					"data envio:" + pedido.getDataEnvio() + "\ndata entrega: " + pedido.getDataEntrega()
							+ "\nprodutos: " + pedido.getItemPedido());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	public Pedido inserir(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
}
