package com.luiscasas;

public class Main {

	public static void main(String[] args) {
		
		TimeFPSEncoder fps = new TimeFPSEncoder();
		
		fps.convertToFPS("00:00:00:01");
		System.out.println(fps.getFPS());
		
		fps.convertToFPS("00:01:01:00");
		System.out.println(fps.getFPS());
		
		fps.convertToTime(4990);
		System.out.println(fps.getTime());	
		
		fps.convertToTime(329);
		System.out.println(fps.getTime());		
	}

}
