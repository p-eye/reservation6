package kr.or.connect.reservation.dto.response;

import java.util.List;

import kr.or.connect.reservation.dto.ReservationInfo;

public class ReservationInfoResponse {

	private List<ReservationInfo> reservations;
	private int size;

	public ReservationInfoResponse() {
		super();
	}

	public ReservationInfoResponse(List<ReservationInfo> reservations, int size) {
		super();
		this.reservations = reservations;
		this.size = size;
	}

	public List<ReservationInfo> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationInfo> reservations) {
		this.reservations = reservations;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ReservationInfoResponse [reservations=" + reservations + ", size=" + size + "]";
	}

}
