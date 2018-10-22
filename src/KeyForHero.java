import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyForHero implements KeyListener {
    final private Hero hero;
    final private double speed = 1.0;
    final private GameWorld world;

    public KeyForHero(GameWorld world) {
        this.hero = world.getHero();
        this.world = world;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("Keystroke read as: "+e.getExtendedKeyCode());
        judgeTheKey(e);
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void judgeTheKey(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case 37:
                hero.moveTowards("left", speed);
                hero.setFacing(false);
                break;
            case 38:
                hero.moveTowards("up", speed);
                break;
            case 39:
                hero.moveTowards("right", speed);
                hero.setFacing(true);
                break;
            case 32://Space
                hero.shoot();
                break;
            case 85://U
//                world.nextLevel();
                break;
            case 68://D
//                world.previousLevel();
                break;
            default:
                break;
        }
        System.out.println(this.hero.getCenterPoint());
    }

//    public Hero.Actions getAction() {
//        return this.Action;
//    }
}
