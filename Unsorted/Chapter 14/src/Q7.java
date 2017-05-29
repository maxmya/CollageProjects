public class Q7 
{
    public static void main(String[]args) throws CloneNotSupportedException
    {
        Octagon octa = new Octagon(5.0);
        System.out.println("Ther Area = " + octa.getArea() + 
                ", and the perimeter = " + octa.getPerimeter());
        Octagon octa1 = (Octagon)octa.clone();
        System.out.println(octa.compareTo(octa1));
    }

}
