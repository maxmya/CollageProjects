public class Square extends GeometricObject implements Colorable
{
    private double side;
    
    public Square()
    {
        this(1);
    }
    
    public Square(double side)
    {
        this.side = side;
    }
    
    @Override
    public void howToColor()
    {
        System.out.println("Color all four sides");
    }
    
    @Override
    public double getPerimeter()
    {
        return side*4;
    }
    
    @Override
    public double getArea()
    {
        return Math.pow(side, 2);
    }
}
