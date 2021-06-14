package Day1;

/*Write a program to implement menu driven program for mobile store with the following attributes:
Id, Model, Price, DateOfManufacture
1. Add Mobile details to the system and display all Mobile details present in system
2. Sort all the mobiles based on Model and display the details
3. Update Price for given mobile id and display the details
4. Delete mobile details for given mobile id
5. Exit
Note : Model will be unique
*/
/*
 * ask mobile id ,model ,price,date of manufacture and store them into system
 * display all mobile details
 *sort all moblie details based on model
 *	//display them
 *update price for given mobile id
 * //display them 
 *ask user mobile id and delete mobile details
 *
 */
import java.util.Scanner;

public class MobileApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Mobile[] mobileObj = new Mobile[10];
		// menu
		boolean flag = true;
		do {
			displaymenu();
			int choice = 0;
			System.out.println("enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				int noOfMobiles = 0;
				System.out.println("enter number of mobiles you want to add");
				noOfMobiles = sc.nextInt();
				// ask user id,model,price,date of manufracture
				mobileObj = addMobiles(noOfMobiles);
				displayMobileDetails(mobileObj);
				break;
			case 2:
				// sort and display
				System.out.println("sorted based on mobile model ");
				sortOnModel(mobileObj);
				displayMobileDetails(mobileObj);
				break;
			case 3:
				// update price based on mobile id
				System.out.println("enter mobile id to update the price");
				int newId = sc.nextInt();
				// search whether entered mobileId is correct or not
				boolean found = searchForMobileId(newId, mobileObj);
				if (found) {
					System.out.println("id found");
					// ask for price
					System.out.println("enter the new price");
					int newPrice = sc.nextInt();
					updatePrice(newId, newPrice, mobileObj);
				} else {
					System.out.println("enter correct id");
				}
				displayMobileDetails(mobileObj);
				break;
			case 4:
				// delete mobile details
				// ask user mobile id which you want to delete
				System.out.println("enter mobile id to delete the details of mobile");
				int newDeleteId = sc.nextInt();
				deleteMobileDetails(newDeleteId, mobileObj);
				// after deleting display
				displayMDetailsAfterDelete(mobileObj);
				break;
			case 5:
				System.out.println("Thank you");
				flag = false;
				break;
			default:
				System.out.println("enter valid choice");
				break;
			}
		} while (flag);
	}
	private static void displayMDetailsAfterDelete(Mobile[] mobileObj) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mobileObj.length - 1; i++) {
			if (mobileObj[i] != null) {
				System.out.println("mobile details: id" + mobileObj[i].getId() + " model:" + mobileObj[i].getModel()
						+ " price:" + mobileObj[i].getPrice() + " date of manufracture:" + mobileObj[i].getDate());
			}
		}
	}

	private static void deleteMobileDetails(int newDeleteId, Mobile[] mobileObj) {
		// TODO Auto-generated method stub
				for (int i = 0; i < mobileObj.length; i++) {
			if (mobileObj[i] != null && mobileObj[i].getId() == newDeleteId) {
				mobileObj[i] = null;
			}
		}
		
		System.out.println("successfully deteleted");
	}

	private static void updatePrice(int newId, int newPrice, Mobile[] mobileObj) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mobileObj.length; i++) {
			if (newId == mobileObj[i].getId()) {
				mobileObj[i].setPrice(newPrice);

			}
		}
	}

	private static boolean searchForMobileId(int newId, Mobile[] mobileObj) {
		// TODO Auto-generated method stub

		for (int i = 0; i < mobileObj.length; i++) {
			if (newId == mobileObj[i].getId()) {
				return true;
			}
		}
		return false;
	}

	private static Mobile[] sortOnModel(Mobile[] mobileObj) {
		// TODO Auto-generated method stub
		// bubble sort
		Mobile temp = new Mobile();
		for (int i = 0; i < mobileObj.length - 1; i++) {
			for (int j = 0; j < mobileObj.length - i - 1; j++) {
				if (mobileObj[j].getModel().compareTo(mobileObj[j + 1].getModel()) > 0) {
					temp = mobileObj[j];
					mobileObj[j] = mobileObj[j + 1];
					mobileObj[j + 1] = temp;
				}

			}
		}
		return mobileObj;
	}

	private static void displayMobileDetails(Mobile[] mobileObj) {

		// TODO Auto-generated method stub
		for (int i = 0; i < mobileObj.length; i++) {

			System.out.println("mobile details: id" + mobileObj[i].getId() + " model:" + mobileObj[i].getModel()
					+ " price:" + mobileObj[i].getPrice() + " date of manufracture:" + mobileObj[i].getDate());

		}
	}

	private static Mobile[] addMobiles(int noOfMobiles) {
		// TODO Auto-generated method stub
		// create mobiles array
		Mobile arr[] = new Mobile[noOfMobiles];
		// ask for mobile details
		for (int i = 0; i < noOfMobiles; i++) {
			System.out.println("enter mobile id");
			int id = sc.nextInt();
			System.out.println("enter model");
			String model = sc.next();
			System.out.println("enter price");
			int price = sc.nextInt();
			System.out.println("enter date of manufracture");
			String date = sc.next();
			arr[i] = new Mobile(id, model, price, date);
		}
		return arr;
	}

	private static void displaymenu() {
		// TODO Auto-generated method stub
		System.out.println("1.add mobile details and display mobile details");
		System.out.println("2.sort all mobiles based on model");
		System.out.println("3.update price for a mobile");
		System.out.println("4.delete mobile details");
		System.out.println("5.Exit");
	}

}
