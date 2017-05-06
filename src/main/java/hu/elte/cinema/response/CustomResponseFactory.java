package hu.elte.cinema.response;


public class CustomResponseFactory {
    private static final String DEFAULT_SUCCESS_MESSAGE = "A művelet végrehajtása sikeres.";

    public CustomResponseFactory() {

    }

    public CustomResponse successfullResponse() {
        return new CustomResponse(ResponseEnum.SUCCESS, null, DEFAULT_SUCCESS_MESSAGE);
    }
    public CustomResponse successfullResponse(String message) {
        return new CustomResponse(ResponseEnum.SUCCESS, null, message);
    }
    public CustomResponse successfullResponse(Object data) {
        return new CustomResponse(ResponseEnum.SUCCESS, data, DEFAULT_SUCCESS_MESSAGE);
    }
    public CustomResponse successfullResponse(String message, Object data) {
        return new CustomResponse(ResponseEnum.SUCCESS, data, message);
    }
    public CustomResponse errorResponse(Exception ex) {
        return new CustomResponse(ResponseEnum.FAILED, null, ex.getMessage());
    }
}
