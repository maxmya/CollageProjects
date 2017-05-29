import java.math.BigInteger;
public class Q15 
{
    /*static boolean[] isComposite;
    static void sieve(int n)
    {
        isComposite = new boolean[n+1];
        isComposite[0] = true;
        isComposite[1] = true;
        for(int i=2 ; i*i<=n ; i++)
        {
            if(!isComposite[i])
                for(int j=i*i ; j<=n ; j+=i)
                    isComposite[j] = true;
        }
    }*/
        
    static java.math.BigInteger isMersenne(int n)
    {
        BigInteger x = new BigInteger("2");
        return x.pow(n).subtract(new BigInteger("1"));
    }
    
    public static void main(String[]args)
    {
        //sieve(100000000);
        System.out.println("p    2^p-1");
        for(int i=2 ; i<=100 ; i++)
        {
            if(isMersenne(i).isProbablePrime(100))
            {
                System.out.println(i + "    " + isMersenne(i));
            }
        }
    }
}
