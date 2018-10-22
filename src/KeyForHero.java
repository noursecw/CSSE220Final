import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyForHero implements KeyListener {
    final private Ball hero;
    final private double speed = 3.0;
    final private double zero = 0.0;

    public KeyForHero(BallWorld world) {
        this.hero = world.getHero();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        judgeTheKey(e);
    }
    @Override
    public void keyReleased(KeyEvent e) {
//        hero.moveBy(0.0,0.0);
    }


    private void judgeTheKey(KeyEvent e)
    {
        switch (e.getKeyCode()) {
            case 37://Left arrow
                hero.moveBy(-speed,zero);
            case 38://Up arrow
                hero.moveBy(zero,-speed);
            case 39://Right arrow
                hero.moveBy(speed,zero);
            case 32://Space
                hero.moveBy(zero,zero);
            default:
                hero.moveBy(zero,zero);
        }
        System.out.println(e.getKeyCode());
        System.out.println(this.hero.getCenterPoint());
    }

//    public Hero.Actions getAction() {
//        return this.Action;
//    }
}
