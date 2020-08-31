import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Villain extends JLabel implements ActionListener {

	private int health;
	private int originalHealth;
	private int recover;
	private int attack;
	public int scoreCount;
	private Timer reborn;
	private boolean missionComplete;
	
	public Villain(String fileName, int health, int recover, int attack, boolean missionComplete) {
		
		this.health = health;
		this.originalHealth = health;
		this.recover = recover;
		this.attack = attack;
		this.missionComplete = missionComplete;
	
		this.setIcon(new ImageIcon(new ImageIcon("images/" + fileName + ".png").getImage().getScaledInstance(50, 50, 0)));
		
		reborn = new Timer(recover, this); //recover stands for how long the villains take to reappear after being defeated
		
	}
	
	public int getScoreCount() {
		return scoreCount;
	}

	public void setScoreCount(int scoreCount) {
		this.scoreCount = scoreCount;
	}
	
	public int getRecover() {
		return recover;
	}

	public void setRecover(int recover) {
		this.recover = recover;
	}
	
	public boolean getMissionComplete() {
		return missionComplete;
	}

	public void setMissionComplete(boolean missionComplete) {
		this.missionComplete = missionComplete;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public Timer getReborn() {
		return reborn;
	}

	public void setReborn(Timer reborn) {
		this.reborn = reborn;
	}
	
	public void reborn() {
		reborn.start();
	}
	
	//display the scores in the panel from the GUI
	public String count() {
		return ":" + scoreCount;
	}
		
	public void actionPerformed(ActionEvent event) {
		
		//if the villains got destroyed
		if(event.getSource() == reborn) {
			
			this.reborn.stop();  //run through the dormant state
			this.setVisible(true); //after the timer is done, appear again
			this.setHealth(originalHealth); //set the health back to the original health
			
		}
	}

}
