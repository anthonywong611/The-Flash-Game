import javax.swing.*;

public class Villains extends JLabel {
	
	//villains label in the panel in GUI class
	public Villains(String fileName) {
		
		this.setIcon(new ImageIcon(new ImageIcon("images/" + fileName + ".png").getImage().getScaledInstance(50, 50, 0)));
		
	}

}
