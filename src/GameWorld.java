

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

/**
 * A simulation of a set of bouncing sprites.
 * 
 * @author Curt Clifton. Created Jan 22, 2011.
 */
public class GameWorld implements GameEnvironment, Drawable, Temporal {
	private static final int UPDATE_INTERVAL_MS = 10;
	private final int width;
	private final int height;
	private final Color color;

	private final List<Sprite> sprites = new ArrayList<>();
	private final List<Sprite> spritesToAdd = new ArrayList<>();
	private final List<Sprite> spritesToRemove = new ArrayList<>();
	private final List<Hero> heroList = new ArrayList<>();

	private final Shape background;
	private boolean isPaused = false;


	/**
	 * Constructs a new world that has the given dimensions and the given
	 * background color.
	 * 
	 * @param width
	 * @param height
	 * @param color
	 */
	public GameWorld(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;

		this.background = new Rectangle2D.Double(0, 0, this.width, this.height);

		// Creates a timer which periodically informs this world of the
		// passage of time.
		Timer advanceStateTimer = new Timer(UPDATE_INTERVAL_MS, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timePassed();
			}
			
		});
		
		advanceStateTimer.start();
	}

	public Hero getHero()
	{
		return heroList.get(0);
	}

	/*
	-------------------------------------------------------------------------
	GameEnvironment interface
	*/

	@Override
	public synchronized void addSprite(Sprite sprite) {
		this.spritesToAdd.add(sprite);
	}

	@Override
	public synchronized void removeSprite(Sprite sprite) {
		this.spritesToRemove.add(sprite);
	}

	@Override
	public void addHero(Hero hero) {
		this.heroList.add(hero);
		this.spritesToAdd.add(hero);
	}

	@Override
	public synchronized Sprite nearestSprite(Point2D point) {
		Sprite nearest = null;
		double nearestDistance = Double.MAX_VALUE;
		for (Sprite b : this.sprites) {
			double distance = point.distance(b.getCenterPoint());
			if (distance < nearestDistance) {
				nearestDistance = distance;
				nearest = b;
			}
		}
		return nearest;
	}

	@Override
	public boolean isInsideWorldX(Point2D point) {
		return point.getX() >= 0 && point.getX() <= this.width;
	}

	@Override
	public boolean isInsideWorldY(Point2D point) {
		return point.getY() >= 0 && point.getY() <= this.height;
	}

	@Override
	public boolean isInsideWorld(Point2D point) {
		return isInsideWorldX(point) && isInsideWorldY(point);
	}

	@Override
	public Dimension getSize() {
		return new Dimension(this.width, this.height);
	}

	@Override
	public synchronized List<Drawable> getDrawableParts() {
		return new ArrayList<Drawable>(this.sprites);
	}

	@Override
	public Point2D getCenterPoint() {
		double x = this.width / 2;
		double y = this.height / 2;
		return new Point2D.Double(x, y);
	}

	// -------------------------------------------------------------------------
	// Drawable interface

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Shape getShape() {
		return this.background;
	}

	// -------------------------------------------------------------------------
	// Temporal interface

	@Override
	public synchronized void timePassed() {
		if (!this.isPaused) {
			for (Temporal t : this.sprites) {
				t.timePassed();
			}
		}
		this.sprites.removeAll(this.spritesToRemove);
		this.spritesToRemove.clear();
		this.sprites.addAll(this.spritesToAdd);
		this.spritesToAdd.clear();
	}

	@Override
	public void die() {
		// Ignored
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	@Override
	public boolean getIsPaused() {
		return this.isPaused;
	}
}
