import greenfoot.*; 

public class Bell extends SmoothMover
{

    Student student = new Student();
    private GreenfootImage image1 = new GreenfootImage ("bell.png");
    
    public Bell()
    {
        setImage(image1);
        image1.scale( 24, 24);
    }

    public Bell(Vector speed, int rotation)
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

    private void damage() // if hit a student, take 2 hearts
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
