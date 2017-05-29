public class TestStack 
{
    public static void main(String[]args)
    {
        Stack1 elements = new Stack1(5);
        for(int i=0 ; i<=4 ; i++)
        {
            elements.push(i+1);
        }
        
        for(int i=0 ; i<=4 ; i++)
        {
            System.out.println(elements.pop());
        }
    }
}
