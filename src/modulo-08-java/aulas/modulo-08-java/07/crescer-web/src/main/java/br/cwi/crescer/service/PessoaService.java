package br.cwi.crescer.service;

import br.cwi.crescer.service.abstracts.AbstractService;
import br.cwi.crescer.entity.Pessoa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class PessoaService extends AbstractService<Pessoa> {

    @PersistenceContext(unitName = "crescerPU")
    private EntityManager entityManager;

    public PessoaService() {
        super(Pessoa.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
