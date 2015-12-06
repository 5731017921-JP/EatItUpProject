import java.awt.Graphics2D;

public class PlayerStatus implements IRenderableObject{
	int score;
	boolean pause;
	boolean gameOver;
	int remainingTime;

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
	
	public PlayerStatus(){
		int score = 0;
		boolean pause = false;
		boolean gameOver = false;
		int remainingTime = 180;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public void render(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

}
