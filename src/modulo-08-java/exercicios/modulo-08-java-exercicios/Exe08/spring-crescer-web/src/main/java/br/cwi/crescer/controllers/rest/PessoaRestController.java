/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.controllers.rest;

import br.cwi.crescer.entity.Pessoa;
import br.cwi.crescer.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author erico.loewe
 */
@RestController
@RequestMapping("/rest/pessoa")
public class PessoaRestController {
    @Autowired
    PessoaService service;
    
    @RequestMapping("/listar")
    public Iterable<Pessoa> list() {
        return service.findAll();
    }
}
