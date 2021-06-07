package Test1;

public class Test {
	private int empid;
	private String empname;
	private String deptname;
	private int exp;
	private String des;

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Test(int empid, String empname, String deptname, int exp, String des) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.deptname = deptname;
		this.exp = exp;
		this.des = des;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}