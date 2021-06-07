package Day2;

public class Insurance {
	private int id;
	private int number;
	private String type;
	private int premiumFee;
	private String PremiumMode;
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insurance(int id, int number, String type, int premiumFee, String premiumMode) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.premiumFee = premiumFee;
		PremiumMode = premiumMode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPremiumFee() {
		return premiumFee;
	}
	public void setPremiumFee(int premiumFee) {
		this.premiumFee = premiumFee;
	}
	public String getPremiumMode() {
		return PremiumMode;
	}
	public void setPremiumMode(String premiumMode) {
		PremiumMode = premiumMode;
	}
	

}
