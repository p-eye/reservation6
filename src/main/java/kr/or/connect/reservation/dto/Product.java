package kr.or.connect.reservation.dto;

public class Product {

	private int displayInfoId;
	private int productId;
	private String proudctDescription;
	private String placeName;
	private String productContent;
	private String productImageUrl;

	public Product() {
		super();
	}

	public Product(int displayInfoId, int productId, String proudctDescription, String placeName, String productContent,
			String productImageUrl) {
		super();
		this.displayInfoId = displayInfoId;
		this.productId = productId;
		this.proudctDescription = proudctDescription;
		this.placeName = placeName;
		this.productContent = productContent;
		this.productImageUrl = productImageUrl;
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

	public String getProudctDescription() {
		return proudctDescription;
	}

	public void setProudctDescription(String proudctDescription) {
		this.proudctDescription = proudctDescription;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	@Override
	public String toString() {
		return "Product [displayInfoId=" + displayInfoId + ", productId=" + productId + ", proudctDescription="
				+ proudctDescription + ", placeName=" + placeName + ", productContent=" + productContent
				+ ", productImageUrl=" + productImageUrl + "]";
	}

}
