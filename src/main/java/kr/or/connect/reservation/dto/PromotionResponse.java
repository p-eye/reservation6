package kr.or.connect.reservation.dto;

import java.util.List;

public class PromotionResponse {

	private List<Promotion> items;

	public PromotionResponse() {
		super();
	}

	public PromotionResponse(List<Promotion> items) {
		super();
		this.items = items;
	}

	public List<Promotion> getItems() {
		return items;
	}

	public void setItems(List<Promotion> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "PromotionResponse [items=" + items + "]";
	}

}
