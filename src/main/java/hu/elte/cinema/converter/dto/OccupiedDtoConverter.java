package hu.elte.cinema.converter.dto;


import hu.elte.cinema.dto.OccupiedDto;
import hu.elte.cinema.model.Occupied;
import hu.elte.cinema.util.DateUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class OccupiedDtoConverter implements Converter<Occupied, OccupiedDto> {

    @Override
    public OccupiedDto convert(Occupied occupied) {
        OccupiedDto result = new OccupiedDto();
        result.setFrom(DateUtil.getString(occupied.getFrom()));
        result.setTo(DateUtil.getString(occupied.getTo()));
        return result;
    }
}
