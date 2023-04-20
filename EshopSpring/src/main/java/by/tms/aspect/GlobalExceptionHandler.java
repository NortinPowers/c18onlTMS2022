package by.tms.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import static by.tms.utils.Constants.MappingPath.*;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ModelAndView handleDataAccessException(DataAccessException ex) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(ERROR_500);
        log.error("Unexpected exception", ex);
        mav.addObject("errorMessage", "Request execution error");
        return mav;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(HttpServletRequest request, Exception ex) {
        log.error("Page not found: " + request.getRequestURL(), ex);
        return new ModelAndView(ERROR_404);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest request, Exception ex) {
        log.error("Unexpected exception: " + request.getRequestURL(), ex);
        return new ModelAndView(SOME_ERROR);
    }
}