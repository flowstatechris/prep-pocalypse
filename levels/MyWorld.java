
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    
  
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(500, 500, 1); 
        image1 = new GreenfootImage ("title.png");       
        image1.scale(500, 500);
        setBackground(image1);
        
        
        

        

    }
    public void nextLevel()
    {
        // if this world is clicked, proceed to the next level
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Caf());
            
        }
        
    }
  public void act()
    {
        
        nextLevel();
        
    }
    
    }

