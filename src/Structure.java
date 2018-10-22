import java.awt.*;
import java.awt.geom.Point2D;

public class Structure extends Sprite {
    public Structure(GameWorld world) {
        super(world);
    }

    public Structure(GameWorld world, Point2D centerPoint) {
        super(world, centerPoint);
    }

    @Override
    public void updatePosition() {

    }

    @Override
    public void updateSize() {

    }

    @Override
    public void updateColor() {

    }

    @Override
    public double getDiameter() {
        return 0;
    }

    @Override
    public Color getColor() {
        return null;
    }
}
