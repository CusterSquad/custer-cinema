package hu.elte.cinema.converter.dto;


import hu.elte.cinema.dto.SeatDto;
import hu.elte.cinema.model.Seat;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SeatDtoConverter implements Converter<Seat, SeatDto> {

    @Override
    public SeatDto convert(Seat seat) {
        SeatDto result = new SeatDto();
        result.setId(seat.getId());
        result.setX(seat.getX());
        result.setY(seat.getY());
        result.setReserved(seat.getReserved());
        return result;
    }
}
