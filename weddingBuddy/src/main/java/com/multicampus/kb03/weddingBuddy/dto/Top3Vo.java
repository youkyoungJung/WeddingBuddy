package com.multicampus.kb03.weddingBuddy.dto;

public class Top3Vo {
	private String name;
	private int cnt;
	private String intro;
	private String agency_name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getAgency_name() {
		return agency_name;
	}
	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}
	@Override
	public String toString() {
		return "Top3Vo [name=" + name + ", cnt=" + cnt + ", intro=" + intro + ", agency_name=" + agency_name + "]";
	}
	
	
}
