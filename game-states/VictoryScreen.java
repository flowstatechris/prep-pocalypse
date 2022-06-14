
import greenfoot.*;
public class VictoryScreen extends Actor
{
    
    
    
 
   
    public VictoryScreen() // victory message
    {
        
       setImage(new GreenfootImage("Congrats Player, You beat the game! Thanks for playing!", 25, Color.BLACK, Color.WHITE));
       
    }
    
    public void act() // when this is removed
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
