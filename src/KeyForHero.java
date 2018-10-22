import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyForHero implements KeyListener {
    final private Hero hero;
    final private double speed = 1.0;

    public KeyForHero(GameWorld world) {
        this.hero = world.getHero();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("From upup"+e.getExtendedKeyCode());
        judgeTheKey(e);
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }


    private void judgeTheKey(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if (keyCode==37) {
            hero.moveTo("left", speed);
            System.out.println("left "+speed);
        }//Left
        else if (keyCode==38) {
            hero.moveTo("up", speed);
            System.out.println("up " + speed);
        }//up
           else if (keyCode==39) {
            hero.moveTo("right", speed);
            System.out.println("right " + speed);
        }//Right
            else if (keyCode==32) {
            hero.shoot();
        }
            else    System.out.println("Not valid");
        System.out.println(keyCode);
        System.out.println(this.hero.getCenterPoint());
    }

//    public Hero.Actions getAction() {
//        return this.Action;
//    }
}
