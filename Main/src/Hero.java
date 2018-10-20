import java.awt.Color;
import java.awt.geom.Point2D;

public class Hero extends Ball {

	public Hero(BallEnvironment world) {
		super(world);
		// TODO Auto-generated constructor stub
	}

	public Hero(BallEnvironment world, Point2D centerPoint) {
		super(world, centerPoint);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.BLACK;
	}

	@Override
	public void updatePosition() {
		// code for hero movement
		super.setCenterPoint(new Point2D.Double(100, 100));
	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getDiameter() {
		// TODO Auto-generated method stub
		return 5;
	}

}
