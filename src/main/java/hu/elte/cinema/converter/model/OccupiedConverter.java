package hu.elte.cinema.converter.model;

import hu.elte.cinema.dto.OccupiedDto;
import hu.elte.cinema.model.Occupied;
import hu.elte.cinema.util.DateUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
public class OccupiedConverter implements Converter<OccupiedDto, Occupied> {

    @Override
    public Occupied convert(OccupiedDto occupiedDto)  {
        Occupied result = new Occupied();
        result.setId(occupiedDto.getId());
        result.setFrom(DateUtil.getDate(occupiedDto.getFrom()));
        result.setTo(DateUtil.getDate(occupiedDto.getTo()));
        return result;
    }
}
