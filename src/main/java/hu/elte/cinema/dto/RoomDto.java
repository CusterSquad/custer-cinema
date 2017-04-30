package hu.elte.cinema.dto;


import java.util.ArrayList;
import java.util.Collection;

public class RoomDto implements DtoInterface<Integer> {
    private Integer id;
    private String roomName;
    private Integer maxRowNumber;
    private Integer maxColumnNumber;
    private Collection<SeatDto> seats;
    private Collection<OccupiedDto> occupied;

    public RoomDto() {
        seats = new ArrayList<>();
        occupied = new ArrayList<>();
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

    public Collection<SeatDto> getSeats() {
        return seats;
    }

    public void setSeats(Collection<SeatDto> seats) {
        this.seats = seats;
    }

    public Collection<OccupiedDto> getOccupied() {
        return occupied;
    }

    public void setOccupied(Collection<OccupiedDto> occupied) {
        this.occupied = occupied;
    }
}
