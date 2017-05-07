package hu.elte.cinema.model;


public interface ModelInterface<IdType> {
    IdType getId();
    void setId(IdType id);
}
