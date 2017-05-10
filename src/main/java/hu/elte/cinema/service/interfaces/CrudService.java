package hu.elte.cinema.service.interfaces;


import java.util.List;

public interface CrudService<EntityType, DtoType, IdType> {
    void create(DtoType dto);
    void delete(DtoType dto);
    void update(DtoType dto);
    DtoType findById(IdType id);

    boolean exists(IdType id);

    List<DtoType> list();
}
