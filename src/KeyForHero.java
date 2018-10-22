import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyForHero implements KeyListener {
    final private Hero hero;
//    final private double speed = 3.0;
//    final private double zero = 0.0;
//    final private GameWorld world;

    public KeyForHero(GameWorld world) {
        this.hero = world.getHero();
//        this.world = world;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
//        System.out.println("Keystroke read as: "+e.getExtendedKeyCode());
        judgeTheKey(e);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        hero.setAction(Sprite.Action.idle);
    }

    private void judgeTheKey(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case 37:
                hero.setAction(Sprite.Action.left);
                break;
            case 38:
                hero.setAction(Sprite.Action.jump);
                break;
            case 39:
                hero.setAction(Sprite.Action.right);
                break;
            case 32:
                hero.setAction(Sprite.Action.shoot);
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
