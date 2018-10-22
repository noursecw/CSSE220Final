import java.awt.Color;
import java.awt.geom.Point2D;

public class Hero extends Sprite {
	private GameWorld world;
	private int diameter = 50;

	public Hero(GameWorld world) {
		super(world);
		this.world = world;
		super.setXY(100, 100);
	}

	public Hero(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.world = world;
		super.setXY(100,100);
	}
	public Hero(GameWorld world, double xPos, double yPos)
	{
		super(world);
		this.world = world;
		super.setXY(xPos,yPos);
	}
	@Override
	public Color getColor() {
		return Color.BLACK;
	}

	@Override
	public void updatePosition() { }

	@Override
	public void updateSize() {
	}

	@Override
	public void updateColor() {
	}

	@Override
	public double getDiameter() {
		return this.diameter;
	}
	public void shoot()
	{
		super.getWorld().addSprite(new Bubble(this.world));
	}

}
