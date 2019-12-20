package kr.or.connect.reservation.dto.param;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class CommentParam {

	private int productId;
	private int reservationInfoId;

	@Range(min = 1, max = 5,
			message = "별점을 확인해주세요")
	private int score;

	@NotEmpty
	@Size(min = 5, max = 400,
			message = "글자 수를 확인해주세요")
	private String comment;
	
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;

	public CommentParam() {
		createDate = LocalDateTime.now();
		modifyDate = LocalDateTime.now();
	}

	public CommentParam(int productId, int reservationInfoId, int score, String comment, LocalDateTime createDate,
			LocalDateTime modifyDate) {
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
