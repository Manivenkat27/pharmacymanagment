package SupplierMicroservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(SupplierAlreadyExistException.class)
	public ResponseEntity<String> supplierAlreadyExist(SupplierAlreadyExistException e){
		return new ResponseEntity<String>("Supplier Already exist",HttpStatus.BAD_REQUEST);}
	
	@ExceptionHandler(SupplierNotFoundException.class)
		public ResponseEntity<String> supplierNotFound(SupplierNotFoundException e){
			return new ResponseEntity<String>("Supplier Doesnot exist",HttpStatus.BAD_REQUEST);
		}

}
	
