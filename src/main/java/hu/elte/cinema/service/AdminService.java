package hu.elte.cinema.service;


import hu.elte.cinema.dto.DtoInterface;
import hu.elte.cinema.dto.ScreeningDto;
import hu.elte.cinema.dto.SimpleDto;
import hu.elte.cinema.dto.TicketDto;
import hu.elte.cinema.model.Ticket;
import hu.elte.cinema.response.CustomResponse;
import hu.elte.cinema.response.CustomResponseFactory;
import hu.elte.cinema.service.interfaces.CrudService;
import hu.elte.cinema.service.interfaces.ScreeningService;
import hu.elte.cinema.service.interfaces.TicketService;
import hu.elte.cinema.util.Wrapper;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SuppressWarnings({ "rawtypes", "unchecked" })
public class AdminService {

    private final CrudService crudService;
    private final CustomResponseFactory customResponseFactory;
    private static Logger logger = Logger.getLogger(AdminService.class);
    public AdminService(CrudService<?, DtoInterface, String> crudService, CustomResponseFactory customResponseFactory) {
        this.crudService = crudService;
        this.customResponseFactory = customResponseFactory;
    }

    public CustomResponse list() {
        CustomResponse response;
        try {
            response = customResponseFactory.successfullResponse(crudService.list());
        } catch (Exception ex) {
            logger.error(ex);
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse create(DtoInterface dtoObject) {
        CustomResponse response;
        try {
            crudService.create(dtoObject);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            logger.error(ex);
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse update(DtoInterface dtoObject) {
        CustomResponse response;
        try {
            crudService.update(dtoObject);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            logger.error(ex);
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse delete(DtoInterface dtoObject) {
        CustomResponse response;
        try {
            DtoInterface temp = (DtoInterface) crudService.findById(dtoObject.getId());
            crudService.delete(temp);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            logger.error(ex);
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse findById(Integer id) {
        CustomResponse response;
        try {
            DtoInterface dtoObject = (DtoInterface) crudService.findById(id);
            response = customResponseFactory.successfullResponse(dtoObject);
        } catch (Exception ex) {
            logger.error(ex);
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse exists(Integer id) {
        CustomResponse response;
        try {
            Boolean result = crudService.exists(id);
            response = customResponseFactory.successfullResponse(result);
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse addNewScreening(ScreeningDto screeningDto) {
        CustomResponse response;
        try {
            ScreeningService screeningService = (ScreeningService) crudService;
            screeningService.createNewScreening(screeningDto);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            logger.error(ex);
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse addNewReservation(TicketDto ticketDto) {
        CustomResponse response;
        try {
            TicketService ticketService = (TicketService) crudService;
            ticketService.createNewReservation(ticketDto);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            logger.error(ex);
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse deleteScreening(SimpleDto simpleDto) {
        CustomResponse response;
        try {
            ScreeningService screeningService = (ScreeningService) crudService;
            screeningService.deleteScreeningById(simpleDto.getId());
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            logger.error(ex);
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse deleteResevation(SimpleDto simpleDto) {
        CustomResponse response;
        try {
            TicketService ticketService = (TicketService) crudService;
            ticketService.deleteReservation(simpleDto.getId());
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            logger.error(ex);
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
}
