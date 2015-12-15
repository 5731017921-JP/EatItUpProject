
import java.awt.Graphics2D;

import resource.Resource;

public class Teacher implements IRenderable {
	private int counter, switching, stateChangingDelay;
	boolean isLooking;
	private static int remainingTime;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getSwitching() {
		return switching;
	}

	public void setSwitching(int switching) {
		this.switching = switching;
	}

	public int getStateChangingDelay() {
		return stateChangingDelay;
	}

	public void setStateChangingDelay(int stateChangingDelay) {
		this.stateChangingDelay = stateChangingDelay;
	}

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

			if (switching % 2 == 0) {
				g2.drawImage(Resource.lookingTeacher2, null, 0, 0);
			} else {
				g2.drawImage(Resource.lookingTeacher1, null, 0, 0);
			}
		} else {

			g2.drawImage(Resource.notLookingTeacher, null, 0, 0);

		}
	}

}
