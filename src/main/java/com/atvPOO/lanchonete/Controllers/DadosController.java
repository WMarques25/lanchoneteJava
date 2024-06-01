package com.atvPOO.lanchonete.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atvPOO.lanchonete.Models.pedido.*;
import com.atvPOO.lanchonete.Models.itemCardapio.*;
import com.atvPOO.lanchonete.Models.itemPedido.*;

@RestController
@RequestMapping("/api")
public class DadosController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedidos")
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }
    

    @PutMapping("/pedido/{id}")
    public Pedido updatePedido(@PathVariable int id, @RequestBody Pedido pedidoDetails) {
        return pedidoService.updatePedido(id, pedidoDetails);
    }
}
