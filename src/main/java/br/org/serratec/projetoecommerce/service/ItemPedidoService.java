package br.org.serratec.projetoecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.org.serratec.projetoecommerce.model.ItemPedido;
import br.org.serratec.projetoecommerce.model.Pedido;
import br.org.serratec.projetoecommerce.model.Produto;
import br.org.serratec.projetoecommerce.repository.ItemPedidoRepository;
import br.org.serratec.projetoecommerce.repository.PedidoRepository;
import br.org.serratec.projetoecommerce.repository.ProdutoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	public ItemPedido inserir(ItemPedido itemPedido) {
		Optional<Produto> produto = produtoRepository.findById(itemPedido.getProduto().getId());
		Optional<Pedido> pedido = pedidoRepository.findById(itemPedido.getPedido().getId());
		itemPedido.setPrecoVenda(produto.get().getValorUnitario());
		itemPedido.setSubTotal();
		return itemPedidoRepository.save(itemPedido);
	}

	public ResponseEntity<List<ItemPedido>> listar() {
		List<ItemPedido> itemPedidos = itemPedidoRepository.findAll();
		return ResponseEntity.ok(itemPedidos);
	}
}
