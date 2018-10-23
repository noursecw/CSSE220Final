import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyInput implements KeyListener {


    //    final private Hero hero;
    private static boolean upRelease = false;



    private static boolean[] pressed = new boolean[128];
//    final private double speed = 3.0;
//    final private double zero = 0.0;
//    final private GameWorld world;

    public KeyInput(GameWorld world) {
//        this.hero = world.getHero();
//        this.world = world;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
//        System.out.println("Keystroke read as: "+e.getExtendedKeyCode());
        int code = e.getKeyCode();
        if (code<pressed.length) pressed[code]=true;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code<pressed.length)
        {
            pressed[code] = false;
            if (code==38) upRelease = true;
        }
    }


//            case 85://U
////                world.nextLevel();
//                break;
//            case 68://D
////                world.previousLevel();
//                break;
//            default:
//                break;
//        }
//        System.out.println(this.hero.getCenterPoint());
//    }

    public static boolean isUpReleased() {
        return upRelease;
    }
    public static void setUpRelease(boolean upRelease) {
        KeyInput.upRelease = upRelease;
    }
    public static boolean isPressed(int keyCode) {
        return pressed[keyCode];
    }
//    public Hero.Actions getAction() {
//        return this.Action;
//    }
}
