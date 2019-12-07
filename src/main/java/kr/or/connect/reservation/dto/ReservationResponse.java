package kr.or.connect.reservation.dto;

import java.util.List;

public class ReservationResponse {

	private List<ReservationInfo> reservations;
	private int size;

	public ReservationResponse() {
		super();
	}

	public ReservationResponse(List<ReservationInfo> reservations, int size) {
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
		return "ReservationResponse [reservations=" + reservations + ", size=" + size + "]";
	}

}
