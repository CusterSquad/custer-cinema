package hu.elte.cinema.service;

import hu.elte.cinema.dao.interfaces.CrudDao;
import hu.elte.cinema.dao.interfaces.ScreeningDao;
import hu.elte.cinema.dto.ScreeningDto;
import hu.elte.cinema.model.Screening;
import hu.elte.cinema.service.configuration.ServiceTestConfig;
import hu.elte.cinema.service.interfaces.CrudService;
import hu.elte.cinema.service.interfaces.ScreeningService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceTestConfig.class})
@Transactional
@Rollback(false)
public class ScreeningServiceTest extends AbstractServiceTest<Screening, ScreeningDto> {

    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private ScreeningDao screeningDao;
    @Autowired
    private ConversionService conversionService;

    @Override
    protected CrudService<Screening, ScreeningDto, Integer> getService() {
        return screeningService;
    }

    @Override
    protected CrudDao<Screening, Integer> getDao() {
        return screeningDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<Screening> getEntityClass() {
        return Screening.class;
    }

    @Override
    protected Screening createEntity(boolean withId) {
        Screening screening = new Screening();
        if(withId) {
            screening.setId(1);
        }
        return screening;
    }

    @Override
    protected ScreeningDto createDto() {
        return new ScreeningDto();
    }
}
