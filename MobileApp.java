package test12;

import java.util.Scanner;

public class MobileApp {
	static Scanner sc = new Scanner(System.in);
	static byte size;

	public static void main(String[] args) {
		Mobile mobile[] = null;
		boolean flag = true;
		do {
			displayMenu();
			int choice = 0;
			System.out.println("enter choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter no of mobiles");
				size = sc.nextByte();
				mobile = createMobile(size);
				displayMobile(mobile);
				break;
			case 2:
				System.out.println("sort by model");
				sortByModel(mobile);
				displayMobile(mobile);
				break;
			case 3:
				System.out.println("");
				System.out.println("please enter the price to search");
				float newPrice = sc.nextFloat();
				mobile = sortMobile(mobile);
				boolean found = searchMobile(newPrice, mobile);
				if (found)
					System.out.println("price found");
				else
					System.out.println("price not found");

				break;
			case 4:
				System.out.println("enter the id to update the price");
				int newID = sc.nextInt();
				System.out.println("enter the new price to be updated");
				float newPrice1 = sc.nextFloat();
				updateThePrice(newID, mobile, newPrice1);
				displayMobile(mobile);
				break;
			case 5:
				System.out.println("exit");
				flag = false;
				break;


			}
		} while (flag);
	}

	private static boolean searchMobile(float newPrice, Mobile[] mobile) {
		// TODO Auto-generated method stub
		// binary search
		int middle = 0, first = 0, last = mobile.length - 1;
		middle = (first + last) / 2;
		
		while (first <= last) {
			if (mobile[middle].getPrice() <= newPrice ){
				System.out.println("mobile details: id" + mobile[middle].getId() + " " + "no of sims:"
						+ mobile[middle].getNoOfSims() + " " + "model:" + mobile[middle].getModel() + "  " + "price:"
						+ mobile[middle].getPrice() + "  " + "has cam:" + mobile[middle].getHasCamera());
				return true;
			} else if (mobile[middle].getPrice() < newPrice) {
				first = middle + 1;
			} else {
				last = middle - 1;
			}
			middle = (first + last) / 2;
		}

		return false;
	}

	private static Mobile[] sortMobile(Mobile[] mobile) {
		// TODO Auto-generated method stub
		int i, j;
		float price;
		Mobile c;
		// insertion sort
		for (i = 1; i < mobile.length; i++) {
			price = mobile[i].getPrice();
			c = mobile[i];
			j = i - 1;
			while (j >= 0 && mobile[j].getId() > price) {
				mobile[j + 1] = mobile[j];
				j = j - 1;
			}
			mobile[j + 1] = c;
		}
		return mobile;
	}

	private static boolean updateThePrice(int newID, Mobile[] mobile, float newPrice) {
		for (int i = 0; i < mobile.length; i++) {
			if (newID == mobile[i].getId()) {
				mobile[i].setPrice(newPrice);
				return true;
			}
		}
		return false;
		// TODO Auto-generated method stub

	}

	private static Mobile[] sortByModel(Mobile[] mobile) {
		// bubble sort
		Mobile temp = new Mobile();
		for (int i = 0; i < mobile.length - 1; i++) {
			for (int j = 0; j < mobile.length - i - 1; j++) {
				if (mobile[j].getModel().compareTo(mobile[j + 1].getModel()) > 0) {
					temp = mobile[j];
					mobile[j] = mobile[j + 1];
					mobile[j + 1] = temp;
				}

			}
		}
		return mobile;
		// TODO Auto-generated method stub

	}

	private static void displayMobile(Mobile[] mobile) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mobile.length; i++) {
			System.out.println("mobile details: id:" + mobile[i].getId() + " " + "mobile model:" + mobile[i].getModel()
					+ " " + "price:" + mobile[i].getPrice() + " " + "no of sims:" + mobile[i].getNoOfSims() + " "
					+ "has camera:" + mobile[i].getHasCamera());

		}
	}

	private static Mobile[] createMobile(byte size) {
		Mobile mobileArray[] = new Mobile[size];
		int[] dupid = new int[size];
		int index = 0;
		for (int i = 0; i < mobileArray.length; i++) {
			System.out.println("enter the " + (i + 1) + "mobile details");
			System.out.println("enter the mobile id");
			int id = sc.nextInt();
			dupid[index] = id;
			for (int j = 0; j < index; j++) {
				if (id == dupid[j]) {
					System.out.println("enter unique id");
					id = sc.nextInt();
					j = -1;
				}
			}
			index++;
			System.out.println("enter the mobile model");
			sc.nextLine();
			String model = sc.nextLine();
			System.out.println("enter the mobile price");
			float price = sc.nextFloat();
			System.out.println("enter no of sims");
			byte noOfSims = sc.nextByte();
			sc.nextLine();
			System.out.println("has camera yes or no");
			String hasCamera = sc.nextLine();

			mobileArray[i] = new Mobile(id, model, price, noOfSims, hasCamera);
		}
		return mobileArray;

	}
	// TODO Auto-generated method stub

	private static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("========================================================");
		System.out.println("press 1 To Add details of a mobile.");
		System.out.println("press 2 sort the mobile on base of model ");
		System.out.println(
				"press 3 display mobile details whose price is less than  or equal to given price with camera");
		System.out.println("press 4 update the price of the mobile using mobile id.");
		System.out.println("press 5 Exit.");
		System.out.println("========================================================");

	}

}
