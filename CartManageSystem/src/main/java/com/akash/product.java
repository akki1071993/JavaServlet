package com.akash;

public class product {

	private int pid;
	private String pname;
	private String pprice;
	
	public product() {
	
	}
	
	public product(int pid, String pname, String pprice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	
	
	
	
}
