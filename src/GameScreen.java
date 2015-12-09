
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class GameScreen extends JComponent {

	private GameLogic logic;
	private final Font font = new Font("Tahoma", Font.BOLD, 30);
	private final Font smallfont = new Font("Tahoma", Font.PLAIN, 20);

	public GameScreen(GameLogic logic) {
		super();
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(1024, 768));
		this.logic = logic;
		setVisible(true);
		setFocusable(true);
		requestFocus();
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
						InputUtility.setkTriggered(false);
						logic.hitButton(logic.getStudent2(), logic.getTeacher());
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_K) {
					if (!InputUtility.iskTriggered()) {
						InputUtility.setkTriggered(true);
						InputUtility.setjTriggered(false);
						logic.hitButton(logic.getStudent2(), logic.getTeacher());
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					logic.getStudent1().setEating(false);
					InputUtility.setaTriggered(false);
					InputUtility.setdTriggered(false);
				}
			}
		});
	}

	private int[] getDrawingParameter(Graphics context, Font font, String status) {
		int[] params = new int[6];
		FontMetrics metrics = context.getFontMetrics(font);
		Rectangle2D rect = metrics.getStringBounds(status, context);
		int rectHeight = (int) rect.getHeight();
		params[0] = 0;
		params[1] = (300 - rectHeight) / 2;
		params[2] = 300;
		params[3] = rectHeight;
		params[4] = (300 - (int) rect.getWidth()) / 2;
		params[5] = (300 - rectHeight) / 2 + rectHeight - context.getFontMetrics(font).getDescent();
		return params;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 300, 300);
		g2d.setColor(Color.WHITE);
		g2d.setFont(smallfont);
		g2d.drawString("SCORE: " + logic.getStudent1().getScore(), 5, 295);
		int[] params = new int[6];
		logic.getStudent1().render(g2d);
		if (!logic.getTeacher().isLooking()) {
			params = getDrawingParameter(g2d, font, "PRESS");
			g2d.setColor(Color.BLUE);
			g2d.fillRect(params[0], params[1], params[2], params[3]);
			g2d.setColor(Color.WHITE);
			g2d.setFont(font);
			g2d.drawString("PRESS", params[4], params[5]);
			
		} else {
			params = getDrawingParameter(g2d, font, "STOP");
			g2d.setColor(Color.RED);
			g2d.fillRect(params[0], params[1], params[2], params[3]);
			g2d.setColor(Color.WHITE);
			g2d.setFont(font);
			g2d.drawString("STOP", params[4], params[5]);
		}
	}
}