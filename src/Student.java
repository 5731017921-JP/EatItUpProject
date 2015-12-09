import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Student implements IRenderableObject {
	boolean decreaseScore;
	int score;
	boolean pause;
	boolean gameOver;
	int remainingTime;
	boolean eating;
	int life;
	int x;
	int y;
	BufferedImage ready;
	BufferedImage eat1;
	
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

	BufferedImage eat2;
	BufferedImage currentImage;
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
		if(this.life == 0){
			return true;
		}
		return false;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	public Student(int x,int y){
		score = 0;
		pause = false;
		gameOver = false;
		remainingTime = 180;
		this.x = x;
		this.y = y;
		this.life = 5;
		this.decreaseScore = false;
		try {
			ClassLoader loader = Main.class.getClassLoader();
			ready = ImageIO.read(loader.getResource("ready.png"));
			eat1 = ImageIO.read(loader.getResource("eating1.jpg"));
			eat2 = ImageIO.read(loader.getResource("eating2.jpg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
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
		if(currentImage == null){
			this.setCurrentImage(eat1);
		}
		else if(currentImage == eat1){
			this.setCurrentImage(eat2);
		}
		else if(currentImage == eat2){
			this.setCurrentImage(eat1);
		}
		if(this.isEating()){
			g2.drawImage(currentImage, null, this.x, this.y);
		}
		else {
			g2.drawImage(ready, null, this.x, this.y);
		}
		
	}
}
