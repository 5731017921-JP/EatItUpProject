import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameScreen extends JPanel {

	private GameLogic logic;
	private final Font font = new Font("Jokerman", Font.BOLD, 30);
	// private final Font smallfont = new Font("Tahoma", Font.PLAIN, 20);
	private BufferedImage classroomBG, table, staticBook;

	public GameScreen(GameLogic logic) {
		super();
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(720, 480));
		this.logic = logic;
		setVisible(true);
		setFocusable(true);
		requestFocus();

		ClassLoader loader = Main.class.getClassLoader();
		try {
			classroomBG = ImageIO.read(loader.getResource("Classroom.png"));
			table = ImageIO.read(loader.getResource("Table.png"));
			staticBook = ImageIO.read(loader.getResource("ontable-3.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		RenderableHolder.getInstance().add(logic.getStudent1());
		RenderableHolder.getInstance().add(logic.getStudent2());
		RenderableHolder.getInstance().add(logic.getTeacher());
		RenderableHolder.getInstance().add(logic.getNoodles1());
		RenderableHolder.getInstance().add(logic.getNoodles2());
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_A) {
					if (!InputUtility.isaTriggered()) {
						InputUtility.setaTriggered(true);
						InputUtility.setdTriggered(false);
						logic.hitButton(logic.getStudent1(), logic.getTeacher());
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					if (!InputUtility.isdTriggered()) {
						InputUtility.setdTriggered(true);
						InputUtility.setaTriggered(false);
						logic.hitButton(logic.getStudent1(), logic.getTeacher());
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_J) {
					if (!InputUtility.isjTriggered()) {
						InputUtility.setjTriggered(true);
						InputUtility.setlTriggered(false);
						logic.hitButton(logic.getStudent2(), logic.getTeacher());
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_L) {
					if (!InputUtility.islTriggered()) {
						InputUtility.setlTriggered(true);
						InputUtility.setjTriggered(false);
						logic.hitButton(logic.getStudent2(), logic.getTeacher());
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					logic.getStudent1().setEating(false);
					InputUtility.setaTriggered(false);
					InputUtility.setdTriggered(false);
				}
				if (e.getKeyCode() == KeyEvent.VK_K) {
					logic.getStudent2().setEating(false);
					InputUtility.setaTriggered(false);
					InputUtility.setdTriggered(false);
				}
			}
		});
	}

	public void runGame(int selectedMode) {
		if (selectedMode == 1) {
			logic.update(logic.getStudent1(), logic.getTeacher());
			logic.getStudent2().setEating(false);
		} else if (selectedMode == 2) {
			logic.update(logic.getStudent2(), logic.getTeacher());
			logic.getStudent1().setEating(false);

		} else {
			logic.update(logic.getStudent1(), logic.getStudent2(), logic.getTeacher());
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(classroomBG, null, 0, 0);
		g2d.setColor(Color.white);
		g2d.setFont(font);
		if (Main.selectedMode == 3 || Main.selectedMode == 1) {
			g2d.drawString("Blossom : " + logic.getStudent1().getScore(), 220, 90);
			g2d.setColor(Color.darkGray);
			g2d.drawString("life:" + logic.getStudent1().getLife(), 5, 475);
		}
		if (Main.selectedMode == 3 || Main.selectedMode == 2) {
			g2d.drawString("Buttercup : " + logic.getStudent2().getScore(), 220, 150);
			g2d.setColor(Color.darkGray);

			g2d.drawString("life:" + logic.getStudent2().getLife(), 625, 475);

		}

		for (IRenderable x : RenderableHolder.getInstance().getRenderableList()) {
			if (x.getZ() < 3) {
				x.render(g2d);
			} else {
				g2d.drawImage(table, null, 0, 0);
				g2d.drawImage(staticBook, null, 0, 0);
				break;
			}

		}
		for (IRenderable x : RenderableHolder.getInstance().getRenderableList()) {
			if (x.getZ() >= 3) {
				x.render(g2d);
			}

		}
		

	}
}