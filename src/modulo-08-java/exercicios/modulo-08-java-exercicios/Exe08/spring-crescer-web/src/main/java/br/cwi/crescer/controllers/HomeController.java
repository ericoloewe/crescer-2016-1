/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Érico de Souza Loewe
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    String toIndex(Model model) {
        model.addAttribute("name", "Érico de Souza Loewe");
        return "index";
    }
}
