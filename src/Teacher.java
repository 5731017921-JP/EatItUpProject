import java.awt.Graphics2D;

public class Teacher implements IRenderableObject{
	int x;
	int y;
	boolean looking = false;
	int counter = 200;
	int stateChangingDelay = random(150, 300);
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
		return looking;
	}

	public void setLooking(boolean looking) {
		this.looking = looking;
	}
	private static int random(int start, int end) {
		return start + (int) (Math.random() * (end - start + 1));
	}
	public void update() {
		if (counter > 0) {
			counter--;
		} else {
			stateChangingDelay = random(150, 300);
			counter = stateChangingDelay;
			looking = !looking;
		}
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void render(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

}
