package kr.or.connect.reservation.dto;

public class CommentResponse {

	private int commentId;
	private int productId;
	private int reservationInfoId;
	private int score;
	private String comment;
	private String createDate;
	private String modyfiDate;
	private CommentImage commentImage;

	public CommentResponse() {
		super();
	}

	public CommentResponse(int commentId, int productId, int reservationInfoId, int score, String comment,
			String createDate, String modyfiDate, CommentImage commentImage) {
		super();
		this.commentId = commentId;
		this.productId = productId;
		this.reservationInfoId = reservationInfoId;
		this.score = score;
		this.comment = comment;
		this.createDate = createDate;
		this.modyfiDate = modyfiDate;
		this.commentImage = commentImage;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModyfiDate() {
		return modyfiDate;
	}

	public void setModyfiDate(String modyfiDate) {
		this.modyfiDate = modyfiDate;
	}

	public CommentImage getCommentImage() {
		return commentImage;
	}

	public void setCommentImage(CommentImage commentImage) {
		this.commentImage = commentImage;
	}

	@Override
	public String toString() {
		return "CommentResponse [commentId=" + commentId + ", productId=" + productId + ", reservationInfoId="
				+ reservationInfoId + ", score=" + score + ", comment=" + comment + ", createDate=" + createDate
				+ ", modyfiDate=" + modyfiDate + ", commentImage=" + commentImage + "]";
	}

}
