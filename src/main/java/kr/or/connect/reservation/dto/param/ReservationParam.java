package kr.or.connect.reservation.dto.param;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import kr.or.connect.reservation.dto.ReservationPrice;

public class ReservationParam {

	private int displayInfoId;

	@NotEmpty(message = "수량을 입력해주세요")
	private List<ReservationPrice> prices;

	private int productId;

	@Pattern(regexp = "^[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\\.[_0-9a-zA-Z-]+){1,2}$", 
			message = "이메일 형식을 확인해주세요")
	private String reservationEmail;

	@Pattern(regexp = "^[가-힣]{2,4}", 
			message = "이름 형식을 확인해주세요")
	private String reservationName;

	@Pattern(regexp = "^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$", 
			message = "연락처 형식을 확인해주세요")
	private String reservationTel;

	private String reservationDate;
	private boolean cancelFlag;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	
	public ReservationParam() {
		createDate = LocalDateTime.now();
		modifyDate = LocalDateTime.now();
	}

	public ReservationParam(int displayInfoId, List<ReservationPrice> prices, int productId, String reservationEmail,
			String reservationName, String reservationTel, String reservationDate, boolean cancelFlag,
			LocalDateTime createDate, LocalDateTime modifyDate) {
		this.displayInfoId = displayInfoId;
		this.prices = prices;
		this.productId = productId;
		this.reservationEmail = reservationEmail;
		this.reservationName = reservationName;
		this.reservationTel = reservationTel;
		this.reservationDate = reservationDate;
		this.cancelFlag = cancelFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public List<ReservationPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<ReservationPrice> prices) {
		this.prices = prices;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "ReservationParam [displayInfoId=" + displayInfoId + ", prices=" + prices + ", productId=" + productId
				+ ", reservationEmail=" + reservationEmail + ", reservationName=" + reservationName
				+ ", reservationTel=" + reservationTel + ", reservationDate=" + reservationDate + ", cancelFlag="
				+ cancelFlag + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}

}