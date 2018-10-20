import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyForHero implements KeyListener {
    private Hero.Actions Action;

    public KeyForHero() {
        Hero.Actions Action = Hero.Actions.IDLE;
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println(Action);
//        judgeTheKey(e);
    }

    public void keyPressed(KeyEvent e) {
        System.out.println(Action);
        judgeTheKey(e);
    }
    @Override
    public void keyReleased(KeyEvent e) {
//        Action = Hero.Actions.IDLE;
        System.out.println(Action);
    }


    private void judgeTheKey(KeyEvent e)
    {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                Action = Hero.Actions.LEFT;
                System.out.println("reached left");
                System.out.println(Action);
            case KeyEvent.VK_RIGHT:
                Action = Hero.Actions.LEFT;
            case KeyEvent.VK_UP:
                Action = Hero.Actions.LEFT;
            case KeyEvent.VK_SPACE:
                Action = Hero.Actions.LEFT;
            default:
                Action = Hero.Actions.IDLE;
        }
        System.out.println(Action);
    }

    public Hero.Actions getAction() {
        return Action;
    }
}
