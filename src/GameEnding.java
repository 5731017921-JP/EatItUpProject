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
	private BufferedImage cryingScene, winnerDeclarationScence,gameOverScence;
	private int paintCounter;
	private GameLogic gameLogic;
	public AudioClip cryingSound;

	public GameEnding(GameLogic gameLogic) {
		super();
		setPreferredSize(new Dimension(7, 480));
		setFocusable(true);
		requestFocus();
		this.gameLogic = gameLogic;
		ClassLoader loader = Main.class.getClassLoader();
		try {
			cryingScene = ImageIO.read(loader.getResource("Ending1.jpg"));
			winnerDeclarationScence = ImageIO.read(loader.getResource("Ending_" + gameLogic.winnerName() + "win.jpg"));
			gameOverScence =  ImageIO.read(loader.getResource("Ending_gameover.jpg"));
			cryingSound = Applet.newAudioClip((loader.getResource("newcry.wav")).toURI().toURL());
		} catch (Exception e) {
			e.printStackTrace();
		}
		paintCounter = 0;
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (paintCounter <2) {
			g2d.drawImage(cryingScene, null, 0, 0);
			paintCounter++;
		} else {
			cryingSound.stop();
			if(gameLogic.isGameOver())
				g2d.drawImage(gameOverScence, null, 0, 0);
			else g2d.drawImage(winnerDeclarationScence, null, 0, 0);
		}
	}
}