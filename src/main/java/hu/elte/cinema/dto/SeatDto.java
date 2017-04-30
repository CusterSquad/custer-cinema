package hu.elte.cinema.dto;


public class SeatDto implements DtoInterface<Integer> {

    private Integer id;
    private Integer x;
    private Integer y;
    private Boolean reserved;

    public SeatDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
