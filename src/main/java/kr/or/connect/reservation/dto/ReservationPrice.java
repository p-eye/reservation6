package kr.or.connect.reservation.dto;

public class ReservationPrice {

	private int reservationInfoPriceId;
	private int reservationInfoId;
	private int productPriceId;
	private int count;

	public ReservationPrice() {
		super();
	}

	public ReservationPrice(int reservationInfoPriceId, int reservationInfoId, int productPriceId, int count) {
		super();
		this.reservationInfoPriceId = reservationInfoPriceId;
		this.reservationInfoId = reservationInfoId;
		this.productPriceId = productPriceId;
		this.count = count;
	}

	public int getReservationInfoPriceId() {
		return reservationInfoPriceId;
	}

	public void setReservationInfoPriceId(int reservationInfoPriceId) {
		this.reservationInfoPriceId = reservationInfoPriceId;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public int getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(int productPriceId) {
		this.productPriceId = productPriceId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ReservationPrice [reservationInfoPriceId=" + reservationInfoPriceId + ", reservationInfoId="
				+ reservationInfoId + ", productPriceId=" + productPriceId + ", count=" + count + "]";
	}

}
