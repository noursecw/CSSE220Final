import javax.swing.event.EventListenerList;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Hero extends Ball {
	private int diameter = 50;
//	private KeyForHero keyListener = new KeyForHero();//Add keyListener to the frame


	public Hero(BallEnvironment world) {
		super(world);
		super.setXY(100, 100);
	}

	public Hero(BallEnvironment world, Point2D centerPoint) {
		super(world, centerPoint);
		super.setXY(100,100);
//		EventListenerList listenerList = new EventListenerList();

	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.BLACK;
	}

	@Override
	public void updatePosition() {
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
		return this.diameter;
	}

	/**
	 * Getter for JFrame in the main to add KeyListener
	 * @return
	 */
//	public KeyForHero getkeyListener() {
//		return keyListener;
//	}


}
