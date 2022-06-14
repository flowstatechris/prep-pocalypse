import greenfoot.*; 


public class BoltBullet extends SmoothMover
{
    /** The damage this bullet will deal */
    private static final int damage = 90;
    private GreenfootImage image1 = new GreenfootImage("sniperbullet.png");
    
    public BoltBullet()
    {
        
        
    }

    public BoltBullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 18));

    }
/* for all projectiles either used by enemies or the play are utilizing the asteroids
 * bullet class, which requires vector for speed, angle, and direction
 */
    
    public void act()
    {
        move();
        checkEnemyHit();
    }
    private void checkEnemyHit() //check if hitting an enemy
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
