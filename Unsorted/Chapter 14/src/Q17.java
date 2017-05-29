public class Q17 
{
    public static void main(String[]args)
    {
        Rational sum = new Rational();
        for(int i=1 ; i<=10 ; i++)
        {
            sum = sum.add(new Rational(i, i+1));
        }
        System.out.println("sum " + sum.toString());
    }
}
