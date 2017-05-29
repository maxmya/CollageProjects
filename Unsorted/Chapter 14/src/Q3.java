public class Q3
{
    public static void main(String[]args)
    {
        GeometricObject[] square = new Square[5];
        for(int i=0 ; i<5 ; i++)
            square[i] = new Square();
        
        for(int i=0 ; i<5 ; i++)
        {
            if(square[i] instanceof Colorable)
                ((Square)square[i]).howToColor();
        }
    }
}
