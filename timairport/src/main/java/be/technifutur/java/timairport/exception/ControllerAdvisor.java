package be.technifutur.java.timairport.exception;


import be.technifutur.java.timairport.model.dto.exceptionDTO.NoPlaneAvailableErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(NoPlaneAvailableException.class)
    public ResponseEntity<NoPlaneAvailableErrorDTO> handleNoPlaneAvailable(
            NoPlaneAvailableException e, HttpServletRequest request
    ){
        NoPlaneAvailableErrorDTO errorDTO = NoPlaneAvailableErrorDTO.builder()
                .status(HttpStatus.NOT_ACCEPTABLE.value())
                .message(e.getMessage())
                .method(request.getMethod())
                .path(request.getRequestURL().toString())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorDTO);
    }

}
