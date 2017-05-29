public class Q9 
{
    
    public static void main(String[]args)
    {
        
        Course course = new Course("course");
        course.addStudent("1");
        course.addStudent("2");
        course.addStudent("3");
        course.dropStudent("2");
        String[] students = new String[course.getNumberOfStudents()];
        for(int i=0; i<=course.getNumberOfStudents()-1 ; i++)
        {
            System.out.println(students[i]);
        }
    }
}
