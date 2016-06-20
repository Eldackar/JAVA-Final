package contract;

/**
 * The Interface IAI
 *
 * @author Guillaume
 */
public interface IAI extends IEntity {
    AIType getAiType();
    
    /**
     * Set a type of AI
     */
    
    void setAiType(AIType aiType);
}
