import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Teacher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends SmoothMover
{
    private GreenfootImage image1;
    private int speed = 75;
    public int health = 100;
    public int slideDelay;
    public boolean slidingUp;

    private int shotTimer = 40;
    public Robot() // programtically set the image
    {
        image1 = new GreenfootImage ("teacher.png");
        setImage(image1);

    }

    public void act() // what the robots do
    {

        
        fire();
        slideDelay--;
        shotTimer--;
        robotMovementCaf();
        robotMovementX();
        robotMovementK();
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

    public void robotMovementCaf() // robots slide up and down in Caf
    {
        if ( (this.getWorld().getClass() == Caf.class)) {
            
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
                speed = 75;
                setLocation(getX(),getY() + speed);
            }
            if (getY() >= 563)
            {
                speed= -75;
                setLocation(getX(),getY() + speed);
            }
        }
    }
    public void robotMovementX() {    
        if ( (this.getWorld().getClass() == X.class)) {
            // if in level X, this is how the robots move
            if ( isTouching(Egg.class))
            {
                hit(10);
                removeTouching(Egg.class);

            }
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
                speed = 75;
                setLocation(getX(),getY() + speed);
            }
            if (getY() >= 312)
            {
                speed= -75;
                setLocation(getX(),getY() + speed);
            }

        }
    }
      public void robotMovementK() {
    if ( (this.getWorld().getClass() == Keefe.class)) {
            
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
            if (getY() <= 72)
            {
                speed = 75;
                setLocation(getX(),getY() + speed);
            }
            if (getY() >= 416)
            {
                speed= -75;
                setLocation(getX(),getY() + speed);
            }

        }
    }


    public void fire() // there is the way robots shoot, on a 40 timer
    {        
        if (shotTimer == 0)
        {

            Goo goo = new Goo (getVelocity() , getRotation());
            getWorld().addObject (goo, getX() , getY() );
            goo.move ();

            shotTimer = 40;
        }
    }

    

    public void TouchingLightning()
    {
        Student student = new Student();
        if ( student.mjolnirUnlocked() == true) {
            if ( isTouching(Lightning.class))
            {

                removeTouching(Lightning.class);
                hit(75);

            }
        }
    }

}

