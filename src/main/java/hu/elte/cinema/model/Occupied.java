package hu.elte.cinema.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OCCUPIED")
public class Occupied implements ModelInterface<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "OCCUPIED_FROM", nullable = false)
    private Date from;
    @Column(name = "OCCUPIED_TO", nullable = false)
    private Date to;

    public Occupied() {}

    public Occupied(Date from, Date to) {
        this.from = from;
        this.to = to;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
