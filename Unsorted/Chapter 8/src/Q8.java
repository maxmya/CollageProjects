public class Q8 
{
    
    public static void main(String[]args)
    {
        
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRedius(10);
        fan1.color = "yellow";
        fan1.setOn(true);
        System.out.println("For fan 1 " + fan1.toString());

        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRedius(5);
        fan2.setOn(false);
        System.out.println("For fan 2 " + fan2.toString());
    }
}
