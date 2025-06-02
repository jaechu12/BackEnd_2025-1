package com.example.bcsd.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class globalExceptionHandler {

        @ExceptionHandler(EmptyResultDataAccessException.class)
        public ResponseEntity<String> handleEmptyResultDataAccessException(
                EmptyResultDataAccessException ex
        ) {
            String message = "존재하지 않는 게시물입니다.";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<String> handleDataIntegrityViolationException(
                DataIntegrityViolationException ex, HttpServletRequest request
        ) {
            String msg = ex.getMostSpecificCause().getMessage();
            String method = request.getMethod();

            if ("DELETE".equalsIgnoreCase(method) && msg.contains("foreign key constraint")) {
                return new ResponseEntity<>("관련된 값이 존재하므로 삭제할 수 없습니다.", HttpStatus.BAD_REQUEST);
            }

            if ("POST".equalsIgnoreCase(method) && msg.contains("board")) {
                return new ResponseEntity<>("존재하지 않는 게시물/게시판입니다.", HttpStatus.BAD_REQUEST);
            }

            if ("PUT".equalsIgnoreCase(method) && msg.contains("Duplicate entry")) {
                return new ResponseEntity<>("중복된 이메일이 존재합니다.", HttpStatus.CONFLICT);
            }


            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(
            NullPointerException ex
    ) {
        String message = "null이 존재합니다. 입력 데이터를 다시 확인해주세요.";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

}
