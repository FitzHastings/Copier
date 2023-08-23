package main.com.neo.fox.exception;

public class SizeException extends RuntimeException {

	public SizeException() {
		
	}

	public SizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SizeException(String message, Throwable cause) {
		super(message, cause);
	}

	public SizeException(String message) {
		super(message);
	}

	public SizeException(Throwable cause) {
		super(cause);
	}
	
	

}
