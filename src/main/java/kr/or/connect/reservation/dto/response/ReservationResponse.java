package kr.or.connect.reservation.dto.response;

import java.util.List;

import kr.or.connect.reservation.dto.ReservationPrice;

public class ReservationResponse {

	private int reservationInfoId;
	private int displayInfoId;
	private int productId;
	private List<ReservationPrice> prices;
	private String reservationEmail;
	private String reservationName;
	private String reservationTel;
	private String reservationDate;
	private boolean cancelFlag;
	private String createDate;
	private String modifyDate;

	public ReservationResponse() {
		super();
	}

	public ReservationResponse(int reservationInfoId, int displayInfoId, int productId, List<ReservationPrice> prices,
			String reservationEmail, String reservationName, String reservationTel, String reservationDate,
			boolean cancelFlag, String createDate, String modifyDate) {
		super();
		this.reservationInfoId = reservationInfoId;
		this.displayInfoId = displayInfoId;
		this.productId = productId;
		this.prices = prices;
		this.reservationEmail = reservationEmail;
		this.reservationName = reservationName;
		this.reservationTel = reservationTel;
		this.reservationDate = reservationDate;
		this.cancelFlag = cancelFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public List<ReservationPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<ReservationPrice> prices) {
		this.prices = prices;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public String getReservationTel() {
		return reservationTel;
	}

	public void setReservationTel(String reservationTel) {
		this.reservationTel = reservationTel;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public boolean isCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(boolean cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "ReservationResponse [reservationInfoId=" + reservationInfoId + ", displayInfoId=" + displayInfoId
				+ ", productId=" + productId + ", prices=" + prices + ", reservationEmail=" + reservationEmail
				+ ", reservationName=" + reservationName + ", reservationTel=" + reservationTel + ", reservationDate="
				+ reservationDate + ", cancelFlag=" + cancelFlag + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + "]";
	}

}
