import greenfoot.*; 

public class Badge extends SmoothMover
{

    
    private GreenfootImage image1;
    
    public Badge()
    {
        image1 = new GreenfootImage ("badge.png");
    
        setImage(image1);
        image1.scale( 100 , 100);
    }

    public Badge(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 10));

    }

    public void act()
    {
        move(-5);
        damage();

    }

    private void damage() // if you hit a student, cripple him by 2 hearts
    {
        Student student = (Student)
            getOneIntersectingObject(Student.class);
        if (isTouching(Student.class) || isAtEdge())
        {
            
                if (isTouching(Student.class))
                {
                    student.adjustHealth(-2);

                }

                getWorld().removeObject(this);
            

        }
    }
}
