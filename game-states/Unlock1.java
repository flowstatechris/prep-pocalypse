
import greenfoot.*;
public class Unlock1 extends Actor
{
    
    
    
 
   
    public Unlock1() // 1st unlock message
    {
        
         setImage(new GreenfootImage("Rifle Unlocked! Press 2 to equip.", 30, Color.BLACK, Color.WHITE));
        
        
    }
    
    public void act() // how to get rid of this
    {
        
        
        if (Greenfoot.mouseClicked(this))
        {
             getWorld().removeObject(this);
        }
        if (Greenfoot.isKeyDown("space"))
        {
            getWorld().removeObject(this);
            
        }
    }
}
