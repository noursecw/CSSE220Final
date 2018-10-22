import java.awt.*;

/**
 * A ball that bounces off the walls.
 * 
 * @author Curt Clifton. Created Jan 22, 2011.
 */
public abstract class Monster extends Sprite {

	protected double diameter = 50.0;
	protected Color color = Color.MAGENTA;
	protected boolean facing = randomFacing();
	/**
	 * Constructs a abstract bouncer in the given world.
	 * 
	 * @param world Gameworld
	 */
	public Monster(GameWorld world) {
		super(world);
		}

	@Override
	public double getDiameter() {
		return this.diameter;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void updatePosition() {
		//change the time period between two possible changing facing
//		this.facing = randomFacing();
		if (facing) moveBy(0.3,zero);
		else moveBy(-0.3,zero);
	}

	@Override
	public void updateSize() {

	}

	@Override
	public void updateColor() {

	}
}
