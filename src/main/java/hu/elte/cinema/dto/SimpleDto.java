package hu.elte.cinema.dto;

public class SimpleDto implements DtoInterface<Integer> {

    private Integer id;

    public SimpleDto() {}

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
