package hu.elte.cinema.converter.model;

import hu.elte.cinema.dto.SeatDto;
import hu.elte.cinema.model.Seat;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SeatConverter implements Converter<SeatDto, Seat>{

    @Override
    public Seat convert(SeatDto seatDto) {
        Seat result = new Seat();
        result.setId(seatDto.getId());
        result.setX(seatDto.getX());
        result.setY(seatDto.getY());
        result.setReserved(seatDto.getReserved());
        return result;
    }
}
