import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class thespire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spire extends SmoothMover
{
    
    private int speed = 3;
    private int health = 1500;
    public int slideDelay;
    public boolean slidingUp;
    private GreenfootSound music = new GreenfootSound ("Bell.wav");
    private int shotTimer = 45;
    /**
     * Act - do whatever the thespire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(),getY() + speed);
        fire();
        spireMovement();
        slideDelay--;
        shotTimer--;
        
    }    
    private void spireMovement() // robots slide up and down
    {
        if (slidingUp && slideDelay < 1)
        {
            setLocation ( getX(), getY() + speed);

            slidingUp = false;
            slideDelay = 30;
        }

        if (!slidingUp && slideDelay < 1)
        {
            setLocation ( getX(), getY() + speed);

            slidingUp = true;
            slideDelay = 30;

        }
        if (getY() <= 130)
        {
            speed = 7;
            setLocation(getX(),getY() + speed);
        }
        if (getY() >= 312)
        {
            speed= -7;
            setLocation(getX(),getY() + speed);
        }
    }
        public void hit( int damage) // what to do when hit
    {
        
        health = health - damage;
         if (health <= 0)
        {
            health = 0;
            getWorld().removeObject(this);
        }
        
        
    }
    public void fire() // there is the way robots shoot, on a 40 timer
    {        
        if (shotTimer == 0)
        {

            Bell bell = new Bell (getVelocity() , getRotation());
            getWorld().addObject (bell, getX() , getY() );
            bell.move ();
            music.play();
            shotTimer = 25;
    }
}

}




