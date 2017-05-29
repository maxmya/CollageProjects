public class MyInteger 
{
    private int value;
    
    MyInteger()
    {}
    
    MyInteger(int value)
    {
        this.value = value;
    }
    
    int getValue()
    {
        return this.value;
    }
    
    boolean isEven()
    {
        return this.value%2 == 0;
    }
    
    boolean isOdd()
    {
        return this.value%2 != 0;
    }
    
    boolean isPrime()
    {
        if (this.value % 2 == 0)
            return false;
        for (int i=3; i<=this.value/2 ; i+=2)
            if (this.value % i == 0) return false;
        return true;
    }
    
    static boolean isEven(int no)
    {
        return no%2 == 0;
    }
    
    static boolean isOdd(int no)
    {
        return no%2 != 0;
    }
    
    static boolean isPrime(int no)
    {
        if (no%2 == 0)
            return false;
        for (int i=3; i<=no/2 ; i+=2)
        {
            if(no % i == 0) 
                return false;
        }
        return true;
    }
    
    static boolean isEven(MyInteger x)
    {
        return x.getValue()%2 == 0;
    }
    
    static boolean isOdd(MyInteger x)
    {
        return x.getValue()%2 != 0;
    }
    
    static boolean isPrime(MyInteger x)
    {
        if (x.getValue()%2 == 0)
            return false;
        for (int i=3; i<=x.getValue()/2 ; i+=2)
        {
            if(x.getValue()%i == 0) 
                return false;
        }
        return true;
    }
    
    boolean equals(int no)
    {
        return no == this.value;
    }
    
    boolean equals(MyInteger x)
    {
        return x.getValue() == this.value;
    }
    
    static int parseInt(char[] x)
    {
        return Integer.parseInt(String.valueOf(x));
    }
    
    static int parseInt(String x)
    {
        return Integer.parseInt(String.valueOf(x));
    }
}
