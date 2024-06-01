package com.atvPOO.lanchonete.Models.pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    Pedido findById(int id);
    List<Pedido> findByPronto(boolean pronto);
}

