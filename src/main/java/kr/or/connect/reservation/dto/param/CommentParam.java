package kr.or.connect.reservation.dto.param;

import java.time.LocalDateTime;

public class CommentParam {

	private int productId;
	private int reservationInfoId;
	private int score;
	private String comment;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;

	public CommentParam() {
		createDate = LocalDateTime.now();
		modifyDate = LocalDateTime.now();
	}

	public CommentParam(int productId, int reservationInfoId, int score, String comment, LocalDateTime createDate,
			LocalDateTime modifyDate) {
		super();
		this.productId = productId;
		this.reservationInfoId = reservationInfoId;
		this.score = score;
		this.comment = comment;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		return "CommentParam [productId=" + productId + ", reservationInfoId=" + reservationInfoId + ", score=" + score
				+ ", comment=" + comment + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}

}
