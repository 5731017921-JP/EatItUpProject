
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {

	// public static CardLayout cards = new CardLayout();
	// public static JPanel first = new JPanel();
	public static boolean isClicked = false;
	public static int selectedMode;

	public static void main(String[] args) {
		// first.setLayout(cards);
		GameTitle title = new GameTitle();
		JFrame frame = new JFrame("Eat it up");
		title.titleSong.play();
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		JButton play = new JButton("PLAY");
		play.setPreferredSize(new Dimension(240, 40));
		JButton selectBS = new JButton("Select Blossom");
		selectBS.setPreferredSize(new Dimension(240, 40));
		JButton selectBC = new JButton("Select Buttercup");
		selectBC.setPreferredSize(new Dimension(240, 40));
		GameLogic logic = new GameLogic();
		GameScreen screen = new GameScreen(logic);
		titlePanel.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setLayout(new BorderLayout());
		north.add(selectBS, BorderLayout.WEST);
		north.add(selectBC, BorderLayout.CENTER);
		north.add(play, BorderLayout.EAST);
		titlePanel.add(title, BorderLayout.CENTER);
		titlePanel.add(north, BorderLayout.NORTH);
		titlePanel.setSize(720, 520);
		// first.add(titlePanel);
		// first.add(screen);
		// frame.add(titlePanel);
		// frame.add(screen);
		// first.requestFocus();
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				isClicked = true;
				title.titleSong.stop();
				frame.remove(titlePanel);
				frame.add(screen);
				frame.validate();
				frame.pack();
				screen.requestFocus();
				// cards.next(first);
				selectedMode = 3;
			}
		});
		selectBS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				isClicked = true;
				title.titleSong.stop();
				frame.remove(titlePanel);
				frame.add(screen);
				frame.validate();
				frame.pack();
				screen.requestFocus();
				// cards.next(first);
				selectedMode = 1;
			}
		});
		selectBC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				isClicked = true;
				title.titleSong.stop();
				frame.remove(titlePanel);
				frame.add(screen);
				frame.validate();
				frame.pack();
				screen.requestFocus();
				// cards.next(first);
				selectedMode = 2;
			}
		});

		frame.add(titlePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if (isClicked) {
				screen.runGame(selectedMode);
				frame.repaint();
			} else {
				frame.repaint();
			}
		}

	}
}