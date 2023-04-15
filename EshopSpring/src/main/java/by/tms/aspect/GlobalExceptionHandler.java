package by.tms.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
//    @ExceptionHandler(DataAccessException.class)
//    public ResponseEntity<String> handleDataAccessException(DataAccessException ex) {
//        System.out.println("data error");
//        return new ResponseEntity<>("Request execution error", HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(DataAccessException.class)
    public ModelAndView handleDataAccessException(DataAccessException ex) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/error/500");
        log.error(ex.getMessage());
        mav.addObject("errorMessage", "Request execution error");
        return mav;
    }

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView handleNullPointerException(NullPointerException ex) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/error/500");
        log.error(ex.getMessage());
        mav.addObject("errorMessage", "An error has occurred in the application");
        return mav;
    }
}
