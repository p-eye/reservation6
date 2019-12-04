package kr.or.connect.reservation.dto;

import java.util.List;

public class ProductResponse {

	private int totalCount;
	private List<Product> items;

	public ProductResponse() {
		super();
	}

	public ProductResponse(int totalCount, List<Product> items) {
		super();
		this.totalCount = totalCount;
		this.items = items;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ProductResponse [totalCount=" + totalCount + ", items=" + items + "]";
	}

}
