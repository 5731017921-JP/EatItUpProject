
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import resource.Resource;

public class GameEnding extends JPanel {
	private int paintCounter;
	private GameLogic gameLogic;
	public static BufferedImage winnerDeclarationScence;

	public GameLogic getGameLogic() {
		return gameLogic;
	}

	public GameEnding(GameLogic gameLogic) {
		super();
		setPreferredSize(new Dimension(7, 480));
		setFocusable(true);
		requestFocus();
		this.gameLogic = gameLogic;
		ClassLoader loader = Main.class.getClassLoader();
		try {
			winnerDeclarationScence = ImageIO.read(loader.getResource(gameLogic.winnerName()));
		} catch (Exception e) {

		}
		paintCounter = 0;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (paintCounter <2) {
			g2d.drawImage(Resource.cryingScene, null, 0, 0);
			paintCounter++;
		} else {
			Resource.cryingSound.stop();
			g2d.drawImage(winnerDeclarationScence, null, 0, 0);
		}
	}
}