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

public class GameEnding extends JPanel {
	private BufferedImage cryingScene, winnerDeclarationScence;
	private JLabel playAgainButton, Home;
	private int paintCounter;
	private GameLogic gameLogic;
	public AudioClip cryingSound;

	public GameEnding(GameLogic gameLogic) {
		super();
		setPreferredSize(new Dimension(7, 480));
		setFocusable(true);
		requestFocus();
		ClassLoader loader = Main.class.getClassLoader();
		try {
			cryingScene = ImageIO.read(loader.getResource("Ending1.jpg"));
			winnerDeclarationScence = ImageIO.read(loader.getResource("Ending_" + gameLogic.winnerName() + "win.jpg"));
			cryingSound = Applet.newAudioClip((loader.getResource("cry.wav")).toURI().toURL());
		} catch (Exception e) {
			e.printStackTrace();
		}
		paintCounter = 0;
		this.gameLogic = gameLogic;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (paintCounter <2) {
			g2d.drawImage(cryingScene, null, 0, 0);
			paintCounter++;
		} else {
			cryingSound.stop();
			g2d.drawImage(winnerDeclarationScence, null, 0, 0);
		}
	}
}
