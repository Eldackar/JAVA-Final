package contract;

/**
 * Created by guillaume
 * Size of the screen
 */
public interface IDimention {
	
	/**
	 * get the width of the screen
	 * @return
	 */

    int getWidth();
    
    /**
     * set the width of the screen
     * @param width
     */

    void setWidth(int width);
    
    /**
     * get the height of the screen
     * @return
     */

    int getHeight();
    
    /**
     * set the height of the screen
     * @param height
     */

    void setHeight(int height);
}
