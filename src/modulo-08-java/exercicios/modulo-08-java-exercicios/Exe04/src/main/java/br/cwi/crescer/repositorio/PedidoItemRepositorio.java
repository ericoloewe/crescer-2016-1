/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.PedidoItem;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Érico de Souza Loewe
 */
public class PedidoItemRepositorio extends RepositorioBase<PedidoItem> implements Repositorio<PedidoItem> {

    public void adicionar(PedidoItem pedidoItem) {
        super.adicionar(pedidoItem);
    }

    public void atualizar(PedidoItem pedidoItem) {
        super.atualizar(pedidoItem);
    }

    public void deletar(Long idPedidoItem) {
        super.deletar(idPedidoItem);
    }

    @Override
    public List<PedidoItem> listar() {
        return super.listar("PedidoItem");
    }
}
