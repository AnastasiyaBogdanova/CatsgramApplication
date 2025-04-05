package ru.yandex.practicum.catsgram.exception;

public class ParameterNotValidException  extends IllegalArgumentException {
    private final String parameter;
    private final String reason;

    public ParameterNotValidException(String message, Throwable cause, String parameter, String reason) {
        super(message, cause);
        this.parameter = parameter;
        this.reason = reason;
    }

    public String getParameter() {
        return parameter;
    }

    public String getReason() {
        return reason;
    }
}
