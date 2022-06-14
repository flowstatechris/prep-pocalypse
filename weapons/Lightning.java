import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Egg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lightning extends SmoothMover

{
    private GreenfootImage image1;
    private int damage = 200;
    public Lightning()
    {
        image1 = new GreenfootImage ("egg.png");
        setImage(image1);
        
    }
       public Lightning(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 35));

    }

    /**
     * The bullet will damage asteroids if it hits them.
     */
    public void act()
    {
        move();
        checkEnemyHit();
    }
    private void checkEnemyHit() // check if hitting an enemy
    {
        Robot robot = (Robot) 
        getOneIntersectingObject(Robot.class);
        Sageworker sage = (Sageworker)
        getOneIntersectingObject(Sageworker.class);
        Spire spire = (Spire)  
        getOneIntersectingObject(Spire.class);
        MrBen ben = (MrBen)
        getOneIntersectingObject(MrBen.class);
        if(robot != null || isAtEdge() || sage != null || spire != null || ben != null)
        {
            if(robot != null)
            {
                robot.hit(damage);
            }
            if (sage != null)
            {
                sage.hit(damage);
            }
            if (spire != null)
            {
                spire.hit(damage);
                
            }
            if ( ben != null)
            {
                ben.hit(damage);
                
            }
            getWorld().removeObject(this);
            

        }
    }
}
