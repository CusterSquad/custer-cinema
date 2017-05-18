package hu.elte.cinema.converter.dto;

import hu.elte.cinema.dto.OccupiedDto;
import hu.elte.cinema.dto.RoomDto;
import hu.elte.cinema.dto.SeatDto;
import hu.elte.cinema.model.Occupied;
import hu.elte.cinema.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomDtoConverter implements Converter<Room, RoomDto> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public RoomDto convert(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setRoomName(room.getRoomName());
        roomDto.setMaxColumnNumber(room.getMaxColumnNumber());
        roomDto.setMaxRowNumber(room.getMaxRowNumber());
        roomDto.setOccupied(room.getOccupied().stream().map(item -> conversionService.convert(item, OccupiedDto.class)).collect(Collectors.toList()));
        roomDto.setSeats(room.getSeats().stream().map(item -> conversionService.convert(item, SeatDto.class)).collect(Collectors.toList()));
        return roomDto;
    }
}
