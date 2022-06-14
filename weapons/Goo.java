import greenfoot.*; 

public class Goo extends SmoothMover
{

    Student student = new Student();
    private GreenfootImage image1 = new GreenfootImage ("goo.png");
    
    public Goo()
    {
        setImage(image1);

    }

    public Goo(Vector speed, int rotation)
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

    private void damage() // if touching a student , take a heart
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