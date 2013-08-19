package mobiles;

import map.Location;
import map.Map;
import portal.AbstractPortal;
import event_handler.InteractionEvent;

public abstract class AbstractMobile extends AbstractPortal {
	String icon;
	private boolean alive;
	Map mMap;
	protected int health = 20;
	int damage = 10;
	protected int fat = 20;
	protected int environment=20;
	protected int speed = 2;
	//int FramesPerUpdate = fps/speed
	int framesPerUpdate = 60/speed;
	int framesSinceUpdate = 60;
	AbstractPortal[][] drawnMap;
	protected boolean shouldUpdate = false;
	/**
	 * Basic implementation for all moving things.  Not just living ones!
	 * @param x
	 * @param y
	 */
	public AbstractMobile(int x, int y, Map map) {
		super();
		this.x = x;
		this.y = y;
		mMap = map;
		setAlive(true);
	}
	@Override
	public boolean acceptInteraction(InteractionEvent e) {
		System.out.println("GettingFingeredAbstractly");

		switch(e.getType()) {
		case(InteractionEvent.MOUSE):
			break;
		case(InteractionEvent.EAT):
			System.out.println("Just got ate Abstractly.");

		int damage = e.getResultValue();
		health -= damage;
		fat -=damage;
		InteractionEvent ret = new InteractionEvent(InteractionEvent.EAT_RESULT,this);
		e.setResultValue(damage);
		e.getSender().acceptInteraction(ret);
		if(health <= 0) {
			die();
		}
		break;
		case(InteractionEvent.EAT_RESULT):
			System.out.println("Just ate Abstractly.");
		this.health+=e.getResultValue();
		this.fat+=e.getResultValue();		
		break;
		}
		return true;
	};
	/**
	 * Update the to the new location, stract implementions will handle
	 * how to determine and validity etc... of new locs
	 * @param newX
	 * @param newY
	 */
	public boolean move(int newX, int newY) {
		if(canMove(newX, newY)) {
			this.x = newX;
			this.y = newY;
			shouldUpdate=false;
			framesSinceUpdate=0;
//			System.out.println("I can always move!@");
			return true;
		} else {
//			System.out.println("I'm about to finger something");
			return finger(x,y);
		}
	}
	public boolean canMove(int ex, int yy) {
		return mMap.canPlace(ex, yy, drawnMap);
	}
	public Location[] getAdj() {
		return mMap.getAdjacent(mMap.getLocation(x, y));
	}
	/**
	 * Send out your interaction
	 * @return
	 */
	public boolean finger(int ex, int yh) {
		
		//System.out.println("fingering");
		AbstractPortal[] fingerables = mMap.getFingerables(yh,ex);
		//System.out.println("finger"+fingerables.length);

		if(fingerables!=null) {
			InteractionEvent e = new InteractionEvent(InteractionEvent.EAT,this);
			e.setResultValue(damage);
			for(AbstractPortal p: fingerables){
//				System.out.println(""+p.getClass());
				if(p instanceof AbstractMobile) {
	//				System.out.println("fingering from finger");
					((AbstractMobile) p).acceptInteraction(e);
					return true;
				} else {
					//System.out.println("can't find to finger");
				}
			}
		}
		return false;
	}
	/**
	 * Terminte mobile.
	 * @return
	 */
	public boolean die() {
		setAlive(false);
		System.out.println("Creature Dead!");
		return true;
	}
	public String getIcon() {
		return this.icon;
	}
	public abstract boolean doMaMove();

	public boolean shouldUpdate() {
		if(shouldUpdate) {

		} else if(framesSinceUpdate>framesPerUpdate) {
			shouldUpdate=true;
			framesSinceUpdate=0;
		} else {
			shouldUpdate = false;
			framesSinceUpdate++;
		}
		return shouldUpdate;
	}	
	public void setDrawnMap(AbstractPortal[][] mmaapp) {
		drawnMap=mmaapp;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
