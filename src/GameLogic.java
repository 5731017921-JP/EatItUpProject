/**
 * @author Jirut Polohaul (5731017921) 
 * @version 3 Apr 2015
 * Lab5 part1 (2/2014) in 2110215 Prog Meth
 */
public class GameLogic {

	private int stateChangingDelay;
	private int counter;
	private boolean hittingTime = true;
	private int score = 0;

	public GameLogic() {
		stateChangingDelay = random(100, 500);
		counter = stateChangingDelay;
	}

	public boolean isHittingTime() {
		return hittingTime;
	}

	public int getScore() {
		return score;
	}

	public void hitButton() {
		if (hittingTime) {
			score++;
		} else {
			score--;
			if (score < 0)
				score = 0;
		}
	}

	public void update() {
		if (counter > 0) {
			counter--;
		} else {
			stateChangingDelay = random(50, 200);
			counter = stateChangingDelay;
			hittingTime = !hittingTime;
		}
	}

	private static int random(int start, int end) {
		return start + (int) (Math.random() * (end - start + 1));
	}
}
