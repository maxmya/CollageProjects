public class Q9 
{
    
     public static void main(String[]args)
     {
        
        RegularPolygon regularPolygon1 = new RegularPolygon();
        System.out.println("For Regular Polygon 1, The perimeter = " + 
                regularPolygon1.getPerimeter() + " and the area = " +
                regularPolygon1.getArea());
        
        RegularPolygon regularPolygon2 = new RegularPolygon(6, 4);
        System.out.println("For Regular Polygon 2, The perimeter = " + 
                regularPolygon2.getPerimeter() + " and the area = " +
                regularPolygon2.getArea());
        
        RegularPolygon regularPolygon3 = new RegularPolygon(10, 4, 5.6 ,7.8);
        System.out.println("For Regular Polygon 3, The perimeter = " + 
                regularPolygon3.getPerimeter() + " and the area = " +
                regularPolygon3.getArea());
        
    }
    
}
