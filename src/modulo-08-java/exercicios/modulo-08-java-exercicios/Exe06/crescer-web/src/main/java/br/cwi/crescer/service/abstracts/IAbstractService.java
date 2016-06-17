package br.cwi.crescer.service.abstracts;

import java.io.Serializable;
import java.util.List;

/**
 * @author Carlos H. Nonnemacher
 * @param <Entity>
 */
public interface IAbstractService<Entity> extends Serializable {

    void saveOrUpdate(Entity entity);

    void remove(Entity entity);

    List<Entity> find(Entity entity);

    List<Entity> listAll();
}
