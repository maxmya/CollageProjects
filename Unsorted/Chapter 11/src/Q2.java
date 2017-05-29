public class Q2
{
    public static void main(String[]args)
    {
        Person p = new Person();
        Student s = new Student();
        Employee e = new Employee();
        Faculty f = new Faculty();
        Staff st = new Staff();
        
        System.out.println(p.toString() + s.toString() + e.toString()
                + " \n" +f.toString() + st.toString());
    }

}
