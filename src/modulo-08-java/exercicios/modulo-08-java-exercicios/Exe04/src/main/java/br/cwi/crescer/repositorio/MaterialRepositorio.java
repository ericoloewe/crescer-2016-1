/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.Material;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Érico de Souza Loewe
 */
public class MaterialRepositorio extends RepositorioBase<Material> implements Repositorio<Material> {

    public void adicionar(Material material) {
        super.adicionar(material);
    }

    public void atualizar(Material material) {
        super.atualizar(material);
    }

    public void deletar(Long idMaterial) {
        super.deletar(idMaterial);
    }

    public List<Material> listar() {
        return super.listar("Material");
    }
}
