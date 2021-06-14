package Day1;

public class Mobile {
	private int id;
	private String model;
	private int price;
	private String date;

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mobile(int id, String model, int price, String date) {
		super();
		this.id = id;
		this.model = model;
		this.price = price;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
