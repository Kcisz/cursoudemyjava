package cursoudemyjava.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cursoudemyjava.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request)
	{
		
		StandartError error =  new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

}
