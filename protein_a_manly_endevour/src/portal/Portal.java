package portal;

public interface Portal {
	
	
	// handle an interaction.  if eating return false;
	// else return true;
	boolean acceptInteraction(/* Event e 
	    * location? < -mouse?
	    * key code? < - keybarod, allow multiple interactions?
	    */);
}
