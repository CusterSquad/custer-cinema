package hu.elte.cinema.converter.model;

import hu.elte.cinema.dto.RoomDto;
import hu.elte.cinema.dto.SeatDto;
import hu.elte.cinema.model.Occupied;
import hu.elte.cinema.model.Room;
import hu.elte.cinema.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RoomConverter implements Converter<RoomDto, Room> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public Room convert(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setRoomName(roomDto.getRoomName());
        room.setMaxColumnNumber(roomDto.getMaxColumnNumber());
        room.setMaxRowNumber(roomDto.getMaxRowNumber());
        room.setOccupied(roomDto.getOccupied().stream().map(item -> conversionService.convert(item, Occupied.class)).collect(Collectors.toList()));
        room.setSeats(roomDto.getSeats().stream().map(item -> conversionService.convert(item, Seat.class)).collect(Collectors.toList()));
        return room;
    }
}
