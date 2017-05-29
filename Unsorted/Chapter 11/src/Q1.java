public class Q1 
{
    public static void main(String[]args)
    {
        Triangle tri = new Triangle(1.0, 1.5, 1.0);
        tri.setColor("yellow");
        tri.setFilled(true);
        System.out.println("the area = " + tri.getArea() + 
                ", the perimeter = " + tri.getPerimeter() +
                ", the color is " + tri.getColor() +
                ", and is it filled " + tri.isFilled());
    }
}
