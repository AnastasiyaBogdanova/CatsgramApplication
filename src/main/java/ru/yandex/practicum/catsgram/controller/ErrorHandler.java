package ru.yandex.practicum.catsgram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(NotFoundException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(DuplicatedDataException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleDuplicatedData(DuplicatedDataException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(ConditionsNotMetException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleConditionsNotMet(ConditionsNotMetException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(ParameterNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleParameterInvalid(ParameterNotValidException e) {
        String message = String.format(
                "Некорректное значение параметра %s: %s",
                e.getParameter(),
                e.getReason()
        );
        return new ErrorResponse(message);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAnyException(Throwable e) {
        return new ErrorResponse("Произошла непредвиденная ошибка.");
    }

    public static class ErrorResponse {
        private final String error;

        public ErrorResponse(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }
    }
}

// Примеры классов исключений (должны быть определены в вашем проекте)
class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

class DuplicatedDataException extends RuntimeException {
    public DuplicatedDataException(String message) {
        super(message);
    }
}

class ConditionsNotMetException extends RuntimeException {
    public ConditionsNotMetException(String message) {
        super(message);
    }
}

class ParameterNotValidException extends RuntimeException {
    private final String parameter;
    private final String reason;

    public ParameterNotValidException(String parameter, String reason) {
        super("Invalid parameter: " + parameter);
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