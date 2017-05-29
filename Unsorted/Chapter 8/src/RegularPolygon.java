public class RegularPolygon
{
    
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;
    double perimeter;
    
    RegularPolygon()
    {}
    
    RegularPolygon(int newN,double newSide)
    {
        n = newN;
        side = newSide;
    }
    
    RegularPolygon(int newN,double newSide, double newX, double newY)
    {
        n = newN;
        side = newSide;
        x = newX;
        y = newY;
    }
    
    void setSide(double newSide)
    {
        side = newSide;
    }
    
    double getSide()
    {
        return side;
    }
    
    void setX(double newX)
    {
        x = newX;
    }
    
    double getX()
    {
        return x;
    }
    
    void setY(double newY)
    {
        y = newY;
    }
    
    double getY()
    {
        return y;
    }
    
    double getPerimeter()
    {
        perimeter = n*side;
        return perimeter;
    }
    
    double getArea()
    {
        return (n*Math.pow(side,2))/(4*Math.tan(perimeter/n));
    }
}
