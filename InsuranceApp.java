package Day2;

import java.util.Scanner;

/*
 * Develop a program for an Insurance company
Create a Menu driven program which takes "N" number of Policy details
Policy class should have the following
• ld
• Number(policy no)
• Type(type is life ,motor,health,property etc.)
• Premium Fee
• Premium Mode [Quarterly, Halfyearly, yearly ]
1. Add Policy details to the system and display all Policy details present in system 
2. Display policies whose premium fee is less than or equal to given Amount for given Mode
Example: If input is given as 5000 and Mode as "Quarterly display policies whose Premium Fee is less than or
equal to 5000 with Mode as "Quarterly
3. Sort policy details by Number and display all Policy details present in system
4. Update Premium Fee details for given Policy Number
5. Exit*/
/*ask user id,number,type ,premium fee,premium mode add them to system
 * 	display all Policy details present
 * 
* */
public class InsuranceApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter no of policies:");
		int noOfPolicies = sc.nextInt();
		Insurance[] insuranceObj = new Insurance[noOfPolicies];
		// menu
		boolean flag = true;
		do {
			displaymenu();
			int choice = 0;
			System.out.println("enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				insuranceObj = addPolicy(noOfPolicies);
				displayPolicyDetails(insuranceObj);
				break;
			case 2:
				// ask premium and mode fee for user
				System.out.println("enter max premium fee and mode to display policy details");
				int newPFee = sc.nextInt();
				String newPMode = sc.next();
				Insurance[] searchedByPFeePMode = searchOnPFeePMode(insuranceObj, newPFee, newPMode);
				displayPolicyDetails(searchedByPFeePMode);
				break;
			case 3:
				// sort by number
				System.out.println("sorted based on policy number ");
				sortByNumber(insuranceObj);
				displayPolicyDetails(insuranceObj);
				break;
			case 4:
				// update price based on Insurance id
				System.out.println("enter policy number to update the premium fee");
				int newNumber = sc.nextInt();
				// search whether entered policy number is correct or not
				boolean found = searchForPolicyNumber(newNumber, insuranceObj);
				if (found) {
					System.out.println("id found");
					// ask for price
					System.out.println("enter the new price");
					int newPremiumFee = sc.nextInt();
					updatePremiumFee(newNumber, newPremiumFee, insuranceObj);
				} else {
					System.out.println("enter correct id");
				}
				displayPolicyDetails(insuranceObj);
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

	private static void updatePremiumFee(int newNumber, int newPremiumFee, Insurance[] insuranceObj) {
		// TODO Auto-generated method stub
		for (int i = 0; i < insuranceObj.length; i++) {
			if (newNumber == insuranceObj[i].getNumber()) {
				insuranceObj[i].setPremiumFee(newPremiumFee);
			}
		}
	}

	private static boolean searchForPolicyNumber(int newNumber, Insurance[] insuranceObj) {
		// TODO Auto-generated method stub
		for (int i = 0; i < insuranceObj.length; i++) {
			if (newNumber == insuranceObj[i].getNumber()) {
				return true;
			}
		}
		return false;
	}

	private static Insurance[] sortByNumber(Insurance[] insuranceObj) {
		// TODO Auto-generated method stub
		Insurance temp = new Insurance();
		for (int i = 0; i < insuranceObj.length - 1; i++) {
			for (int j = 0; j < insuranceObj.length - i - 1; j++) {
				if (insuranceObj[j].getNumber() > insuranceObj[j + 1].getNumber()) {
					temp = insuranceObj[j];
					insuranceObj[j] = insuranceObj[j + 1];
					insuranceObj[j + 1] = temp;
				}
			}
		}
		return insuranceObj;
	}

	private static Insurance[] searchOnPFeePMode(Insurance[] insuranceObj, int newPFee, String newPMode) {
		// TODO Auto-generated method stub
		int count = getCountOfPFeePMode(insuranceObj, newPFee, newPMode);
		Insurance[] result = new Insurance[count];
		int tempIndex = 0;
		for (int i = 0; i < insuranceObj.length; i++) {
			if (newPFee >= insuranceObj[i].getPremiumFee() && newPMode.equals(insuranceObj[i].getPremiumMode())) {
				result[tempIndex] = insuranceObj[i];
				tempIndex++;
			}
		}
		return result;
	}

	private static int getCountOfPFeePMode(Insurance[] insuranceObj, int newPFee, String newPMode) {
		// TODO Auto-generated method stub
		int index = 0;
		for (int i = 0; i < insuranceObj.length; i++) {
			if (newPFee >= insuranceObj[i].getPremiumFee() && newPMode.equals(insuranceObj[i].getPremiumMode())) {
				index++;
			}
		}
		return index;
	}

	private static void displayPolicyDetails(Insurance[] insuranceObj) {
		// TODO Auto-generated method stub
		for (int i = 0; i < insuranceObj.length; i++) {
			System.out.println("policy details: id" + insuranceObj[i].getId() + " Policy number:"
					+ insuranceObj[i].getNumber() + " Type:" + insuranceObj[i].getType() + " Premium Fee:"
					+ insuranceObj[i].getPremiumFee() + " Premium Mode:" + insuranceObj[i].getPremiumMode());
		}
	}

	private static Insurance[] addPolicy(int noOfPolicies) {
		// TODO Auto-generated method stub
		Insurance arr[] = new Insurance[noOfPolicies];
		// ask for policy details
		for (int i = 0; i < noOfPolicies; i++) {
			System.out.println("enter policy id");
			int id = sc.nextInt();
			System.out.println("enter policy number");
			int number = sc.nextInt();
			System.out.println("enter type of policy");
			String type = sc.next();
			System.out.println("enter premium fee");
			int premiumFee = sc.nextInt();
			String premiumMode;
			do {
				System.out.println("enter premium mode");
				premiumMode = sc.next();

			} while (!premiumMode.equals("quarterly") && !premiumMode.equals("halfyearly")
					&& !premiumMode.equals("yearly"));
			arr[i] = new Insurance(id, number, type, premiumFee, premiumMode);
		}
		return arr;
	}

	private static void displaymenu() {
		// TODO Auto-generated method stub
		System.out.println("1.Add policy details and display policy details");
		System.out.println("2.Display policies whose premium fee is less than or equal to given Amount for given Mode");
		System.out.println("3.Sort policy details by Number and display all Policy details");
		System.out.println("4.Update Premium Fee details for given Policy Number");
		System.out.println("5.Exit");
	}
}
