
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import resource.Resource;

public class GameTitle extends JPanel {
	
	
	private boolean howToPlayClicked;
	private int paintCounter;

	public GameTitle() {
		super();
		setPreferredSize(new Dimension(720, 480));
		setVisible(true);
		setFocusable(true);
		requestFocus();
		paintCounter = 20;
		howToPlayClicked = false;

	}

	public int paintDelayCount() {
		return paintCounter++;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (isHowToPlayClicked()) {
			g2d.drawImage(Resource.howToPlay, null, 0, 0);
		} else {

			if (paintCounter <= 100) {
				g2d.drawImage(Resource.bg1, null, 0, 0);
				paintDelayCount();
			} else if (paintCounter <= 150) {
				g2d.drawImage(Resource.bg2, null, 0, 0);
				paintDelayCount();
			} else if (paintCounter <= 200) {
				g2d.drawImage(Resource.bg3, null, 0, 0);
				paintDelayCount();
			} else if (paintCounter <= 250) {
				g2d.drawImage(Resource.bg4, null, 0, 0);
				paintDelayCount();
			} else {
				if (paintCounter % 100 < 33) {
					g2d.drawImage(Resource.bg5, null, 0, 0);
					paintDelayCount();
				} else if (paintCounter % 100 < 66) {
					g2d.drawImage(Resource.bg6, null, 0, 0);
					paintDelayCount();
				} else {
					g2d.drawImage(Resource.bg7, null, 0, 0);
			
				}
			}
		}

	}

	public boolean isHowToPlayClicked() {
		return howToPlayClicked;
	}

	public void setHowToPlayClicked(boolean howToPlayIsClicked) {
		this.howToPlayClicked = howToPlayIsClicked;
	}
}