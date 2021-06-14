package Day1;
/*Id
2. Name
3. Casting - String[]
4. Year of Release
5. Rating - Should be from 1 to 5
*/

public class Movie {
	private int id;
	private String name;
	private String casting[];
	private int releaseyear;
	private int rating;
	public Movie(int id, String name, String[] casting, int releaseyear, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.casting = casting;
		this.releaseyear = releaseyear;
		this.rating = rating;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
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
	public String[] getCasting() {
		return casting;
	}
	public void setCasting(String[] casting) {
		this.casting = casting;
	}
	public int getReleaseyear() {
		return releaseyear;
	}
	public void setReleaseyear(int releaseyear) {
		this.releaseyear = releaseyear;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
