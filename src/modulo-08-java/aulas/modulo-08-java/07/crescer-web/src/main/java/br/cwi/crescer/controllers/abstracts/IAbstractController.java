package br.cwi.crescer.controllers.abstracts;

import br.cwi.crescer.service.abstracts.AbstractService;
import java.io.Serializable;

/**
 * @author Carlos H. Nonnemacher
 * @param <Entity>
 * @param <Service>
 */
public interface IAbstractController<Entity, Service extends AbstractService<Entity>> extends Serializable {

    Entity getEntity();
    
    Service getService();
    
    void saveOrUpdate();

    void remove();

    void find();

    void listAll();
}
