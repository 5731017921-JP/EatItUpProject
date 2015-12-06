import java.awt.Graphics2D;

public interface IRenderableObject {
	public int getZ();

	public void render(Graphics2D g2);
}
