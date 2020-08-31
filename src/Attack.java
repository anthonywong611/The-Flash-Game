import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

public class Attack extends JLabel implements ActionListener {
	
	//different levels of attacking lightning bolts - yellow, red, blue
	public static final ImageIcon[][] LIGHTNINGBOLT = {
			{new ImageIcon(new ImageIcon("images/yellowAttack.png").getImage().getScaledInstance(50, 50, 0))},
			{new ImageIcon(new ImageIcon("images/redAttack.png").getImage().getScaledInstance(50, 50, 0))},
			{new ImageIcon(new ImageIcon("images/blueAttack.png").getImage().getScaledInstance(50, 50, 0))}
	};
	
	private Timer moveTimer;  //used to move all the invisible lightning bolts across the screen
	private Timer disappeared;  //for how long will the lightning bolts appear on the screen after being fired
	private int startX;
	private int startY;

	public Attack(int startX, int startY) {
		
		this.startX = startX;
		this.startY = startY;
	
		this.setIcon(LIGHTNINGBOLT[0][0]); //initial level of attacking lightning bolts: yellow
		
		disappeared = new Timer(1200, this); //each lightning bolt appears for only 1.2 seconds on the screen
		
		moveTimer = new Timer(TheFlashGUI.flash.getSpeed() / 3, this); //speed of the lightning bolts travelling across the screen
		moveTimer.start();
		
	}

	public Timer getMoveTimer() {
		return moveTimer;
	}

	public void setMoveTimer(Timer moveTimer) {
		this.moveTimer = moveTimer;
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

	public Timer getDisappeared() {
		return disappeared;
	}

	public void setDisappeared(Timer disappeared) {
		this.disappeared = disappeared;
	}
	
	public void actionPerformed(ActionEvent event) {

		if(event.getSource() == moveTimer) { //when the attacking lighting bolts are moving
			
			if(getX() > TheFlashGUI.FRAME_WIDTH) {  //if they go out of the screen from the right
				
				this.setLocation(0, getY());  //come back from the left side of the screen
			
			} else if (getX() < 0) {  //if they go out of the screen from the left
				
				this.setLocation(TheFlashGUI.FRAME_WIDTH, getY());  //come back from the right side of the screen
				
			} else { 
				
				if(TheFlashGUI.flash.getLeft1() == true) { //if the flash is running to the left side
					this.setLocation(getX() - 30, getY());  //all the lightning bolts move to the left
				} else  //if the flash is running to the right
					this.setLocation(getX() + 30, getY());	//all the lightning bolts move to the right
			}
			
			//if more than 10 and less than 20 villains have been defeated 
			if(TheFlashGUI.flash.getDeathCounter() >= 10 && TheFlashGUI.flash.getDeathCounter() < 20) 
				this.setIcon(LIGHTNINGBOLT[1][0]);  //change the yellow lightning bolts to red lightning bolts
			else if(TheFlashGUI.flash.getDeathCounter() >= 20) //if more than 20 villains have been defeated
				this.setIcon(LIGHTNINGBOLT[2][0]);  //change from red lightning bolts to blue lightning bolts
			else if(TheFlashGUI.flash.getDeathCounter() >= 30)  //if more than 30 villains have been defeated
				this.setIcon(LIGHTNINGBOLT[2][0]);  //keep the blue lightning bolts
			
			for(int x = 0; x < TheFlashGUI.villain.length; x++) {
				
				if(isVisible()) { //if the attacking lightning bolts got fired by the flash and appear on the screen
					
					if(getBounds().intersects(TheFlashGUI.villain[x].getBounds())) { //if they hit the villains
						
						if(TheFlashGUI.villain[x].getMissionComplete() == false) {
							
							if(TheFlashGUI.villain[x].isVisible() == true) { //if the villains are still alive when they hit them
								this.setVisible(false); //all the attacking lightning bolts disappeared 
								TheFlashGUI.flash.setDeathCounter(TheFlashGUI.flash.getDeathCounter() + 1);  //increment the amount of villains defeated by one
								TheFlashGUI.villain[x].setVisible(false);  //defeated villains disappeared
								TheFlashGUI.warning[x].setVisible(false);  //warning signs disappeared with the villains
								TheFlashGUI.cityHealthBar[x].getHealthTimer().stop();   //city health bars stop decrementing 
								TheFlashGUI.cityHealthBar[x].safe(); //the cities will be safe until the villains appear again
								TheFlashGUI.villain[x].reborn();  //defeated villains enter dormant state
								TheFlashGUI.warning[x].reappear();  //warning signs enter dormant state
								TheFlashGUI.villain[x].setScoreCount(TheFlashGUI.villain[x].getScoreCount() + 1); //add one to the score
								TheFlashGUI.scores[x].setText(String.valueOf(TheFlashGUI.villain[x].count()));  //set the score
								
							}
						}	
						
					}
				}
				
			}
			
			//after the invisible lightning bolts got fired and move across the screen visibly
		} else if(event.getSource() == disappeared) {
			disappeared.stop(); //move for 1.2 seconds on the screen
			this.setVisible(false);  //and then disappear again
		}
		
	}
	
	
}
