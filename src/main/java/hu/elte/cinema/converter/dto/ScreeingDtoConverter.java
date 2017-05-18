package hu.elte.cinema.converter.dto;


import hu.elte.cinema.dto.ScreeningDto;
import hu.elte.cinema.model.Screening;
import hu.elte.cinema.util.DateUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ScreeingDtoConverter implements Converter<Screening, ScreeningDto> {


    @Override
    public ScreeningDto convert(Screening screening) {
        ScreeningDto result = new ScreeningDto();
        result.setId(screening.getId());
        result.setDate(DateUtil.getString(screening.getDate()));
        result.setMovieId(screening.getMovie().getId());
        result.setRoomId(screening.getRoom().getId());
        result.setMovieTitle(screening.getMovie().getTitle());
        return result;
    }
}
