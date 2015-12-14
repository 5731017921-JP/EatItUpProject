
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {

	public static boolean isClicked = false;
	public static int selectedMode = 3;
	static GameLogic logic;
	static GameScreen screen;

	public static void main(String[] args) {
		try {
			JFrame frame = new JFrame("Eat it up");
			
			while (true) {
				GameTitle title = new GameTitle();
				title.titleSong.play();
				JPanel titlePanel = new JPanel();
				titlePanel.setLayout(new BorderLayout());
				JButton play = new JButton("2Players");
				play.setPreferredSize(new Dimension(180, 40));
				JButton selectBS = new JButton("Select Blossom");
				selectBS.setPreferredSize(new Dimension(180, 40));
				JButton selectBC = new JButton("Select Buttercup");
				selectBC.setPreferredSize(new Dimension(180, 40));
				JButton howToPlay = new JButton("HOW TO PLAY");
				howToPlay.setPreferredSize(new Dimension(180, 40));
				titlePanel.setLayout(new BorderLayout());
				logic = new GameLogic();
				screen = new GameScreen(logic);

				JPanel north = new JPanel();
				north.setLayout(new FlowLayout(0, 0, 0));
				north.add(selectBS);
				north.add(selectBC);
				north.add(play);
				north.add(howToPlay);
				titlePanel.add(title, BorderLayout.CENTER);
				titlePanel.add(north, BorderLayout.NORTH);
				titlePanel.setSize(720, 520);
				play.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						screen.backGroundMusic.play();
						logic.getLookableTeacher().start();
						logic.getTimeCount().start();
						logic.getBonusTimeAble().start();
						isClicked = true;
						title.titleSong.stop();
						frame.remove(titlePanel);
						frame.add(screen);
						frame.validate();
						frame.pack();
						screen.requestFocus();
						selectedMode = 3;
					}
				});
				selectBS.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						screen.backGroundMusic.play();
						logic.getLookableTeacher().start();
						logic.getTimeCount().start();
						logic.getBonusTimeAble().start();
						isClicked = true;
						title.titleSong.stop();
						frame.remove(titlePanel);
						frame.add(screen);
						frame.validate();
						frame.pack();
						screen.requestFocus();
						selectedMode = 1;
					}
				});
				selectBC.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						screen.backGroundMusic.play();
						logic.getLookableTeacher().start();
						logic.getTimeCount().start();
						logic.getBonusTimeAble().start();
						isClicked = true;
						title.titleSong.stop();
						frame.remove(titlePanel);
						frame.add(screen);
						frame.validate();
						frame.pack();
						screen.requestFocus();
						selectedMode = 2;
					}
				});
				howToPlay.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						title.setHowToPlayClicked(true);

					}
				});
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.add(titlePanel);
				frame.pack();
				while (!logic.isGameOver()) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					if (isClicked)
						screen.runGame(selectedMode);

					frame.repaint();

				}
				GameScreen.backGroundMusic.stop();

				GameEnding ending = new GameEnding(logic);
				frame.remove(screen);
				frame.add(ending);
				frame.validate();
				frame.setVisible(true);
				ending.cryingSound.play();

				frame.repaint();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				frame.repaint();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				frame.remove(ending);

			}
		} catch (Exception e) {

		}
	}
}