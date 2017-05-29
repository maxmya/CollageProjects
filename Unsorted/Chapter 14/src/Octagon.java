public class Octagon extends GeometricObject implements Comparable, Cloneable
{
    private double side;
    
    public Octagon()
    {
        this(1);
    }
    
    public Octagon(double side)
    {
        this.side = side;
    }

    @Override
    public double getArea() 
    {
        return (2+(4/Math.sqrt(2.0))*side*side);
    }

    @Override
    public double getPerimeter() 
    {
        return 8*side;
    }

    @Override
    public int compareTo(Object o) 
    {
        if(((Octagon)o).side > side)
            return 1;
        else if(((Octagon)o).side < side)
            return -1;
        else
            return 0;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    
    

}
