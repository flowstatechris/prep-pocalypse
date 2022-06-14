import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Victory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Victory extends World
{

    /**
     * Constructor for objects of class Victory.
     * 
     */
    public Victory()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject (new VictoryScreen(), getWidth()/2 , getHeight()/2); // add victory screen in the middle of the screen
        
    }
    public void act()
    {
        restart();
        
    }
    public void restart() // restart the game
    {
         if (getObjects(VictoryScreen.class).isEmpty()) {
        
             Greenfoot.setWorld(new MyWorld());
            }
    }
}
