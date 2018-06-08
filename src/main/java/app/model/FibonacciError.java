package app.model;

public class FibonacciError {
	String input;
	String errorMessage;

	public FibonacciError(String input, String errorMessage) {
		this.input = input;
		this.errorMessage = errorMessage;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
