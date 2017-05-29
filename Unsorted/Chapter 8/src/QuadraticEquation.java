public class QuadraticEquation 
{
     
    private int a;
    private int b;
    private int c;
    
    QuadraticEquation()
    {}
    
    QuadraticEquation(int newA, int newB, int newC)
    {
        a = newA;
        b = newB;
        c = newC;
    }
    
    int getA()
    {
        return a;
    }
    
    int getB()
    {
        return b;
    }
    
    int getC()
    {
        return c;
    }
    
    double getDiscriminant()
    {
        return Math.pow(b,2) - 4*a*c;
    }
    
    double getRoot1()
    {
        if(getDiscriminant() < 1)
            return 0;
        else
            return (-b + Math.sqrt(getDiscriminant())) / 2*a;
    }
    
    double getRoot2()
    {
        if(getDiscriminant() < 1)
            return 0;
        else
            return (-b - Math.sqrt(getDiscriminant())) / 2*a;    
    }
}
