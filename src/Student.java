import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Student implements IRenderable {
	private boolean decreaseScore;
	private int score;
	private boolean pause;
	private boolean gameOver;
	private int remainingTime;
	private boolean eating;
	private int life;
	private int id;
	private BufferedImage ready, currentImage;
	private BufferedImage eat1, eat2, eat3, eat4;

	public boolean isDecreaseScore() {
		return decreaseScore;
	}

	public void setDecreaseScore(boolean decreaseScore) {
		this.decreaseScore = decreaseScore;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public BufferedImage getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(BufferedImage currentImage) {
		this.currentImage = currentImage;
	}

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
		if (this.life == 0 || this.remainingTime == 0) {
			return true;
		}
		return false;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public Student(int id) {
		this.id = id;
		score = 0;
		pause = false;
		gameOver = false;
		remainingTime = 180*100;
		this.life = 5;
		this.decreaseScore = false;
		ClassLoader loader = Main.class.getClassLoader();
		try {
			if (id == 1) {
				ready = ImageIO.read(loader.getResource("Blossom-static.png"));
				eat1 = ImageIO.read(loader.getResource("Blossom-eat1.png"));
				eat2 = ImageIO.read(loader.getResource("Blossom-eat2.png"));
				eat3 = ImageIO.read(loader.getResource("Blossom-eat3.png"));
				eat4 = ImageIO.read(loader.getResource("Blossom-eat4.png"));
				currentImage = eat1;
			} else {
				ready = ImageIO.read(loader.getResource("Buttercup-static.png"));
				eat1 = ImageIO.read(loader.getResource("Buttercup-eat1.png"));
				eat2 = ImageIO.read(loader.getResource("Buttercup-eat2.png"));
				eat3 = ImageIO.read(loader.getResource("Buttercup-eat3.png"));
				eat4 = ImageIO.read(loader.getResource("Buttercup-eat4.png"));
				currentImage = eat1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void plusScore() {
		score++;
	}

	public void update() {

				setRemainingTime(getRemainingTime()-1);
				if(getRemainingTime() <= 0){
					setGameOver(true);
					setRemainingTime(0);
				}
	}
		

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void render(Graphics2D g2) {

		if (getCurrentImage() == eat1) {
			this.setCurrentImage(eat2);

		} else if (getCurrentImage() == eat2) {
			this.setCurrentImage(eat3);
		} else if (getCurrentImage() == eat3) {
			this.setCurrentImage(eat4);
		} else if (getCurrentImage() == eat4) {
			this.setCurrentImage(eat1);
		}

		if (isEating()) {
			g2.drawImage(getCurrentImage(), null, 0, 0);

		} else {
			g2.drawImage(ready, null, 0, 0);
		}

	}

	public int getId() {
		return id;
	}

}
