package kr.or.connect.reservation.dto.response;

public class MsgResponse {

	String msg;

	public MsgResponse() {
	}

	public MsgResponse(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MsgResponse [msg=" + msg + "]";
	}

}
