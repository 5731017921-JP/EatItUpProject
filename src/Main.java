/**
 * @author Jirut Polohaul (5731017921) 
 * @version 3 Apr 2015
 * Lab5 part1 (2/2014) in 2110215 Prog Meth
 */

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Button Smasher");
		GameLogic logic = new GameLogic();
		GameScreen screen = new GameScreen(logic);
		frame.add(screen);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			screen.repaint();
			logic.update();
		}
	}
}