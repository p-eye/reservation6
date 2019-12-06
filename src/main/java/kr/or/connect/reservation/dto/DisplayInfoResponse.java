package kr.or.connect.reservation.dto;

import java.util.List;

public class DisplayInfoResponse {

	private DisplayInfo displayInfo;
	private List<ProductImage> productImages;
	private DisplayInfoImage displayInfoImage;
	private List<Comment> comments;
	private double averageScore;
	private List<ProductPrice> productPrices;

	public DisplayInfoResponse() {
		super();
	}

	public DisplayInfoResponse(DisplayInfo displayInfo, List<ProductImage> productImages,
			DisplayInfoImage displayInfoImage, List<Comment> comments, double averageScore,
			List<ProductPrice> productPrices) {
		super();
		this.displayInfo = displayInfo;
		this.productImages = productImages;
		this.displayInfoImage = displayInfoImage;
		this.comments = comments;
		this.averageScore = averageScore;
		this.productPrices = productPrices;
	}

	public DisplayInfo getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(DisplayInfo displayInfo) {
		this.displayInfo = displayInfo;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public DisplayInfoImage getDisplayInfoImage() {
		return displayInfoImage;
	}

	public void setDisplayInfoImage(DisplayInfoImage displayInfoImage) {
		this.displayInfoImage = displayInfoImage;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public List<ProductPrice> getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(List<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}

	@Override
	public String toString() {
		return "DisplayInfoResponse [displayInfo=" + displayInfo + ", productImages=" + productImages
				+ ", displayInfoImage=" + displayInfoImage + ", comments=" + comments + ", averageScore=" + averageScore
				+ ", productPrices=" + productPrices + "]";
	}

}
