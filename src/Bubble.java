import java.awt.*;
import java.awt.geom.Point2D;

public class Bubble extends Sprite {
    final private Hero hero;
    final private double speed = 5.0;
    final private boolean facing;
    public Bubble(GameWorld world) {
        super(world);
        this.hero = world.getHero();
        super.setCenterPoint(hero.getCenterPoint());
        this.facing = hero.getFacing();
    }

    public Bubble(GameWorld world, Point2D centerPoint) {
        super(world, centerPoint);
        this.hero = world.getHero();
        super.setCenterPoint(hero.getCenterPoint());
        this.facing = hero.getFacing();
    }

    @Override
    public void updatePosition() {
        if (facing) moveTowards("right",speed);
        else moveTowards("left",speed);
    }

    @Override
    public void updateSize() {

    }

    @Override
    public void updateColor() {

    }

    @Override
    public double getDiameter() {
        return 50;
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
