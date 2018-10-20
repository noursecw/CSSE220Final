import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyForHero implements KeyListener {
    private Hero.Actions Action = Hero.Actions.IDLE;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                Action = Hero.Actions.LEFT;
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
    @Override
    public void keyReleased(KeyEvent e) {
        Action = Hero.Actions.IDLE;
    }

    public Hero.Actions getAction() {
        return Action;
    }
}
