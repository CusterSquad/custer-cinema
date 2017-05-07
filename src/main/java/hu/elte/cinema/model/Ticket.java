package hu.elte.cinema.model;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Ticket")
public class Ticket implements ModelInterface<Integer>{

    @Id
    @Column(name = "TICKE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "PERSON_NAME", nullable = false)
    private String name;
    @Column(name = "PERSON_AGE", nullable = false)
    private Integer age;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Screening screening;
    @Column(name = "SEAT_ROW_NUMBER", nullable = false)
    private Integer seatX;
    @Column(name = "SEAT_COLUMN_NUMBER", nullable = false)
    private Integer seatY;

    public Ticket() {}

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Integer getSeatX() {
        return seatX;
    }

    public void setSeatX(Integer seatX) {
        this.seatX = seatX;
    }

    public Integer getSeatY() {
        return seatY;
    }

    public void setSeatY(Integer seatY) {
        this.seatY = seatY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
