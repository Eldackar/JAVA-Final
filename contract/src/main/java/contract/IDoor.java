package contract;

import contract.IElement;

/**
 * Created by guillaume
 * Set the state of the door
 */
public interface IDoor extends IElement {
	
	/**
	 * define if the door is locked or not
	 * @return
	 */
    boolean isUnlocked();
    
    /**
     * set the state of the door
     * @param unlocked
     */

    void setUnlocked(boolean unlocked);
}
