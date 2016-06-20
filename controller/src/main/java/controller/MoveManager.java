package controller;

import contract.*;

class MoveManager {
    /**
     * 
     */
    private static MoveManager ourInstance;
    /**
     * 
     */
    private IModel model;

    /**
     * @return
     */
    public static MoveManager getInstance() {
        if(ourInstance == null)
            System.err.println("Move manager not initialized");
        return ourInstance;
    }

    /**
     * @param model
     */
    public static void init(IModel model){
        ourInstance = new MoveManager(model);
    }

    /**
     * @param model
     */
    private MoveManager(IModel model) {
        this.model = model;
    }

    // METHODS //

    /**
     * Check if a collision happend between the element and an other
     * @return
     * The other element in collision or null if no collision
     */
    /**
     * @param element
     * @return
     */
    IElement hasCollision(IElement element){
        ILocation elementLocation = element.getLocation();
        for(IEntity entity: this.model.getLevel().getEntities()){
            if(elementLocation.getX() == entity.getLocation().getX() && elementLocation.getY() == entity.getLocation().getY() && element != entity){
                return entity;
            }
        }
        return this.model.getLevel().getElements()[elementLocation.getY()][elementLocation.getX()];
    }

    
    /**
     * Tell if a movement is possible or not
     * @param x
     * @param y
     * @return
     */
    
    /**
     * @param x
     * @param y
     * @return
     */
    boolean canMoveOn(int x, int y){
        IDimention levelDimentions = this.model.getLevel().getDimention();
        if(x > levelDimentions.getWidth()-1 || x < 0)
            return false;
        if(y > levelDimentions.getHeight()-1 || y < 0)
            return false;
        if(this.model.getLevel().getElement(x,y) != null){
            return this.model.getLevel().getElement(x,y).isPermeable();
        }
        return true;
    }
    
    /**
     * Allow to move to another position
     * @param entity
     * @param x
     * @param y
     * @return
     */

    /**
     * @param entity
     * @param x
     * @param y
     * @return
     */
    boolean safeMoveTo(IEntity entity, int x, int y){
        if(canMoveOn(x,y)) {
            entity.moveTo(x,y);
            this.model.flush();
            return true;
        }
        return false;
    }
}
