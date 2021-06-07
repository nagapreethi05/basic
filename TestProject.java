package Test1;

import java.util.Scanner;


public class TestProject {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
        int size = 0;
        Test emp[] = null;
        boolean flag=true;
		do
		{
			displaymenu();
			
			int x = sc.nextInt();
			switch(x)
			{
			case 1: 
				System.out.println("enter the number of employees");
	    	    size = sc.nextInt();   
	    	    emp = createEmp(size);
	    	    displayDetails(emp,size);
	    	    break;
			case 2:
				System.out.println("enter the experience range");
				int r = sc.nextInt();
				int r1 = sc.nextInt();
				display(r,r1,emp,size);
				break;
			case 3:
				sc.nextLine();
				String d = sc.nextLine();
				search(emp,d,size);
				break;
			case 4:
				emp = sort(emp,size);
				displayDetails(emp,size);
				break;
			case 5:
				System.out.println("enter the name to update the designation");
				String desig = new String();
				sc.nextLine();
				desig = sc.nextLine();
				desig(emp,desig,size);
				break;
			case 6:
				flag = false;
			    System.out.println("exited");
			}
	}while(flag);
}

	

	private static void displaymenu() {
		
		System.out.println("enter the choice");
		System.out.println("========================================================");
		System.out.println("press 1.To Add details of a employee");
		System.out.println("press 2.display employee details for given range");
		System.out.println("press 3.binary search for designation");
		System.out.println("press 4.sort on employee id insertion sort");
		System.out.println("press 5.update employee designation with provided designation for name");
		System.out.println("press 6.exit");
		
	}



	private static void displayDetails(Test[] emp, int size) {
		for(int i=0;i<size;i++)
		{
			System.out.println("employee id "+emp[i].getEmpid());
		       System.out.println("employee name "+emp[i].getEmpname());
		       System.out.println("employee deptname "+emp[i].getDeptname());
		       System.out.println("employee designation "+emp[i].getDes());
		       System.out.println("employee experience "+emp[i].getExp());
		       System.out.println("-------------------------------------------");
		}
	}



	private static void desig(Test[] emp, String desig, int size) {
		for(int i=0;i<size;i++)
		{
			if(desig.equals(emp[i].getEmpname())==true)
			{
				String name = new String();
				System.out.println("enter the designation");
				name = sc.nextLine();
				emp[i].setDes(name);
				System.out.println("employee id "+emp[i].getEmpid());
			       System.out.println("employee name "+emp[i].getEmpname());
			       System.out.println("employee deptname "+emp[i].getDeptname());
			       System.out.println("employee designation "+emp[i].getDes());
			       System.out.println("employee experience "+emp[i].getExp());
				
			}
		}
	}



	private static Test[] sort(Test[] emp, int size) {
		int id,i,j;
		Test c;
		for(i=1;i<size;i++)
		{
			id = emp[i].getEmpid();
			c=emp[i];
			j=i-1;
			while(j>=0 && emp[j].getEmpid()>id)
			{
				emp[j+1] = emp[j];
				j=j-1;
			}
			emp[j+1]=c;
		}
		return emp;
	}



	private static void search(Test[] emp, String d, int size) {
		Test temp = new Test();
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				if((emp[i].getDes()).compareTo(emp[j].getDes())>0)
				{
					temp = emp[i];
					emp[i]= emp[j];
					emp[j] = temp;
				}
			}
		}
		int middle=0,first=0,last=size-1;
		middle = (first+last)/2;
		while(first<=last)
		{
			if(d.equals(emp[middle].getDes())==true)
			{
				System.out.println("found");
				System.out.println("employee id "+emp[middle].getEmpid());
			       System.out.println("employee name "+emp[middle].getEmpname());
			       System.out.println("employee deptname "+emp[middle].getDeptname());
			       System.out.println("employee designation "+emp[middle].getDes());
			       System.out.println("employee experience "+emp[middle].getExp());
			       return ;
			}
			else if(d.compareTo(emp[middle].getDes())>0)
			{
				first = middle+1;
			}
			else
			{
				last = middle-1;
			}
			middle = (first+last)/2;
		}
	   System.out.println("not found");
	   return ;
	}

	private static void display(int r, int r1, Test[] emp,int size) {
		for(int i=0;i<size;i++)
		{
			if(emp[i].getExp()>=r && emp[i].getExp()<=r1)
			{
		       System.out.println("employee id "+emp[i].getEmpid());
		       System.out.println("employee name "+emp[i].getEmpname());
		       System.out.println("employee deptname "+emp[i].getDeptname());
		       System.out.println("employee designation "+emp[i].getDes());
		       System.out.println("employee experience "+emp[i].getExp());
			}
		}
	}

	private static Test[] createEmp(int size) {
		Test[] emp1 = new Test[size];
		for(int i=0;i<size;i++) {
		System.out.println("enter the employee id");
		int empid = sc.nextInt();
		System.out.println("enter the employee name");
		sc.nextLine();
		String empname = sc.nextLine();
		System.out.println("enter the employee department either computers or arts or physics");
		String deptname = sc.nextLine();
		if(deptname.equals("computers")==false && deptname.equals("arts")== false && deptname.equals("physics")== false)
		{
			System.out.println("please enter valid department");
			deptname = sc.nextLine();
		}
		System.out.println("enter the experience above 0");
		int exp = sc.nextInt();
		if(exp<=0)
		{
			System.out.println("please enter valid experience");
			exp = sc.nextInt();
		}
		sc.nextLine();
		System.out.println("enter the designation either hod, assistant professor, professor, instructor");
		String des = sc.nextLine();
		if(des.equals("hod")==false && des.equals("assistant professor")== false && des.equals("professor")
				==false && des.equals("instructor")==false  )
		{
			System.out.println("please enter valid designation");
			des = sc.nextLine();
		}
		emp1[i] = new Test(empid,empname,deptname,exp,des);
		}
		return emp1;
	}
}
