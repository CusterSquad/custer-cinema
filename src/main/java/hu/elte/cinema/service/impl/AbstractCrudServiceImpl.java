package hu.elte.cinema.service.impl;


import hu.elte.cinema.dao.interfaces.CrudDao;
import hu.elte.cinema.dto.DtoInterface;
import hu.elte.cinema.model.ModelInterface;
import hu.elte.cinema.service.interfaces.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractCrudServiceImpl<EntityType extends ModelInterface<IdType>, DtoType extends DtoInterface<IdType>, IdType extends Serializable>
        implements CrudService<EntityType, DtoType, IdType>{

    @Autowired
    private ConversionService conversionService;

    private final CrudDao<EntityType, IdType> dao;
    private final Class<EntityType> entityTypeClass;
    private final Class<DtoType> dtoTypeClass;

    public AbstractCrudServiceImpl(Class<EntityType> entityTypeClass, Class<DtoType> dtoTypeClass, CrudDao<EntityType, IdType> dao) {
        this.dao = dao;
        this.entityTypeClass = entityTypeClass;
        this.dtoTypeClass = dtoTypeClass;
    }

    @Override
    public void create(DtoType dto) {
        EntityType entity = conversionService.convert(dto, entityTypeClass);
        dao.createEntity(entity);
    }

    @Override
    public void delete(DtoType dto) {
        EntityType entity = conversionService.convert(dto, entityTypeClass);
        dao.deleteEntity(entity);
    }

    @Override
    public void update(DtoType dto) {
        EntityType entity = conversionService.convert(dto, entityTypeClass);
        dao.updateEntity(entity);
    }


    @Override
    public DtoType findById(IdType id) {
        EntityType entity = dao.findById(id);
        DtoType result = conversionService.convert(entity, dtoTypeClass);
        return result;
    }

    @Override
    public boolean exists(IdType id) {
        return dao.exists(id);
    }

    @Override
    public List<DtoType> list() {
        List<EntityType> entityList = dao.list();
        List<DtoType> result = entityList.stream().map(entity -> conversionService.convert(entity, dtoTypeClass)).collect(Collectors.toList());
        return result;
    }
}
