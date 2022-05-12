package OrdersMicroservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;





@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(OrderAlreadyExistException.class)
	public ResponseEntity<String> orderAlreadyExist(OrderAlreadyExistException e){
		return new ResponseEntity<String>("Order Already exist",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> orderNotFound(OrderNotFoundException e){
		return new ResponseEntity<String>("Order Doesnot exist",HttpStatus.BAD_REQUEST);
	}


}
