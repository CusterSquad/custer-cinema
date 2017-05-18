package hu.elte.cinema.converter.model;


import hu.elte.cinema.dao.interfaces.MovieDao;
import hu.elte.cinema.dao.interfaces.RoomDao;
import hu.elte.cinema.dto.ScreeningDto;
import hu.elte.cinema.model.Screening;
import hu.elte.cinema.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ScreeningConverter implements Converter<ScreeningDto, Screening>{

    @Autowired
    private RoomDao roomDao;
    @Autowired
    private MovieDao movieDao;

    @Override
    public Screening convert(ScreeningDto screeningDto) {
        Screening result = new Screening();
        result.setId(screeningDto.getId());
        result.setDate(DateUtil.getDate(screeningDto.getDate()));
        result.setMovie(movieDao.findById(screeningDto.getMovieId()));
        result.setRoom(roomDao.findById(screeningDto.getRoomId()));
        return result;
    }
}
