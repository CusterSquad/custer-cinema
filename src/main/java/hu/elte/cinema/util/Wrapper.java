package hu.elte.cinema.util;


public class Wrapper<DtoType> {
    private DtoType object;

    public DtoType getObject() {
        return object;
    }
    public void setObject(DtoType object) {
        this.object = object;
    }
}
