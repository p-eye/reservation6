package kr.or.connect.reservation.dto.error;

public class MatchException extends RuntimeException {
	public MatchException() {
		super();
	}

	public MatchException(String msg) {
		super(msg);
	}

}
