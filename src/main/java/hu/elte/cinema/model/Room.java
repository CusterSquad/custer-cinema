package hu.elte.cinema.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Room")
public class Room implements ModelInterface<Integer>{
    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "ROOM_NAME", nullable = false)
    private String roomName;
    @Column(name = "MAX_ROW", nullable = false)
    private Integer maxRowNumber;
    @Column(name = "MAX_COL", nullable = false)
    private Integer maxColumnNumber;

    @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.PERSIST}, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Seat> seats;
    @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.PERSIST}, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Occupied> occupied;

    public Room() {
        occupied = new ArrayList<>();
        seats = new ArrayList<>();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getMaxRowNumber() {
        return maxRowNumber;
    }

    public void setMaxRowNumber(Integer maxRowNumber) {
        this.maxRowNumber = maxRowNumber;
    }

    public Integer getMaxColumnNumber() {
        return maxColumnNumber;
    }

    public void setMaxColumnNumber(Integer maxColumnNumber) {
        this.maxColumnNumber = maxColumnNumber;
    }

    public Collection<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Collection<Seat> seats) {
        this.seats = seats;
    }

    public Collection<Occupied> getOccupied() {
        return occupied;
    }

    public void setOccupied(Collection<Occupied> occupied) {
        this.occupied = occupied;
    }

    public Seat getSeat(int x, int y) {
        for(Seat seat : this.seats) {
            if(seat.getX() == x && seat.getY() == y) {
                return seat;
            }
        }
        return null;
    }
}
