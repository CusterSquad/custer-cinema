package hu.elte.cinema.dto;


public interface DtoInterface<IdType> {
    IdType getId();
    void setId(IdType id);
}
