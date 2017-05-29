public class Q11 
{

    public static void main(String[]args)
    {
        
        Circle2D c1 = (new Circle2D(2, 2, 5.5));
        System.out.println("The area of this circle = " + c1.getArea());
        System.out.println("The perimeter of this circle = "
            + c1.getPerimeter());
        System.out.println("The point (3,3) is inside the circle ?"
            + c1.contains(3, 3));
        System.out.println("The circle (4, 5 , 10.5) is inside the circle ?"
            + c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println("The circle (3, 5 , 2.3) is overlaps the circle ?"
            + c1.overlaps(new Circle2D(3, 5, 2.3)));
   }
}
