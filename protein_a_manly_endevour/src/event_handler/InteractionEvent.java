package event_handler;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import portal.AbstractPortal;

public class InteractionEvent {

	public static final int MOUSE=1;
	public static final int KYB = 0;
	public static final int EAT = 2;
	public static final int EAT_RESULT=3;
	private AbstractPortal sender;
	private MouseEvent me;
	private KeyEvent ke;
	private int type;
	private int resultValue;
	/**
	 * 
	 * @param type type of event which triggered this
	 * @param m - the mouse event to handle
	 * @param e  - the key event too handle
	 */
	public InteractionEvent(int type, MouseEvent m, KeyEvent e) {
		this.type = type;
		me = m;
		ke = e;

	}
	public InteractionEvent(int type) {
		this.type = type;

	}
	public InteractionEvent(int type, AbstractPortal abstractMobile) {
		this.type = type;
		this.sender = abstractMobile;
	}
	public void setResultValue(int value) {
		resultValue=value;
	}
	public int getResultValue() {
		return resultValue;
	}
	public void setSender(AbstractPortal sender) {
		this.sender = sender;
	}
	public AbstractPortal getSender() {
		return sender;
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
