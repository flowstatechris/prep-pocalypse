
import greenfoot.*;
public class Unlock2 extends Actor
{
    
    
    
 
   
    public Unlock2() // 2nd unlock message
    {
        
         setImage(new GreenfootImage("EagleClaw Unlocked! Press 3 to equip.", 30, Color.BLACK, Color.WHITE));
   
    }
    
    public void act() // how to remove this
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
