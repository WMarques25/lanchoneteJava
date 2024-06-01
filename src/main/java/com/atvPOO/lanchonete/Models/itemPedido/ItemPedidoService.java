package com.atvPOO.lanchonete.Models.itemPedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atvPOO.lanchonete.Models.pedido.Pedido;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> getAllItemPedidos() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido saveItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public ItemPedido updateItemPedido(int id, ItemPedido itemPedidoDetails) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id)/*.orElseThrow(() -> new ResourceNotFoundException("ItemPedido", "id", id))*/;
        itemPedido.setPedido(itemPedidoDetails.getPedido());
        itemPedido.setItemCardapio(itemPedidoDetails.getItemCardapio());
        itemPedido.setPronto(itemPedidoDetails.isPronto());
        ItemPedido updatedItemPedido = itemPedidoRepository.save(itemPedido);
        return updatedItemPedido;
    }

    public void deleteItemPedido(int id) {
        itemPedidoRepository.deleteById(id);
    }
}

