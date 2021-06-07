package Test1;

import java.util.Scanner;

public class CarApp {
	static Scanner sc = new Scanner(System.in);
	static byte size;

	public static void main(String[] args) {

		Car car[] = null;
		boolean flag = true;
		do {
			displayMenu();
			int choice = 0;
			System.out.println("enter your choice.");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter the number of cars.");
				size = sc.nextByte();
				car = createcar(size);

				displayDetails(car);
				break;
			case 2:
				System.out.println("please enter the id to search");
				int newId = sc.nextInt();
				car = sortCar(car);
				boolean found = searchCar(newId, car);
				if (found)
					System.out.println("id found");
				else
					System.out.println("id not found");

				break;
			case 3:
				System.out.println("sorting using insertion based on model year");
				car = sortingCars(car);
				displayDetails(car);
				break;
			case 4:
				System.out.println("enter the id to update the price");
				int newID = sc.nextInt();
				System.out.println("enter the new price to be updated");
				double newPrice = sc.nextDouble();
				updateThePrice(newID, car, newPrice);
				displayDetails(car);
				break;
			case 5:
				System.out.println("exit");
				flag = false;
				break;

			}
		} while (flag);

	}

	private static void displayMenu() {

		System.out.println("========================================================");
		System.out.println("press 1 To Add details of a car.");
		System.out.println("press 2 search the car for particular id using binary search.");
		System.out.println("press 3 sort the car on base of model year with insertion sort.");
		System.out.println("press 4 update the price of the car.");
		System.out.println("press 5 Exit.");
		System.out.println("========================================================");

	}

	private static boolean updateThePrice(int newID, Car[] car, double newPrice) {
		for (int i = 0; i < car.length; i++) {
			if (newID == car[i].getId()) {
				car[i].setPrice(newPrice);
				return true;
			}
		}
		return false;
	}

	private static Car[] sortingCars(Car[] car) {
		// insertion sort
		int modelYear = 0, j = 0;
		Car c;
		for (int i = 0; i < car.length; i++) {
			modelYear = car[i].getModelYear();
			j = i - 1;
			c = car[i];
			while (j >= 0 && car[j].getModelYear() > modelYear) {
				car[j + 1] = car[j];
				j = j - 1;
			}
			car[j + 1] = c;
		}
		return car;
	}

	private static Car[] sortCar(Car[] car) {
		int id, i, j;
		Car c;
		// insertion sort
		for (i = 1; i < car.length; i++) {
			id = car[i].getId();
			c = car[i];
			j = i - 1;
			while (j >= 0 && car[j].getId() > id) {
				car[j + 1] = car[j];
				j = j - 1;
			}
			car[j + 1] = c;
		}
		return car;
	}

	private static boolean searchCar(int newId, Car[] car) {
		// binary search
		int middle = 0, first = 0, last = car.length - 1;
		middle = (first + last) / 2;
		// double price=0;
		while (first <= last) {
			if (car[middle].getId() == newId) {
				System.out.println("car details: id" + car[middle].getId() + " " + "car name:" + car[middle].getName()
						+ " " + "model:" + car[middle].getModelYear() + "  " + "price:" + car[middle].getPrice() + "  "
						+ "brand:" + car[middle].getBrand());
				return true;
			} else if (car[middle].getId() < newId) {
				first = middle + 1;
			} else {
				last = middle - 1;
			}
			middle = (first + last) / 2;
		}

		return false;
	}

	private static void displayDetails(Car[] car) {
		for (int i = 0; i < car.length; i++) {
			System.out.println("car details: id" + car[i].getId() + " " + "car name:" + car[i].getName() + " "
					+ "model:" + car[i].getModelYear() + "  " + "price:" + car[i].getPrice() + "  " + "brand:"
					+ car[i].getBrand());

		}
	}

	private static Car[] createcar(byte size) {
		Car carArray[] = new Car[size];
		int[] dupid = new int[size];
		int index = 0;
		for (int i = 0; i < carArray.length; i++) {
			System.out.println("enter the " + (i + 1) + "car details");
			System.out.println("enter the car id");
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
			System.out.println("enter the car name");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("enter the car brand");
			String brand = sc.nextLine();
			while (true) {
				if (brand.equals("hyundai") == false && brand.equals("maruti") == false) {
					System.out.println("please enter either hyundai or maruti brands");
					brand = sc.nextLine();
				} else {
					break;
				}
			}
			System.out.println("enter the modelYear");
			int modelYear = sc.nextInt();

			System.out.println("enter the car price");
			double price = sc.nextDouble();

			carArray[i] = new Car(id, name, brand, modelYear, price);
		}
		return carArray;

	}
}
