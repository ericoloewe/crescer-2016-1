package br.cwi.crescer.controllers;

import br.cwi.crescer.controllers.abstracts.AbstractController;
import br.cwi.crescer.entity.Pessoa;
import br.cwi.crescer.service.PessoaService;
import br.cwi.crescer.utils.FacesUtils;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Érico de Souza Loewe
 */
@ManagedBean
@ViewScoped
public class PessoaController extends AbstractController<Pessoa, PessoaService> {
    
    @EJB
    private PessoaService pessoaService;

    @Override
    public PessoaService getService() {
        return pessoaService;
    }

    @PostConstruct
    public void init() {
        this.setEntity(new Pessoa());
        this.listAll();
    }

    public String save() {
        super.saveOrUpdate(); 
        FacesUtils.addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro incluido com sucesso!", ""));
        return "consultar_pessoa";
    }

}
