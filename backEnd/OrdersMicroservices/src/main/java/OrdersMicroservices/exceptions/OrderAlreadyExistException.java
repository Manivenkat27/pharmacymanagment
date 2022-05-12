package OrdersMicroservices.exceptions;

public class OrderAlreadyExistException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OrderAlreadyExistException(String s) {
		super(s);
	}
	
	

}
