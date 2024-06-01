package com.atvPOO.lanchonete.Models.itemCardapio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCardapioService {

    @Autowired
    private ItemCardapioRepository itemCardapioRepository;

    public ItemCardapio getItemCardapio(int id) {
        return itemCardapioRepository.findById(id);
    }

    public List<ItemCardapio> getAllItemCardapio() {
        return itemCardapioRepository.findAll();
    }

    public ItemCardapio saveItemCardapio(ItemCardapio itemCardapio) {
        return itemCardapioRepository.save(itemCardapio);
    }

    public ItemCardapio updateItemCardapio(int id, ItemCardapio itemCardapioDetails) {
        ItemCardapio itemCardapio = itemCardapioRepository.findById(id)/*.orElseThrow(() -> new ResourceNotFoundException("ItemCardapio", "id", id))*/;
        itemCardapio.setNome(itemCardapioDetails.getNome());
        itemCardapio.setComponentes(itemCardapioDetails.getComponentes());
        itemCardapio.setPreco(itemCardapioDetails.getPreco());
        ItemCardapio updatedItemCardapio = itemCardapioRepository.save(itemCardapio);
        return updatedItemCardapio;
    }

    public void deleteItemCardapio(int id) {
        itemCardapioRepository.deleteById(id);
    }
}
