import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sageworker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sageworker extends SmoothMover
{
    private int health = 300;
    private GreenfootImage image1 = new GreenfootImage("sage.png");
    private GreenfootSound music = new GreenfootSound ("knife.wav");
    private int speed = 15;
    public int slideDelay;
    public boolean slidingUp;
    
    private int shotTimer = 25;
    public Sageworker()
    {
        setImage(image1);
        
    }
    public void act() 
    {
        setLocation(getX(),getY() + speed);
        fire();
        sageMovement();
        slideDelay--;
        shotTimer--;
        
        //TouchingBullet();
    }  
       public void hit( int damage) // when they get hit subtract the damage value of what hit them
    {

        health = health - damage;
        if (health <= 0)
        {
            health = 0;
            getWorld().removeObject(this);
        }

    }
    
         private void sageMovement() // robots slide up and down
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
        if (getY() <= 125)
        {
            speed = 15;
            setLocation(getX(),getY() + speed);
        }
        if (getY() >= 563)
        {
            speed= -15;
            setLocation(getX(),getY() + speed);
        }
    }
  
    
    public void fire() // there is the way robots shoot, on a 40 timer
    {        
        if (shotTimer == 0)
        {

            Parm parm = new Parm (getVelocity() , getRotation());
            getWorld().addObject (parm, getX() , getY() );
            parm.move ();
            music.play();
            shotTimer = 25;
    }
}   
public void TouchingBullet()
{
    if ( isTouching(Bullet.class))
    {
    
        removeTouching(Bullet.class);
        hit(23);
    
    }
}
public void TouchingLighting()
{
    
    if ( isTouching(Lightning.class))
    {
    
        removeTouching(Lightning.class);
        hit(75);
    
    }
    
    
}

}
