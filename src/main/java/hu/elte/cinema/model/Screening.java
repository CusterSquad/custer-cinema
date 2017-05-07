package hu.elte.cinema.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SCREENING")
public class Screening implements ModelInterface<Integer>{
    @Id
    @Column(name = "SCREENING_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne( cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Movie movie;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Room room;
    @Column(name = "SCREENING_STARTS", nullable = false)
    private Date date;

    public Screening() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
