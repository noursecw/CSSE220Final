import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard {

	private static boolean[] pressed = new boolean[128];
	public static boolean upRelease = true;

	public static KeyListener listener = new KeyAdapter() {

		@Override
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			if (code < pressed.length) {
				pressed[code] = true;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int code = e.getKeyCode();
			if (code < pressed.length) {
				pressed[code] = false;
				if (code == 38) {
					upRelease = true;
				}
			}
		}
	};

	public static boolean isPressed(int key) {
		// TODO Auto-generated method stub
		return pressed[key];
	}

}