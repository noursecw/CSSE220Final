import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;

public class Platform implements Drawable {

	private static int x;
	private static int y;
	private static int width;
	private static int height;
	private Color color;
	
	public Platform(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.color = Color.BLACK;
	}
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	public Shape getShape() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, width, height);
	}
	
	public boolean testIntersection(Shape shapeA) {
		   Area plat = new Area(getShape());
		   plat.intersect(new Area(shapeA));
		   return !plat.isEmpty();
		}

}
