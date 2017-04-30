package hu.elte.cinema.dto;



public class OccupiedDto implements DtoInterface<Integer> {
    private Integer id;
    private String from;
    private String to;

    public OccupiedDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
