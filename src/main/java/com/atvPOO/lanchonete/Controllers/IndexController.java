package com.atvPOO.lanchonete.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.atvPOO.lanchonete.Models.itemCardapio.*;
import com.atvPOO.lanchonete.Models.itemPedido.*;
import com.atvPOO.lanchonete.Models.pedido.*;

@Controller
public class IndexController {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemCardapioService itemCardapioService;

    @Autowired
    private ItemPedidoService itemPedidoService;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("todosPedidos", pedidoService.getPedidosProntos());
        model.addAttribute("todosItens", itemCardapioService.getAllItemCardapio());
        return "index";
    }
    
    @PostMapping("/pedido")
    public String submitPedido(@ModelAttribute Pedido pedido) {
    Pedido savedPedido = pedidoService.savePedido(pedido);
    for (int itemId : pedido.getItensCardapioSelecionados()) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPedido(savedPedido);
        itemPedido.setItemCardapio(itemCardapioService.getItemCardapio(itemId));
        itemPedidoService.saveItemPedido(itemPedido);
    }
    return "redirect:/";
}

    @GetMapping("/cardapio")
    public String cardapio(Model model) {
        model.addAttribute("itemCardapio", new ItemCardapio());
        model.addAttribute("todosItens", itemCardapioService.getAllItemCardapio());
        return "cardapio";
    }

    @GetMapping("/pedidos")
    public String pedidos(Model model) {
        model.addAttribute("todosPedidos", pedidoService.getAllPedidos());
        return "pedidos";
    }

    @PostMapping("/itemCardapio")
    public String submitItemCardapio(@ModelAttribute ItemCardapio itemCardapio) {
        itemCardapioService.saveItemCardapio(itemCardapio);
        return "redirect:/cardapio";
    }
}
