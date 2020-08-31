import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class SpeedForce extends JProgressBar implements ActionListener {
	
	private int accumulate; //used to increase the speedforce bar
	
	public SpeedForce() {
		
		accumulate = 0;  //initial at 0
		
		this.setMaximum(20);  //full volumn of the bar is 30 points 
		this.setMinimum(accumulate);   //minimum volumn of the bar is 0 points
		this.setValue(accumulate);    //from the beginning of the game, the flash has 0 speedforce energy
		this.setForeground(Color.YELLOW);
		this.setBorder(BorderFactory.createLineBorder(Color.RED));
		
	}

	public int getAccumulate() {
		return accumulate;
	}

	public void setAccumulate(int accumulate) {
		this.accumulate = accumulate;
	}

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
