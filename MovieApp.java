package Day1;

/*Implement a Menu driven program to store Movie details.
Movie class should have the following
1. Id
2. Name
3. Casting - String[]
4. Year of Release
5. Rating - Should be from 1 to 5
1. Add Movie details to the system and display all Movie details present in system
2. Sort Movie details by Year of Release and if the year is same sort by its Name
3. Display all the movie details whose Rating is greater than or equal to given value
a. Example : If the input for Rating is provided as “3”, Display all movies whose rating is greater 
than or equal to 3
4. Display all movie details for the given Casting ( it should match the input in array of String )
a. Example : If the input is provided as ‘Charlie’ , Search for all movies where Charlie was part of 
Casting and Display all the movie details
5. Update Rating details for given Movie Id
 Step 1: Get the Movie Id and Rating to be updated as an user input
 Step 2: Fetch the movie details for given id and if present, update the Rating details with new value
 Step 3: Display the details
6. Delete movie details for given Movie Id
7. Exit
*/
/*
 *  Add Movie details to the system and display all Movie details present in system
 *  	//ask id name casting releaseyear rating
 *  	//display
 *  Sort Movie details by Year of Release and if the year is same sort by its Name
 *  	//sort movie details by year
 *  		//if same releasedyear sort by name
 *  	//display sorted details
 *  Display all the movie details whose Rating is greater than or equal to given value
 *  	//take input rating from 1 to 5
 *  	//display details equal above the input
 *   Display all movie details for the given Casting 
 *   	//it should match the input in array of String 
 *   	//display the movie details of that input
 *  Update Rating details for given Movie Id 
 *  Delete movie details for given Movie Id
 *  exit
 * */
import java.util.Scanner;

public class MovieApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int noOfMovies = 0;
		System.out.println("enter no of movies:");
		noOfMovies = sc.nextInt();
		Movie[] movieObj = new Movie[noOfMovies];
		// menu
		boolean flag = true;
		do {
			displaymenu();
			int choice = 0;
			System.out.println("enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				movieObj = addMovieDetails(noOfMovies);
				displayMovieDetails(movieObj);
				break;
			case 2:
				// System.out.println("sort by year");
				System.out.println("sort by name");
				sortByMName(movieObj);
				displayMovieDetails(movieObj);
			}
		} while (flag);

	}

	private static Movie[] sortByMName(Movie[] movieObj) {
		// TODO Auto-generated method stub

		// bubble sort
		Movie temp = new Movie();
		for (int i = 0; i < movieObj.length - 1; i++) {
			for (int j = 0; j < movieObj.length - i - 1; j++) {
				if (movieObj[j].getName().compareTo(movieObj[j + 1].getName()) > 0) {
					temp = movieObj[j];
					movieObj[j] = movieObj[j + 1];
					movieObj[j + 1] = temp;
				}

			}
		}
		return movieObj;
	}

	private static void displayMovieDetails(Movie[] movieObj) {
		// TODO Auto-generated method stub
		for (int i = 0; i < movieObj.length; i++) {

			System.out.println("movie details: id" + movieObj[i].getId() + " name:" + movieObj[i].getName()
					+ " casting:" + movieObj[i].getCasting() + " year of release:" + movieObj[i].getReleaseyear()
					+ " rating:" + movieObj[i].getRating());

		}
	}

	// add movie details
	private static Movie[] addMovieDetails(int noOfMovies) {
		// TODO Auto-generated method stub
		Movie arr[] = new Movie[noOfMovies];
		for (int i = 0; i < noOfMovies; i++) {
			System.out.println("enter Id");
			int id = sc.nextInt();
			System.out.println("enter Name");
			String name = sc.next();
			String casting[] = new String[1];
			System.out.println("Casting");
			System.out.print("Hero:");
			casting[0] = sc.next();
			/*
			 * System.out.print("Herione:"); casting[1] = sc.next();
			 */
			System.out.println("Year of Release");
			int releaseyear = sc.nextInt();
			// System.out.println("Rating - Should be from 1 to 5");
			int rating;
			do {
				System.out.print("enter movie rating for 5: ");
				rating = sc.nextInt();
			} while (rating != 1 && rating != 2 && rating != 3 && rating != 4 && rating != 5);
			arr[i] = new Movie(id, name, casting, releaseyear, rating);

		}
		return arr;
	}

	// display menu
	private static void displaymenu() {
		// TODO Auto-generated method stub
		System.out.println("1.add movie details and display movie details");
		System.out.println("2.sort movie details by Year of Release and if the year is same sort by its Name");
		System.out.println("3.Display all the movie details whose Rating is greater than or equal to given value");
		System.out.println("4.Display all movie details for the given Casting ");
		System.out.println("5.Update Rating details for given Movie Id ");
		System.out.println("6.Delete movie details for given Movie Id ");
		System.out.println("7.Exit");

	}
}