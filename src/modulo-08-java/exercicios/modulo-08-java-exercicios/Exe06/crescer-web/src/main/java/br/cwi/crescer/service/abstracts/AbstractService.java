package br.cwi.crescer.service.abstracts;

import br.cwi.crescer.entity.SerializableID;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

/**
 * @author Carlos H. Nonnemacher
 * @param <Entity>
 */
public abstract class AbstractService<Entity extends SerializableID> implements IAbstractService<Entity> {

    private final Class<Entity> classType;

    public AbstractService(Class<Entity> classType) {
        this.classType = classType;
    }

    @Override
    public void saveOrUpdate(Entity enity) {
        this.getEntityManager().merge(enity);
    }

    @Override
    public void remove(Entity entity) {
        entity = this.getEntityManager().find(classType, entity.getId());
        this.getEntityManager().remove(entity);
    }

    @Override
    public List<Entity> find(Entity entity) {
        return this.getEntityManager().unwrap(Session.class).createCriteria(classType).add(Example.create(entity).ignoreCase().enableLike(MatchMode.ANYWHERE)).list();
    }

    @Override
    public List<Entity> listAll() {
        return this.getEntityManager().unwrap(Session.class).createCriteria(classType).list();
    }

    public abstract EntityManager getEntityManager();

}
