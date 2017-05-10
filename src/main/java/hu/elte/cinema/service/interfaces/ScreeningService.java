package hu.elte.cinema.service.interfaces;


import hu.elte.cinema.dto.ScreeningDto;
import hu.elte.cinema.model.Screening;

public interface ScreeningService extends CrudService<Screening, ScreeningDto, Integer> {
    void createNewScreening(ScreeningDto screeningDto) throws Exception;

    void deleteScreeningById(Integer id) throws Exception;
}
