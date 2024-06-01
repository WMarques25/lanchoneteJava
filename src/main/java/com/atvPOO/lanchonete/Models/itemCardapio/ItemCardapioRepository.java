package com.atvPOO.lanchonete.Models.itemCardapio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Integer> {
    ItemCardapio findById(int id);
}