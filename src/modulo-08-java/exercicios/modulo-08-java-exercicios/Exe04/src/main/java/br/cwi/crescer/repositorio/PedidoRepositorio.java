/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.Pedido;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Érico de Souza Loewe
 */
public class PedidoRepositorio extends RepositorioBase<Pedido> implements Repositorio<Pedido> {

    public void adicionar(Pedido pedido) {
        super.adicionar(pedido);
    }

    public void atualizar(Pedido pedido) {
        super.atualizar(pedido);
    }

    public void deletar(Long idPedido) {
        super.deletar(idPedido);
    }

    public List<Pedido> listar() {
        return super.listar("Pedido");
    }
}
