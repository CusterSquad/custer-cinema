package hu.elte.cinema.factory;


import hu.elte.cinema.dto.RoomDto;
import hu.elte.cinema.dto.SeatDto;
import hu.elte.cinema.model.Room;
import hu.elte.cinema.model.Seat;
import hu.elte.cinema.service.interfaces.RoomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RoomDtoFactory {
    private final RoomService roomService;

    public RoomDtoFactory(RoomService roomService) {
        this.roomService = roomService;
    }
    public RoomDto createAndSave() {
        RoomDto roomDto = createOne();
        roomDto.setId(roomService.create(roomDto));
        return roomDto;
    }
    public RoomDto createOne() {
        RoomDto room = new RoomDto();
        room.setMaxColumnNumber(new Random().nextInt(10));
        room.setMaxRowNumber(new Random().nextInt(10));
        room.setRoomName(UUID.randomUUID().toString());
        room.setOccupied(new ArrayList<>());
        room.setSeats(createSeats(room.getMaxRowNumber(), room.getMaxColumnNumber()));
        return room;
    }
    private List<SeatDto> createSeats(int row, int column) {
        List<SeatDto> result = new ArrayList<>();
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < column; ++j) {
                SeatDto seat = new SeatDto();
                seat.setReserved(false);
                seat.setX(i);
                seat.setY(j);
                result.add(seat);
            }
        }
        return result;
    }
}
