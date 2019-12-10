package kr.or.connect.reservation.dto;

public class ProductTable {

	private int id;
	private int category_id;
	private String description;
	private String content;
	private String event;
	private String create_date;
	private String modify_date;

	public ProductTable() {
		super();
	}

	public ProductTable(int id, int category_id, String description, String content, String event, String create_date,
			String modify_date) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.description = description;
		this.content = content;
		this.event = event;
		this.create_date = create_date;
		this.modify_date = modify_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getModify_date() {
		return modify_date;
	}

	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}

	@Override
	public String toString() {
		return "ProductTable [id=" + id + ", category_id=" + category_id + ", description=" + description + ", content="
				+ content + ", event=" + event + ", create_date=" + create_date + ", modify_date=" + modify_date + "]";
	}

}
