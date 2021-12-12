package com.unishk.controller;

public class DepartamentiDTO {
	
	private Integer id;
	private String emertimi;
	
	public DepartamentiDTO() {
	
	}

	public DepartamentiDTO(Integer id, String emertimi) {
		
		this.id = id;
		this.emertimi = emertimi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmertimi() {
		return emertimi;
	}

	public void setEmertimi(String emertimi) {
		this.emertimi = emertimi;
	}
	
	
	
	
	
	

}
