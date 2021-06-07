package Test1;

public class Car {
	private int id;
	private String name;
	private String brand;
	private int modelYear;
	private double price;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(int id, String name, String brand, int modelYear, double price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.modelYear = modelYear;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
