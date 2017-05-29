import java.util.Date;

public class Q9
{
    public static Object max(Comparable[] a)
    {
        Object max = a[0];
        for(int i=0 ; i<a.length ; i++)
        {
            if(a[i].compareTo(max) > 0)
                max = a[i];
        }
        return max;
    }
    
    public static void main(String[]args)
    {
        String[] s = new String[10];
        Integer[] n = new Integer[10];
        Date[] d = new java.util.Date[10];
        System.out.println("The largest String is " + max(s));
        System.out.println("The largest Integer is " + max(n));
        System.out.println("The largest Date is " + max(d));
    }
}
