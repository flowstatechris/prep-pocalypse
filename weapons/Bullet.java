import greenfoot.*; 

public class Bullet extends SmoothMover
{
    /** The damage this bullet will deal */
    private static final int damage = 23;
    private GreenfootImage image1 = new GreenfootImage("bullet.png");
    private  GreenfootSound music =  new GreenfootSound("shot.wav");
    public Bullet()
    {
        setImage(image1);
        
    }

    public Bullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 12));
        
    }

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
    
    