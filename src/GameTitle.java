import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.applet.AudioClip;

public class GameTitle extends JPanel {
	private BufferedImage bg1,bg2,bg3,bg4,bg5,bg6,bg7;
	public AudioClip titleSong;
	private int paintCounter;
	
	public GameTitle() {
		super();
		setPreferredSize(new Dimension(720, 480));
		setVisible(true);
		setFocusable(true);
		requestFocus();
		ClassLoader loader = Main.class.getClassLoader();
		try {
			bg1 = ImageIO.read(loader.getResource("bg1.jpg"));
			bg2 = ImageIO.read(loader.getResource("bg2.jpg"));
			bg3 = ImageIO.read(loader.getResource("bg3.jpg"));
			bg4 = ImageIO.read(loader.getResource("bg4.jpg"));
			bg5 = ImageIO.read(loader.getResource("bg5.png"));
			bg6 = ImageIO.read(loader.getResource("bg6.jpg"));
			bg7 = ImageIO.read(loader.getResource("bg7.jpg"));
			titleSong = Applet.newAudioClip((loader.getResource("titlesong.wav")).toURI().toURL());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		paintCounter=20;
		
	}
	public int paintDelayCount(){
		return paintCounter++;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		if(paintCounter<=100){
			g2d.drawImage(bg1,null,0,0);
			paintDelayCount();
		}
		else if(paintCounter<=150){
			g2d.drawImage(bg2,null,0,0);
			paintDelayCount();
		}
		else if(paintCounter<=200){
			g2d.drawImage(bg3,null,0,0);
			paintDelayCount();
		}
		else if(paintCounter<=250){
			g2d.drawImage(bg4,null,0,0);
			paintDelayCount();
		}
		else{
			if(paintCounter%100<33){
			g2d.drawImage(bg5,null,0,0);
			paintDelayCount();}
			else if(paintCounter%100<66){
				g2d.drawImage(bg6,null,0,0);
				paintDelayCount();
			}
			else{
				g2d.drawImage(bg7,null,0,0);
				paintDelayCount();
			}
		}

	}
}