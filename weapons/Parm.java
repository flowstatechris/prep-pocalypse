import greenfoot.*; 

public class Parm extends SmoothMover
{

    Student student = new Student();
    private GreenfootImage image1 = new GreenfootImage ("parm.png");
    
    public Parm()
    {
        image1.scale( 32 , 32);
        setImage(image1);
        
    }

    public Parm(Vector speed, int rotation)
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

    private void damage() // if touch a student take a heart
    {
        Student student = (Student)
            getOneIntersectingObject(Student.class);
        if (isTouching(Student.class) || isAtEdge())
        {
            
                if (isTouching(Student.class))
                {
                    student.adjustHealth(-1);

                }

                getWorld().removeObject(this);
            

        }
    }
}
