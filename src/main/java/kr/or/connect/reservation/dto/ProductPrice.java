package kr.or.connect.reservation.dto;

public class ProductPrice {

	private int productPriceId;
	private int productId;
	private String priceTypeName;
	private int price;
	private double discountRate;
	private String createDate;
	private String modifyDate;

	public ProductPrice() {
		super();
	}

	public ProductPrice(int productPriceId, int productId, String priceTypeName, int price, double discountRate,
			String createDate, String modifyDate) {
		super();
		this.productPriceId = productPriceId;
		this.productId = productId;
		this.priceTypeName = priceTypeName;
		this.price = price;
		this.discountRate = discountRate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(int productPriceId) {
		this.productPriceId = productPriceId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getPriceTypeName() {
		return priceTypeName;
	}

	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = priceTypeName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
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
		return "ProductPrice [productPriceId=" + productPriceId + ", productId=" + productId + ", priceTypeName="
				+ priceTypeName + ", price=" + price + ", discountRate=" + discountRate + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + "]";
	}

}
