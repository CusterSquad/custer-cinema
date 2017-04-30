package hu.elte.cinema.dto;



public class MovieDto implements DtoInterface<Integer>{
    private Integer id;
    private String title;
    private Boolean dubbed;
    private String director;
    private String story;
    private Integer length;
    private String ageLimit;
    private Integer ticketSold;
    private Integer maxScreenNumber;

    public MovieDto() {}

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDubbed() {
        return dubbed;
    }

    public void setDubbed(Boolean dubbed) {
        this.dubbed = dubbed;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Integer getTicketSold() {
        return ticketSold;
    }

    public void setTicketSold(Integer ticketSold) {
        this.ticketSold = ticketSold;
    }

    public Integer getMaxScreenNumber() {
        return maxScreenNumber;
    }

    public void setMaxScreenNumber(Integer maxScreenNumber) {
        this.maxScreenNumber = maxScreenNumber;
    }
}
