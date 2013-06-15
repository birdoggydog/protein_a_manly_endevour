package portal;

import event_handler.InteractionEvent;

public interface Portal {
	
	
	// handle an interaction.  if eating return false;
	// else return true;
	boolean acceptInteraction(InteractionEvent e/* Event e 
	    * location? < -mouse?
	    * key code? < - keybarod, allow multiple interactions?
	    */);

	int getY();

	int getX();
	
}
