package kr.or.connect.reservation.dto;

public class Category {

	private int categoryId;
	private String categoryName;
	private int displayInfoCount;

	public Category() {
		super();
	}

	public Category(int categoryId, String categoryName, int displayInfoCount) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.displayInfoCount = displayInfoCount;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getDisplayInfoCount() {
		return displayInfoCount;
	}

	public void setDisplayInfoCount(int displayInfoCount) {
		this.displayInfoCount = displayInfoCount;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", displayInfoCount="
				+ displayInfoCount + "]";
	}

}
