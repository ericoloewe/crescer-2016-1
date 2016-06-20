/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.services;

import br.cwi.crescer.entity.Pessoa;
import br.cwi.crescer.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author erico.loewe
 */
@Service
public class PessoaService {
    
    @Autowired
    PessoaRepository repository;

    public Iterable<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa save(Pessoa p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
    
    public Pessoa findById(Long id) {
        return repository.findOne(id);
    }
}
