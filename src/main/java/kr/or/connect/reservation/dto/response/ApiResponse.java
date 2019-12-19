package kr.or.connect.reservation.dto.response;

public class ApiResponse {

	// HttpStatus
	private int errorCode;

	// Http Default Message
	private String message;

	public ApiResponse() {
	}

	public ApiResponse(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiResponse [errorCode=" + errorCode + ", message=" + message + "]";
	}

	
}
