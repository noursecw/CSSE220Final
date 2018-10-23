import java.awt.Color;
import java.awt.event.KeyEvent;

public class Hero extends Sprite {
	private GameWorld world;
	private int diameter = 50;
	private Action action;
	private double speed = 5.0;

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
	public void updatePosition() {
		if (KeyInput.isPressed(KeyEvent.VK_LEFT)) {
			moveBy(-speed, zero);
			setFacing(false);

		} else if (KeyInput.isPressed(KeyEvent.VK_UP)) {
			if(KeyInput.isUpReleased()){
				moveBy(0,-5*speed);
				KeyInput.setUpRelease(false);
			}

		} else if (KeyInput.isPressed(KeyEvent.VK_RIGHT)) {
			moveBy(speed, zero);
			setFacing(true);

		} else if (KeyInput.isPressed(KeyEvent.VK_SPACE)) {
			this.shoot();

		} else if(!this.isStanding()){
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

	/**
	 *
	 * @return result if hero standing on the ground
	 */
	private boolean isStanding()
	{
		return (this.world.getSize().getHeight()<(getCenterPoint().getY()+this.diameter/2));
	}
}
