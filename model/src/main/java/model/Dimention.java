package model;

/**
 *
 * Dimention
 */
public class Dimention implements contract.IDimention {
    private int width;
    private int height;

    public Dimention(int width, int height) {
        this.width = width;
        this.height = height;
    }
    // GETTER & SETTER
    /**
     * Get the width of the dimention
     * @return
     * The width
     */

    public int getWidth() {
        return width;
    }
    /**
     * Set the width of the dimention
     * @param width
     * The width
     */

    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * Get the height of the dimention
     * @return
     * The height
     */

    public int getHeight() {
        return height;
    }
    /**
     * Set the height of the dimention
     * @param height
     * The height
     */

    public void setHeight(int height) {
        this.height = height;
    }
}
