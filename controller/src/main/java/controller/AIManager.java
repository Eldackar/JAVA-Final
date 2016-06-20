package controller;

import contract.Direction;
import contract.IAI;
import contract.IModel;

import java.util.Random;

class AIManager {
    /**
     * 
     */
    private static AIManager ourInstance;
    /**
     * 
     */
    private IModel model;
    /**
     * 
     */
    private MoveManager mm;
    /**
     * 
     */
    private static Random random;

    /**
     * @return
     */
    public static AIManager getInstance() {
        if(ourInstance == null)
            System.err.println("AI manager not initialized");
        return ourInstance;
    }

    /**
     * @param model
     */
    public static void init(IModel model){
        ourInstance = new AIManager(model);
        random = new Random();
    }

    /**
     * @param model
     */
    private AIManager(IModel model) {
        this.model = model;
        this.mm = MoveManager.getInstance();
    }
    
    // METHODS //
    /**
     * All the movement that AI can do
     * @param entity
     */
    /**
     * @param entity
     */
    void performAi(IAI entity){
        switch (entity.getAiType()){
            case STRAIGHT:
                this.performStraight(entity);
                break;
            case DIAGONAL:
                this.performDiagonal(entity);
                break;
            case RANDOM:
                this.performRandom(entity);
                break;
            case FOLLOW:
                this.performFollow(entity);
                break;
        }
    }
    
    /**
     * Diagonal movement for the AI
     * @param ai
     */
    
    /**
     * @param ai
     */
    void performDiagonal(IAI ai){
        int nextX, nextY;
        do {
            nextX = ai.getLocation().getX();
            nextY = ai.getLocation().getY();
            switch (ai.getDirection()) {
                case TOPLEFT:
                    nextX--;
                    nextY--;
                    break;
                case TOPRIGHT:
                    nextX++;
                    nextY--;
                    break;
                case BOTTOMLEFT:
                    nextX--;
                    nextY++;
                    break;
                case BOTTOMRIGHT:
                    nextX++;
                    nextY++;
                    break;
                default:
                    System.out.println("Invalid direction for "+ai.toString());
                    break;
            }
            if (!this.mm.canMoveOn(nextX, nextY)) {
                switch (ai.getDirection()){
                    case TOPLEFT:
                        ai.setDirection(Direction.TOPRIGHT);
                        break;
                    case TOPRIGHT:
                        ai.setDirection(Direction.BOTTOMLEFT);
                        break;
                    case BOTTOMLEFT:
                        ai.setDirection(Direction.BOTTOMRIGHT);
                        break;
                    case BOTTOMRIGHT:
                        ai.setDirection(Direction.TOPLEFT);
                        break;
                }
            }
        }while (!this.mm.canMoveOn(nextX, nextY));
        mm.safeMoveTo(ai,nextX,nextY);
    }

    
    /**
     * Lateral movement from the AI
     * @param ai
     */
    
    /**
     * @param ai
     */
    void performStraight(IAI ai){
        int nextX, nextY;
        do{
            nextX = ai.getLocation().getX();
            nextY = ai.getLocation().getY();
            switch (ai.getDirection()){
                case UP:
                    nextY--;
                    break;
                case DOWN:
                    nextY++;
                    break;
                case LEFT:
                    nextX--;
                    break;
                case RIGHT:
                    nextX++;
                    break;
                default:
                    System.out.println("Invalid direction for "+ai.toString());
                    break;
            }
            if(!this.mm.canMoveOn(nextX, nextY)){
                switch (ai.getDirection()){
                    case UP:
                        ai.setDirection(Direction.DOWN);
                        break;
                    case DOWN:
                        ai.setDirection(Direction.UP);
                        break;
                    case LEFT:
                        ai.setDirection(Direction.RIGHT);
                        break;
                    case RIGHT:
                        ai.setDirection(Direction.LEFT);
                        break;
                    default:
                        System.out.println("Invalid direction for "+ai.toString());
                        break;
                }
            }
        }while(!this.mm.canMoveOn(nextX, nextY));
        mm.safeMoveTo(ai,nextX,nextY);
    }

    /**
     * Random movement for the AI
     * @param ai
     * 
     * 
     * 
     * /!\ /!\ /!\ /!\ NOT IMPLEMENTED /!\ /!\ /!\ /!\ 
     * 
     * 
     */
    /**
     * @param ai
     */
    void performRandom(IAI ai){
        int nextX;
        int nextY;
        do{
            nextX = ai.getLocation().getX();
            nextY = ai.getLocation().getY();
            nextX += random.nextInt(3)-1;
            nextY += random.nextInt(3)-1;
        }while(!this.mm.canMoveOn(nextX, nextY));
        mm.safeMoveTo(ai,nextX,nextY);
    }
    /**
     * Follow movement for the AI (Follow the player)     
     * @param ai
     * 
     * 
     * 
     * /!\ /!\ /!\ /!\ NOT IMPLEMENTED /!\ /!\ /!\ /!\ 
     * 
     * 
     */
    /**
     * @param ai
     */
    void performFollow(IAI ai){
        //TODO pathfinding
    }
}
