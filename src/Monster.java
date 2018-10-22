import java.awt.*;

/**
 * A ball that bounces off the walls.
 * 
 * @author Curt Clifton. Created Jan 22, 2011.
 */
public abstract class Monster extends Sprite {

	protected double diameter = 50.0;
	protected Color color = Color.MAGENTA;
	protected boolean facing;
	/**
	 * Constructs a abstract bouncer in the given world.
	 * 
	 * @param world
	 */
	public Monster(GameWorld world) {
		super(world);
		this.facing = randomFacing();
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
		if (facing) moveTowards("right",3.0);
		else moveTowards("left",3.0);
	}

	@Override
	public void updateSize() {

	}

	@Override
	public void updateColor() {

	}
}
