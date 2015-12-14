
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Student implements IRenderable {
	private boolean lifeDecreased, eating;
	private int life, id, score;
	private BufferedImage ready, currentImage, eat1, eat2, eat3, eat4;;

	public boolean isLifeDecreased() {
		return lifeDecreased;
	}

	public void setLifeDecreased(boolean lifeDecreased) {
		this.lifeDecreased = lifeDecreased;
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


	public Student(int id) {
		this.id = id;
		score = 0;
		this.life = 5;
		this.lifeDecreased = false;
		ClassLoader loader = Main.class.getClassLoader();
		try {
			if (id == 1) {
				ready = ImageIO.read(loader.getResource("res/Blossom-static.png"));
				eat1 = ImageIO.read(loader.getResource("res/Blossom-eat1.png"));
				eat2 = ImageIO.read(loader.getResource("res/Blossom-eat2.png"));
				eat3 = ImageIO.read(loader.getResource("res/Blossom-eat3.png"));
				eat4 = ImageIO.read(loader.getResource("res/Blossom-eat4.png"));
				currentImage = eat1;
			} else {
				ready = ImageIO.read(loader.getResource("res/Buttercup-static.png"));
				eat1 = ImageIO.read(loader.getResource("res/Buttercup-eat1.png"));
				eat2 = ImageIO.read(loader.getResource("res/Buttercup-eat2.png"));
				eat3 = ImageIO.read(loader.getResource("res/Buttercup-eat3.png"));
				eat4 = ImageIO.read(loader.getResource("res/Buttercup-eat4.png"));
				currentImage = eat1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void plusScore(int score) {
		this.score = this.score + score;
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
