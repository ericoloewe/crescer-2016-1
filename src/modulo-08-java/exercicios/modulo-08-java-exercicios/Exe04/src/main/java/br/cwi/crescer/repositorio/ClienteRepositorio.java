/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.Cidade;
import br.cwi.crescer.entity.Cliente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Érico de Souza Loewe
 */
public class ClienteRepositorio extends RepositorioBase<Cliente> implements Repositorio<Cliente> {

    public void adicionar(Cliente cliente) {
        super.adicionar(cliente);
    }

    public void atualizar(Cliente cliente) {
        super.atualizar(cliente);
    }

    public void deletar(Long idCliente) {
        super.deletar(idCliente);
    }

    @Override
    public List<Cliente> listar() {
        return super.listar("Cliente");
    }
    
}
