package bueno.ezandro.todo.exception;

public class TodoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TodoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TodoNotFoundException(String message) {
		super(message);
	}

}
