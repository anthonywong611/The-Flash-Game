import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class City extends JLabel implements ActionListener {

	private int startX;
	private int startY;
	
	public City(int startX, int startY) {
		
		this.startX = startX;
		this.startY = startY;
		
		this.setIcon(null);
	
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

	public void actionPerformed(ActionEvent e) {}

}
