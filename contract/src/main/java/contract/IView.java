package contract;

import java.util.Observer;

/**
 * The Interface IView.
 *
 *
 */
public interface IView 
{

	/**
	 * update what the user see on screen
	 * 
	 */
	void repaint();

	
	/**
	 * Open the window
	 */
	void openFrame();

	
	/**
	 * Get the observer of the view
	 * @return
	 * An observer
     */
	Observer getObserver();

	
	/**
	 * Set the controller of the view
	 */
	void setController(IController controller);

}
