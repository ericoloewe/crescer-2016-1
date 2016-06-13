/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import java.util.List;

/**
 *
 * @author Érico de Souza Loewe
 */
public interface Repositorio<T extends Object> {
    void adicionar(T obj);
    void atualizar(T obj);
    void deletar(Long obj);
    List<T> listar();
}
