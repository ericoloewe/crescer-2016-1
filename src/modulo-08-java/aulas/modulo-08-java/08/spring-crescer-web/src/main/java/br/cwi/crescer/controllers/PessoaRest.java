/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.controllers;

import br.cwi.crescer.models.Pessoa;
import br.cwi.crescer.services.PessoaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author erico.loewe
 */
@RestController
public class PessoaRest {

    @Autowired
    PessoaService service;
    
    @RequestMapping(value = "/current_date_time")
    public Date date() {
        return new Date();
    }
    
    @ResponseBody
    @RequestMapping("/pessoa")
    public List<Pessoa> list() {
        return service.list();
    }
}
