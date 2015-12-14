package resource;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Resource {
	public static BufferedImage bg1;
	public static BufferedImage bg2;
	public static BufferedImage bg3;
	public static BufferedImage bg4;
	public static BufferedImage bg5;
	public static BufferedImage bg6;
	public static BufferedImage bg7;
	public static BufferedImage howToPlay;
	public static BufferedImage cryingScene, gameOverScence;
	public static AudioClip titleSong;
	public static AudioClip cryingSound;
	public static AudioClip eatingSound;
	public static BufferedImage lookingTeacher1;
	public static BufferedImage lookingTeacher2;
	public static BufferedImage notLookingTeacher;
	public static BufferedImage classroomBG, table, staticBook,bonusTimeIcon;
	public static java.applet.AudioClip backGroundMusic;

	static {
		ClassLoader loader = Resource.class.getClassLoader();
		try {
			eatingSound = Applet.newAudioClip((loader.getResource("res/eatingSound.wav")).toURI().toURL());
			cryingScene = ImageIO.read(loader.getResource("res/Ending1.jpg"));
			gameOverScence = ImageIO.read(loader.getResource("res/Ending_gameover.jpg"));
			cryingSound = Applet.newAudioClip((loader.getResource("res/newcry.wav")).toURI().toURL());
			lookingTeacher1 = ImageIO.read(loader.getResource("res/lookingTeacher1.png"));
			lookingTeacher2 = ImageIO.read(loader.getResource("res/lookingTeacher2.png"));
			notLookingTeacher = ImageIO.read(loader.getResource("res/notLookingTeacher.png"));
			classroomBG = ImageIO.read(loader.getResource("res/Classroom.png"));
			table = ImageIO.read(loader.getResource("res/Table.png"));
			staticBook = ImageIO.read(loader.getResource("res/ontable-3.png"));
			bonusTimeIcon = ImageIO.read(loader.getResource("res/BonusTime.png"));
			backGroundMusic = Applet.newAudioClip((loader.getResource("res/background.wav")).toURI().toURL());
			bg1 = ImageIO.read(loader.getResource("res/bg1.jpg"));
			bg2 = ImageIO.read(loader.getResource("res/bg2.jpg"));
			bg3 = ImageIO.read(loader.getResource("res/bg3.jpg"));
			bg4 = ImageIO.read(loader.getResource("res/bg4.jpg"));
			bg5 = ImageIO.read(loader.getResource("res/bg5.png"));
			bg6 = ImageIO.read(loader.getResource("res/bg6.jpg"));
			bg7 = ImageIO.read(loader.getResource("res/bg7.jpg"));
			howToPlay = ImageIO.read(loader.getResource("res/HowToPlay.jpg"));
			titleSong = Applet.newAudioClip((loader.getResource("res/titlesong.wav")).toURI().toURL());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
