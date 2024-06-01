package com.atvPOO.lanchonete.Models.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> getPedidosProntos() {
        return pedidoRepository.findByPronto(true);
    }

    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido updatePedido(int id, Pedido pedidoDetails) {
        Pedido pedido = pedidoRepository.findById(id)/*.orElseThrow(() -> new ResourceNotFoundException("Pedido", "id", id))*/;
        pedido.setCliente(pedidoDetails.getCliente());
        pedido.setEntregar(pedidoDetails.isEntregar());
        pedido.setEndereco(pedidoDetails.getEndereco());
        pedido.setPronto(pedidoDetails.isPronto());
        Pedido updatedPedido = pedidoRepository.save(pedido);
        return updatedPedido;
    }

    public void deletePedido(int id) {
        pedidoRepository.deleteById(id);
    }
}
