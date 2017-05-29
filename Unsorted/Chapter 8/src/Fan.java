public class Fan 
{
       
    static final int SLOW = 1;
    static final int MEDIUM = 2;
    static final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double redius = 5;
    String color = "blue";
    
    Fan()
    {}
    
    void setSpeed(int newSpeed)
    {
        speed = newSpeed;
    }
    
    int getSpeed()
    {
        return speed;
    }
    
   void setRedius(double newRedius)
   {
        redius = newRedius;
   }
   
   double getRedius()
   {
        return redius;
   }
    
    void setOn(boolean newOn)
    {
        on = newOn;
    }
    
    boolean isOn()
    {
        return on;
    }
    
    
    public String toString()
    {
        if(on)
            return "The fan speed = " + speed + ", the color = " + color +
                    ", and the redius = " + redius ;
        else
            return "The fan color = " + color + ", the redius = " + redius 
                    + ", and fan is off";
    }
}
