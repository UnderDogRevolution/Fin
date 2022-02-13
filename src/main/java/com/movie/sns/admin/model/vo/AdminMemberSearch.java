package com.movie.sns.admin.model.vo;

public class AdminMemberSearch {
	
	// 회원 검색용 vo
	
	private String sk; //search key
	private String sv; //search value
	private String statusValue; // 상태값
	private String sortColumn;	// 정렬할 컬럼
	private String sortMethod;	// 정렬 방식
	
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

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getSortMethod() {
		return sortMethod;
	}

	public void setSortMethod(String sortMethod) {
		this.sortMethod = sortMethod;
	}

	@Override
	public String toString() {
		return "AdminMemberSearch [sk=" + sk + ", sv=" + sv + ", statusValue=" + statusValue + ", sortColumn="
				+ sortColumn + ", sortMethod=" + sortMethod + "]";
	}
	
	

}
