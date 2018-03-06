package com.luiscasas;

/**
 *  
 *	@author: Luis Casas
 *	
 *	Copyright (C) 2018-03-05
 */

public class TimeFPSEncoder {
	
	private int framesPerSecond = 25;
	private int numFrames;
	private String time;
	
	public TimeFPSEncoder() {
	}
	
	public TimeFPSEncoder(int numFrames) {
		this.numFrames = numFrames;
		convertToTime(numFrames);
	}
	
	public TimeFPSEncoder(String time) {
		this.time = time;
		convertToFPS(time);
	}
	
	public void convertToTime(int numFrames) {
		int totalSeconds = numFrames / this.framesPerSecond;
		int hours = totalSeconds / 3600;
		int minutes = (totalSeconds - (hours * 3600)) / 60;
		int seconds = totalSeconds - (hours * 3600) - (minutes * 60);
		int frames = numFrames % this.framesPerSecond;
		
		String hourStr;
		String minStr;
		String secStr;
		String framesStr = Integer.toString(frames);
		
		if(hours < 10) {
			 hourStr = "0"+ Integer.toString(hours);
		} else {
			hourStr = Integer.toString(hours);
		}
	
		if(minutes < 10) {
			minStr = "0"+ Integer.toString(minutes);
		} else {
			minStr = Integer.toString(minutes);
		}
	
		if(seconds < 10) {
			secStr = "0"+ Integer.toString(seconds);
		} else {
			secStr = Integer.toString(seconds);
		}
		
		if(frames < 10) {
			framesStr = "0"+ Integer.toString(frames);
		} else {
			framesStr = Integer.toString(frames);
		}		
		
		this.time = hourStr + ":" + minStr + ":" + secStr + ":" + framesStr;
	}
	
	public void convertToFPS(String time) {
		
		int totalFrames = 0;
		String[] tempStr = time.split(":");
		
		if(tempStr.length == 4) {
			for(int i = 0; i < tempStr.length; i++) {
				// System.out.println(tempStr[i]);
				int tempInt = Integer.parseInt(tempStr[i]);
				
				if(i == 3) {
					totalFrames += tempInt;
				} else if(i == 2) {
					totalFrames += (tempInt * this.framesPerSecond);
				} else if(i == 1){
					totalFrames += (tempInt * 60) * this.framesPerSecond;
				} else {
					totalFrames += (tempInt * 3600) * this.framesPerSecond;
				}
				
				this.numFrames = totalFrames;
			}			
		} else {
			System.out.println("Invalid format");
		}
	}
	
	public String getTime() {
		return this.time;
	}
	
	public int getFPS() {
		return this.numFrames;
	}
	
}
