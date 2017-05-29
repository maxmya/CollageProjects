public class Course 
{
    
    private String courseName;
    private java.util.ArrayList students = new java.util.ArrayList();
    private int numberOfStudents;
    
    public Course(String courseName)
    {
        this.courseName = courseName;
    } 
    
    public void addStudent(String student)
    {
        students.add(student);
        numberOfStudents = students.size();
    }
    
    public String getStudents()
    {
        
        return students.toString(); 
    }
    
    public int getNumberOfStudents()
    {
        return this.numberOfStudents; 
    }
    
    public String getCourseName()
    {
        return this.courseName;
    }
    
    public void dropStudent(String student)
    {
        students.remove(student);
    }
    
    public void clear()
    {
        students = new java.util.ArrayList();
    }
}
