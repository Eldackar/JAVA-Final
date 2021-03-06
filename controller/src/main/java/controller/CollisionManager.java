package controller;

import contract.*;

/**
 * @author guillaume
 *
 */
class CollisionManager {
    /**
     * 
     */
    private static CollisionManager ourInstance;
    /**
     * 
     */
    private IModel model;

    /**
     * @return
     */
    static CollisionManager getInstance() {
        if(ourInstance == null)
            System.err.println("Move manager not initialized");
        return ourInstance;
    }

    /**
     * @param model
     */
    static void init(IModel model){
        ourInstance = new CollisionManager(model);
    }

    /**
     * @param model
     */
    private CollisionManager(IModel model) {
        this.model = model;
    }

    // METHODS //

    /**
     * All the collision of the game
     * @param element
     * @param other
     * 
     * 
     * 
     * 
     */

    /**
     * @param element
     * @param other
     */
    void performCollision(IElement element, IElement other){
        if(element.getBehavior() == null)
            return;
        switch (element.getBehavior()){
            case DEATH:
                performDeath(element,other);
                break;
            case MOREPOINT:
                performMorePoint(element,other);
                break;
            case END:
                performEnd(element,other);
                break;
            case UNLOCK:
                performUnlock(element,other);
                break;
            case SPELL:
                performSpell(element,other);
                break;
            default:
                System.err.println("Not implemented behavior "+element.getBehavior().toString());
                break;
        }
        if(element instanceof IItem && other instanceof IHero){
            this.model.getLevel().destroyElement(element);
        }
    }
    
    /**
	 * Collision between elements
	 * @param element
	 * @param other
	 */

    /**
     * @param element
     * @param other
     */
    void performCrossedCollision(IElement element, IElement other){
        if(element.getBehavior() != null)
            this.performCollision(element,other);
        if(other.getBehavior() != null)
            this.performCollision(other,element);
    }
    
    /**
	 * Method for when the hero die
	 * @param element
	 * @param other
	 */

    /**
     * @param element
     * @param other
     */
    void performDeath(IElement element, IElement other){
        if(other instanceof IHero){
            ((IHero) other).setAlive(false);
        }
    }
    
    /**
     * Add point to the score
     * @param element
     * @param other
     */

    /**
     * @param element
     * @param other
     */
    void performMorePoint(IElement element, IElement other){
        if(other instanceof IHero){
            ((IHero) other).setScore(((IHero) other).getScore()+100);
        }
    }
    
    /**
     * Unlock all the doors in the level
     * @param element
     * @param other
     */

    /**
     * @param element
     * @param other
     */
    void performUnlock(IElement element, IElement other){
        ILevel level = this.model.getLevel();
        for (int y = 0; y < level.getDimention().getHeight(); y++)
        {
            for (int x = 0; x < level.getDimention().getWidth(); x++)
            {
                IElement ele = level.getElement(x,y);
                if(ele instanceof IDoor){
                    ((IDoor) ele).setUnlocked(true);
                }
            }
        }
    }
    
    /**
     * The spell destroy the monster
     * @param element
     * @param other
     */

    /**
     * @param element
     * @param other
     */
    void performSpell(IElement element, IElement other){
        if(other instanceof IHero){
            ((IHero) other).setSpell(true);
            this.model.getLevel().destroyElement(element);
        } else if(other instanceof IMonster){
            this.model.getLevel().destroyElement(other);
            //TODO gagner des points lors de la destruction des monstres
        }
    }
    
    /**
     * End the level and load the next one
     * @param element
     * @param other
     */

    /**
     * @param element
     * @param other
     */
    /**
     * @param element
     * @param other
     */
    /**
     * @param element
     * @param other
     */
    /**
     * @param element
     * @param other
     */
    /**
     * @param element
     * @param other
     */
    void performEnd(IElement element, IElement other){
        if(other instanceof IHero){
            this.model.getLevel().setFinished(true);
        }
    }
}
