public class Circle2D 
{
    
    private double x;
    private double y;
    private double radius;
    
    double getX()
    {
        return this.x;
    }
    
    double getY()
    {
        return this.y;
    }
    
    double getRadius()
    {
        return this.radius;
    }
    
    Circle2D()
    {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }
    
    Circle2D(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    double getArea()
    {
        return Math.PI*Math.pow(this.radius,2);
    }
    
    double getPerimeter()
    {
        return 2*Math.PI*this.radius;
    }
    
    boolean contains(double x, double y)
    {
        return Math.pow(x-this.x, 2)+Math.pow(y-this.y, 2)
                < Math.pow(this.radius, 2);
    }
    
    boolean contains(Circle2D circle)
    {
        return circle.radius+Math.sqrt(Math.pow(this.x-circle.getX(),2)
                +Math.pow(this.y-circle.getY(),2)) < this.radius;
    }
    
    boolean overlaps(Circle2D circle)
    {
        return true;
    }
}
