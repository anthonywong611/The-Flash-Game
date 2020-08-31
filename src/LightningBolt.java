
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LightningBolt extends JLabel {
	
	private boolean collectable; //used to check if each of the lightning bolts can be collected by the flash	
	public LightningBolt(boolean collectable) { 
		
		this.collectable = collectable;
		this.setIcon(new ImageIcon(new ImageIcon("images/lightningbolt.gif").getImage().getScaledInstance(35, 35, 0)));
		
	}

	public boolean getCollectable() {
		return collectable;
	}

	public void setCollectable(boolean collectable) {
		this.collectable = collectable;
	}
	
	

}
