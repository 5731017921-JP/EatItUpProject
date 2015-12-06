import java.awt.Graphics2D;

public class Student implements IRenderableObject {
	int score;
	boolean pause;
	boolean gameOver;
	int remainingTime;
	boolean eating;
	int x;
	int y;

	public int getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}

	public boolean isEating() {
		return eating;
	}

	public void setEating(boolean eating) {
		this.eating = eating;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	public Student(){
		score = 0;
		pause = false;
		gameOver = false;
		remainingTime = 180;
	}
	
	public void plusScore(){
		score++;
	}
	
	public void update(){
		
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public void render(Graphics2D g2) {
		
		
	}
}
