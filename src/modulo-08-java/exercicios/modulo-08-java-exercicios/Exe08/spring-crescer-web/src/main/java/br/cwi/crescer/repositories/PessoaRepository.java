/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositories;

import br.cwi.crescer.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author erico.loewe
 */
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
    
}
