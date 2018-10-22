import java.awt.Color;
import java.awt.geom.Point2D;

public class Hero extends Sprite {
	private GameWorld world;
	private int diameter = 50;
	private Action action;

	public Hero(GameWorld world) {
		super(world);
		this.world = world;
		super.setXY(100, 100);
		this.action = Action.idle;
	}

/*	public Hero(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.world = world;
		super.setXY(100,100);
	}
	public Hero(GameWorld world, double xPos, double yPos)
	{
		super(world);
		this.world = world;
		super.setXY(xPos,yPos);
	}*/
	@Override
	public Color getColor() {
		return Color.BLACK;
	}

	@Override
	public void updatePosition() { //Only used for jump
		double speed = 5.0;
		switch (this.action) {
			case left:
				moveBy(-speed, zero);
				setFacing(false);
				break;
			case jump:
//                hero.updatePosition();//Unique for jump
				break;
			case right:
				moveBy(speed, zero);
				setFacing(true);
				break;
			case shoot://Space
				this.shoot();
				break;
			default:
				break;
		}
	}

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

	public void setAction(Action action) {
		this.action = action;
	}
}
