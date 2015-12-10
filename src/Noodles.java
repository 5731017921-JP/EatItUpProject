import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Noodles implements IRenderable{ 
	Student student;
	BufferedImage currentImage,noodles1,noodles2,noodles3,noodles4,ready;
	public Noodles(Student student){
		this.student = student;
		ClassLoader loader = Main.class.getClassLoader();
		
		try {
			if(student.getId()==1){
			ready = ImageIO.read(loader.getResource("ontable-1.png"));
			noodles1 = ImageIO.read(loader.getResource("noodles_1.png"));
			noodles2 = ImageIO.read(loader.getResource("noodles_2.png"));
			noodles3 = ImageIO.read(loader.getResource("noodles_3.png"));
			noodles4 = ImageIO.read(loader.getResource("noodles_4.png"));
			currentImage = noodles1;
			}
			else{
				ready = ImageIO.read(loader.getResource("ontable-2.png"));
				noodles1 = ImageIO.read(loader.getResource("noodles-1.png"));
				noodles2 = ImageIO.read(loader.getResource("noodles-2.png"));
				noodles3 = ImageIO.read(loader.getResource("noodles-3.png"));
				noodles4 = ImageIO.read(loader.getResource("noodles-4.png"));
				currentImage = noodles1;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(BufferedImage currentImage) {
		this.currentImage = currentImage;
	}
	@Override
	public int getZ() {

		return 3;
	}

	@Override
	public void render(Graphics2D g2) {
		if (getCurrentImage() == noodles1) {
			this.setCurrentImage(noodles2);

		} else if (getCurrentImage() == noodles2) {
			this.setCurrentImage(noodles3);
		} else if (getCurrentImage() == noodles3) {
			this.setCurrentImage(noodles4);
		} else if (getCurrentImage() == noodles4) {
			this.setCurrentImage(noodles1);
		}

		if (student.isEating()) {
			g2.drawImage(currentImage, null, 0, 0);
		} else {
			g2.drawImage(ready, null, 0, 0);
		}
		
	}
	

}
