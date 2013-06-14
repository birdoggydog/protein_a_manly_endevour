package event_handler;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class InteractionEvent {

		public static int MOUSE=1;
		public static int KYB = 0;
		private MouseEvent me;
		private KeyEvent ke;
		private int type;
		public InteractionEvent(int t, MouseEvent m, KeyEvent e) {
			type = t;
			MouseEvent me = m;
			KeyEvent ke = e;
		}
		
		public MouseEvent getMouseEvent(){
			return me;
		}
		public KeyEvent getKeyEvent(){
			return ke;
		}
		public int getType() {
			return type;
		}
}
