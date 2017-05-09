package hu.elte.cinema.dao.impl;


import hu.elte.cinema.dao.interfaces.CrudDao;
import hu.elte.cinema.model.ModelInterface;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
@Transactional
public class CrudDaoImpl<EntityType extends ModelInterface<IdType>, IdType extends Serializable> extends HibernateDaoSupport
        implements CrudDao<EntityType, IdType>{

    private final Class<EntityType> entityTypeClass;

    public CrudDaoImpl(Class<EntityType> entityTypeClass, SessionFactory sessionFactory) {
        this.entityTypeClass = entityTypeClass;
        super.setSessionFactory(sessionFactory);
    }


    @Override
    public void createEntity(EntityType entity) {
        currentSession().persist(entity);
    }

    @Override
    public void updateEntity(EntityType entity) {
        currentSession().merge(entity);
    }

    @Override
    public void deleteEntity(EntityType entity) {
        currentSession().delete(entity);
    }

    @Override
    public EntityType findById(IdType id) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityTypeClass);
        criteria.add(Restrictions.idEq(id));
        Criteria executableCriteria = criteria.getExecutableCriteria(currentSession());
        return (EntityType)executableCriteria.uniqueResult();
    }

    @Override
    public boolean exists(IdType id) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityTypeClass);
        criteria.add(Restrictions.idEq(id));
        criteria.setProjection(Projections.rowCount());
        Criteria executableCriteria = criteria.getExecutableCriteria(currentSession());
        return 1L == (Long) executableCriteria.uniqueResult();
    }

    @Override
    public List<EntityType> list() {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityTypeClass);
        Criteria executeableCriteria = criteria.getExecutableCriteria(currentSession());
        return executeableCriteria.list();
    }
}
