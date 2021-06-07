package test12;

public class Mobile {

	public Mobile(long id, String model, float price, byte noOfSims, String hasCamera) {
		super();
		this.id = id;
		this.model = model;
		this.price = price;
		this.noOfSims = noOfSims;
		this.hasCamera = hasCamera;
	}

	private long id;
	private String model;
	private float price;
	private byte noOfSims;
	private String hasCamera;

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public byte getNoOfSims() {
		return noOfSims;
	}

	public void setNoOfSims(byte noOfSims) {
		this.noOfSims = noOfSims;
	}

	public String getHasCamera() {
		return hasCamera;
	}

	public void setHasCamera(String hasCamera) {
		this.hasCamera = hasCamera;
	}
}
