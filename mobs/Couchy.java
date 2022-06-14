import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class couchy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Couchy extends SmoothMover
{
    private GreenfootImage image1;
    public int health = 2000;
    
     private int shotTimer = 40;
     int speed = 15;
     GreenfootSound music = new GreenfootSound("card.wav");
    public Couchy() {
        image1 = new GreenfootImage ("couchy.png");
        setImage(image1);
        image1.scale (188, 188);
    }
    public void act() 
    {
         fire();
        setLocation(getX(),getY() + speed);
        ;
        bossMovement();
        shotTimer--;
    }    
    public void bossMovement() { // how couchy moves
    
            
            
            if (getY() <= 72)
            {
                speed =  10;
                setLocation(getX(),getY() + speed);
            }
            if (getY() >= 416)
            {
                speed= -10;
                setLocation(getX(),getY() + speed);
            }

        }
    
    public void fire() // this is the way the enemy shoots, on a 40 timer
    {        
        if (shotTimer == 0)
        {

            Badge badge = new Badge (getVelocity() , getRotation());
            getWorld().addObject (badge, getX() , getY() );
            badge.move ();
            music.play();
            shotTimer = 40;
    }
}   
    public void hit( int damage) // what tto do if hit
    {
        
        health = health - damage;
         if (health <= 0)
        {
            health = 0;
            getWorld().removeObject(this);
        }
        
        
    }
}
