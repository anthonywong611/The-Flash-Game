import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class CityHealthBar extends JProgressBar implements ActionListener {

	private int time;
	private int safe;
	private int beingAttacked;
	private int cityDestroyed = 0;
	private int startX;
	private int startY;
	private Timer timer;
	private Timer HealthTimer;
	
	public CityHealthBar(int startX, int startY, int safe, int beingAttacked) {
		
		time = 100;
		this.startX = startX;
		this.startY = startY;
		this.safe = safe;
		this.beingAttacked = beingAttacked;
		
		this.setMinimum(0); //minimum at 0
		this.setMaximum(time); //maximum at 100
		this.setValue(time);  //currently at 100
		this.setForeground(Color.GREEN); //green bar
		this.setStringPainted(true); //display the percentage left
		
		timer = new Timer(safe, this); //used for how long the cities will remain safe until the next attack
		HealthTimer = new Timer(beingAttacked, this); //used for how fast and strong the cities are being attacked
		
		HealthTimer.start();
	}
	
	public int getSafe() {
		return safe;
	}

	public void setSafe(int safe) {
		this.safe = safe;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Timer getHealthTimer() {
		return HealthTimer;
	}

	public void setHealthTimer(Timer healthTimer) {
		HealthTimer = healthTimer;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public int getBeingAttacked() {
		return beingAttacked;
	}

	public void setBeingAttacked(int beingAttacked) {
		this.beingAttacked = beingAttacked;
	}
	
	public int getCityDestroyed() {
		return cityDestroyed;
	}

	public void setCityDestroyed(int cityDestroyed) {
		this.cityDestroyed = cityDestroyed;
	}

	//when the cities are safe
	public void safe() {
		timer.start();
	}

	public void actionPerformed(ActionEvent event) {
		
		//when the cities are being attacked
		if(event.getSource() == HealthTimer) {
			
			time--; //decrement the time of the bar by one each time
			this.setValue(time);
				
			//change the color of the bar as time gets less
			if(time <= 66 && time > 33) { // when time hit 2/3 of the total amount
				this.setForeground(Color.ORANGE); //change the color of the bar to orange
			} else if (time <= 33 && time > 0) { //when time time hit 1/3 of total amoung
				this.setForeground(Color.RED); //change the color of the bar to red
			} else if(time == 0) {  //when time runs out 
				TheFlashGUI.flash.setLost(TheFlashGUI.flash.getLost() + 1); //flash lose one time
			}	
			
		} else if (event.getSource() == timer) { //if the villains got destroyed
				timer.stop(); //wait till the villains show up again
				HealthTimer.start(); //start decrementing the health bar again since the villains start attacking again
		}
	}
	
}
