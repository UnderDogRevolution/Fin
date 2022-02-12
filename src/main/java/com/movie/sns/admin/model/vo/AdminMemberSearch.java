package com.movie.sns.admin.model.vo;

public class AdminMemberSearch {
	
	// 회원 검색용 vo
	
	private String sk; //search key
	private String sv; //search value
	private String ct; //category
	
	public AdminMemberSearch() {
		// TODO Auto-generated constructor stub
	}
	
	public String getSk() {
		return sk;
	}
	public void setSk(String sk) {
		this.sk = sk;
	}
	public String getSv() {
		return sv;
	}
	public void setSv(String sv) {
		this.sv = sv;
	}
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}

	@Override
	public String toString() {
		return "AdminMemberSearch [sk=" + sk + ", sv=" + sv + ", ct=" + ct + "]";
	}
	
	
	

}
