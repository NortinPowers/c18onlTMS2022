package by.tms.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.utils.Constants.MappingPath.ERROR_500;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ModelAndView handleDataAccessException(DataAccessException ex) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(ERROR_500);
        log.error("Unexpected exception", ex);
//        log.error(ex.getMessage());
        mav.addObject("errorMessage", "Request execution error");
        return mav;
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ModelAndView handleNullPointerException(NullPointerException ex) {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName(ERROR_500);
//        log.error(ex.getMessage());
//        mav.addObject("errorMessage", "An error has occurred in the application");
//        return mav;
//    }
}