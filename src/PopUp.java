import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.java2d.pipe.DrawImage;

public class PopUp {
	private boolean show;
	BufferedImage popUpImage;
	
	public PopUp(){
		ClassLoader loader = Main.class.getClassLoader();
		try {
			popUpImage = ImageIO.read(loader.getResource("BonusTime.jpg"));
		}
		catch (IOException e){
			popUpImage = null;
		}
	}
	
	
	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public void drawPopUp(Graphics2D g2d){
		if(show){
		g2d.drawImage(popUpImage,null,0,0);
		}
	}
}
