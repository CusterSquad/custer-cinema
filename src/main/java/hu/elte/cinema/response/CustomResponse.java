package hu.elte.cinema.response;


public class CustomResponse {
    private final ResponseEnum responseEnum;
    private final Object data;
    private final String message;

    public CustomResponse(ResponseEnum responseEnum, Object data, String message) {
        this.responseEnum = responseEnum;
        this.data = data;
        this.message = message;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
