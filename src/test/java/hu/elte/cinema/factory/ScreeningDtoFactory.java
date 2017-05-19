package hu.elte.cinema.factory;


import hu.elte.cinema.dto.ScreeningDto;
import hu.elte.cinema.service.interfaces.ScreeningService;

import java.util.Date;
import java.util.UUID;

public class ScreeningDtoFactory {
    private final ScreeningService screeningService;
    private final MovieDtoFactory movieDtoFactory;
    private final RoomDtoFactory roomDtoFactory;

    public ScreeningDtoFactory(ScreeningService screeningService, MovieDtoFactory movieDtoFactory, RoomDtoFactory roomDtoFactory) {
        this.screeningService = screeningService;
        this.movieDtoFactory = movieDtoFactory;
        this.roomDtoFactory = roomDtoFactory;
    }
    public ScreeningDto createAndSave() {
        ScreeningDto screeningDto = createOne();
        screeningDto.setId(screeningService.create(screeningDto));
        return screeningDto;
    }
    public ScreeningDto createOne() {
        ScreeningDto screeningDto = new ScreeningDto();
        screeningDto.setDate(new Date().toString());
        screeningDto.setMovieTitle(UUID.randomUUID().toString());
        screeningDto.setMovieId(movieDtoFactory.createAndSave().getId());
        screeningDto.setRoomId(roomDtoFactory.createAndSave().getId());
        return screeningDto;
    }
}
