
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Teacher implements IRenderable {
	int x;
	int y;
	boolean isLooking;
	int counter,switching;
	int stateChangingDelay;
	BufferedImage lookingTeacher1, lookingTeacher2, notLookingTeacher;
	private static int remainingTime;

	public static int getRemainingTime() {
		return remainingTime;
	}

	public static void setRemainingTime(int remainingTime) {
		Teacher.remainingTime = remainingTime;
	}


	public Teacher() {
		switching = 0;
		counter = 200;
		remainingTime = 180;
		stateChangingDelay = random(150, 300);
		isLooking = false;
		ClassLoader loader = Main.class.getClassLoader();
		try {
			lookingTeacher1 = ImageIO.read(loader.getResource("res/lookingTeacher1.png"));
			lookingTeacher2 = ImageIO.read(loader.getResource("res/lookingTeacher2.png"));
			notLookingTeacher = ImageIO.read(loader.getResource("res/notLookingTeacher.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLooking() {
		return isLooking;
	}

	public void setLooking(boolean looking) {
		this.isLooking = looking;
	}

	public static int random(int start, int end) {
		return start + (int) (Math.random() * (end - start + 1));
	}


	@Override
	public int getZ() {
		return 1;
	}

	@Override
	public void render(Graphics2D g2) {

		if (isLooking()) {

			if (switching%2==0) {
				g2.drawImage(lookingTeacher2, null, 0, 0);
			} else {
				g2.drawImage(lookingTeacher1, null, 0, 0);
			}
		} else {

			g2.drawImage(notLookingTeacher, null, 0, 0);

		}
	}


}
