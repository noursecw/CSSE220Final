

import util.Random;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * A Sprite is an abstract class that provides a default timePassed() and
 * getShape() implementations and several abstract methods that subclasses must
 * override to get the desired behavior.
 * 
 * The default implementation of {@link #timePassed()} calls the abstract
 * methods {@link #updatePosition()}, {@link #updateSize()}, and
 * {@link #updateColor()}, giving subclasses the chance to animate any of those
 * properties.
 * 
 * The default implementation of {@link #getShape()} calls the abstract method
 * 
 * @author Curt Clifton. Created Jan 22, 2011.
 */
public abstract class Sprite implements Drawable, Temporal, Relocatable {
	private Point2D centerPoint;
	private GameWorld world;
	final double zero = 0.0;
	private boolean facing = true;//Right-True;Left-False

	/**
	 * Constructs a new ball at location (0,0) in the given world.
	 * 
	 * @param world GameWorld
	 */
	public Sprite(GameWorld world) {
		this(world, new Point2D.Double());
	}

	/**
	 * Constructs a ball centered at the given point in the given world.
	 * 
	 * @param world GameWorld
	 * 
	 * @param centerPoint center point
	 */
	public Sprite(GameWorld world, Point2D centerPoint) {
		this.world = world;
		this.centerPoint = centerPoint;
	}

	// -------------------------------------------------------------------------
	// Utility accessors for subclasses

	/**
	 * Sets the center point of this object
	 * 
	 * @param centerPoint center point
	 */
	void setCenterPoint(Point2D centerPoint) {
		this.centerPoint = centerPoint;
	}

	/**
	 * Returns the value of the field called 'world'.
	 * 
	 * @return Returns the world.
	 */
	protected GameEnvironment getWorld() {
		return this.world;
	}

	/*
	protected double randomVelocity(double limit)
	{
		double maxVelocity = limit;
		return Random.randInterval(-maxVelocity,maxVelocity);
	}*/

	/**
	 * Return true(right) or false(left) randomly
	 * @return boolean facing to right
	 */
	boolean randomFacing()
	{
		double number = Random.randInterval(-1.0,1.0);
		return number > 0;
	}

	/**
	 * Return a Point2D.Double point with xy border with margin
	 * @param xLim width limit
	 * @param yLim height limit
	 * @param margin margin
	 * @return point
	 */
	Point2D.Double randomPos(double xLim, double yLim, double margin)
	{
		double x = Random.randInterval(margin,xLim-margin);
		double y = Random.randInterval(margin,yLim-margin);
		return new Point2D.Double(x,y);
	}


	/**
	 * Set centerpoint
	 * @param xPos x position
	 * @param yPos y position
	 */
	void setXY(double xPos, double yPos)
	{
		this.setCenterPoint(new Point2D.Double(xPos,yPos));
	}

	/**
	 * Move constantly with certain speed
	 * @param xSpeed speed x direction
	 * @param ySpeed speed y direction
	 */
	void moveBy(double xSpeed, double ySpeed)
	{
		double x = getCenterPoint().getX();
		double y = getCenterPoint().getY();
		this.setXY(x+xSpeed,y+ySpeed);
	}
	protected void jump()
	{

	}


//	protected void bounce()
//	{
//
//	}


	// -------------------------------------------------------------------------
	// Temporal interface

	@Override
	public void timePassed() {
		updateColor();
		updateSize();
		updatePosition();
	}

	@Override
	public void die() {
		this.world.removeSprite(this);
	}

	@Override
	public boolean getIsPaused() {
		// not yet implemented
		return false;
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		// not yet implemented
	}

	// -------------------------------------------------------------------------
	// Drawable interface (partial implementation, subclasses must help)

	@Override
	public Shape getShape() {
		double x = getCenterPoint().getX();
		double y = getCenterPoint().getY();
		double size = getDiameter();
		return new Ellipse2D.Double(x - size / 2, y - size / 2, size, size);
	}

	// -------------------------------------------------------------------------
	// Relocatable interface

	/**
	 * Re-centers this ball at the given point.
	 * 
	 * @param point point
	 */
	@Override
	public void moveTo(Point2D point) {
		// not yet implemented
	}

	/**
	 * Returns the center point of this object.
	 * 
	 * @return the center point
	 */
	@Override
	public Point2D getCenterPoint() {
		return this.centerPoint;
	}

	// -------------------------------------------------------------------------
	// Abstract "template methods" that must be overridden by subclasses.
	
	/**
	 * Updates the position of this object, if necessary, due to the passing of
	 * a "moment" in time.
	 */
	public abstract void updatePosition();

	/**
	 * Updates the size of this object, if necessary, due to the passing of a
	 * "moment" in time.
	 */
	public abstract void updateSize();

	/**
	 * Updates the color of this object, if necessary, due to the passing of a
	 * "moment" in time.
	 */
	public abstract void updateColor();

	/**
	 * Returns the diameter of this ball.
	 * 
	 * @return the diameter
	 */
	public abstract double getDiameter();

	boolean getFacing() {
		return facing;
	}
	void setFacing(boolean facing)
	{
		this.facing = facing;
	}
	public void flipFacing()
	{
		this.facing = !this.facing;
	}
}
