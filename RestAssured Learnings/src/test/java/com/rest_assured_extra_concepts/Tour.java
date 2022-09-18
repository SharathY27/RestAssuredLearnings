package com.rest_assured_extra_concepts;

public class Tour {
	
	String place;
	String modeOfTravel;
	String place2;
	String modeOfTravel2;
	

	public String getPlace() {
		return place;
	}



	public void setPlace(String place) {
		this.place = place;
	}



	public String getModeOfTravel() {
		return modeOfTravel;
	}



	public void setModeOfTravel(String modeOfTravel) {
		this.modeOfTravel = modeOfTravel;
	}



	public String getPlace2() {
		return place2;
	}



	public Tour setPlace2(String place2) {
		this.place2 = place2;
		return this;
	}



	public String getModeOfTravel2() {
		return modeOfTravel2;
	}



	public Tour setModeOfTravel2(String modeOfTravel2) {
		this.modeOfTravel2 = modeOfTravel2;
		return this;
	}



	public void engaThalaPora()
	{
		System.out.println(getPlace());
		System.out.println("Oh jolly ah " + getModeOfTravel() + " la " + getPlace() + " ku poriya");
	}
	
	public void engaThalaPora2()
	{
		System.out.println(getPlace2());
		System.out.println("Oh jolly ah " + getModeOfTravel2() + " la " + getPlace2() + " ku poriya");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		{ 1) this method is without returning this
		Tour tour = new Tour();
		tour.setPlace("Chennai");
		tour.setModeOfTravel("Car");
		tour.engaThalaPora();
//	}
		System.out.println("============================================");
//		{ 2) with returning this  //this is called method chaining
		
		tour.setPlace2("Anakaputhur").setModeOfTravel2("Bike").engaThalaPora2();
		

	}

}
