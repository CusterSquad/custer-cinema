package hu.elte.cinema.model;


import hu.elte.cinema.enums.AgeLimit;
import hu.elte.cinema.enums.ColumnSize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie implements ModelInterface<Integer>{

    @Id
    @Column(name = "MOVIE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "DUBBED", nullable = false)
    private Boolean dubbed;
    @Column(name = "DIRECTOR", nullable = false)
    private String director;
    @Column(name = "STORY", nullable = false, length = ColumnSize.HUGE)
    private String story;
    @Column(name = "LENGTH", nullable = false)
    private Integer length;
    @Column(name = "AGE_LIMIT", nullable = false)
    private AgeLimit ageLimit;
    @Column(name = "TICKET_SOLD")
    private Integer ticketSold;
    @Column(name = "MAX_SCREEN_NUMBER")
    private Integer maxScreenNumber;

    public Movie() {}

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

    public AgeLimit getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(AgeLimit ageLimit) {
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
