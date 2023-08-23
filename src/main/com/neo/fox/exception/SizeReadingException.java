package main.com.neo.fox.exception;

public class SizeReadingException extends SizeException {

	public SizeReadingException() {
		
	}

	public SizeReadingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SizeReadingException(String message, Throwable cause) {
		super(message, cause);
	}

	public SizeReadingException(String message) {
		super(message);
	}

	public SizeReadingException(Throwable cause) {
		super(cause);
	}
	
	

}
