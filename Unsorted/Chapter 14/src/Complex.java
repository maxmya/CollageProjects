public class Complex 
{
    private double real;
    private double notReal;
    
    public Complex(double a, double b)
    {
        real = a;
        notReal = b;
    }
    
    public Complex()
    {
        this(1, 1);
    }
    
    public Complex(double a)
    {
        this(a, 1);
    }
    
    public Complex add(Complex x)
    {
        double a = real + x.real;
        double b = notReal + x.notReal;
        return new Complex(a,b);
    }
    
    public Complex subtract(Complex x)
    {
        double a = real - x.real;
        double b = notReal - x.notReal;
        return new Complex(a,b);
    }
    
    public Complex multiply(Complex x)
    {
        double a = (real*x.real) - (notReal*x.notReal);
        double b = (notReal*x.real) + (real*x.notReal);
        return new Complex(a,b);
    }
    
    public Complex divide(Complex x)
    {
        double a = ((real*x.real)+(notReal*x.notReal)) 
                / ((Math.pow(x.real, 2))+Math.pow(x.notReal, 2));
        double b = ((notReal*x.real)+(real*x.notReal))
                / ((Math.pow(x.real, 2))+Math.pow(x.notReal, 2));
        return new Complex(a,b);
    }
    
    public double abs()
    {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(notReal, 2));
    }
    
    @Override
    public String toString()
    {
        if(notReal == 0)
            return Double.toString(real);
        else
            return Double.toString(real) + " + " + Double.toString(notReal)
                    + "i ";
    }
    
    public double getRealPart()
    {
        return real;
    }
    
    public double getImaginaryPart()
    {
        return notReal;
    }
}
