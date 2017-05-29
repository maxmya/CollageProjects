public class Course 
{
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;
    
    public Course(String courseName)
    {
        this.courseName = courseName;
    } 
    
    public void addStudent(String student)
    {
        if(numberOfStudents == students.length-1)
        {
            String[] s = new String[students.length*2];
            for(int i=0 ; i<=s.length ; i++)
            {
                s[i] = students[i];
            }
            students[numberOfStudents] = student;
            numberOfStudents++;
        }
        else
        {
            students[numberOfStudents] = student;
            numberOfStudents++;
        }
    }
    
    public String[] getStudents()
    {
        return this.students; 
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
        int index = 0;
        for(int i=0 ; i<=students.length; i++)
        {
            if(students[i].equals(student))
            {
                index = i;
                break;
            }  
        }
        String[] s = new String[students.length-1];
        for(int i=0 ; i<=s.length ; i++)
        {
            if(i == index)
            {
                i++;
                continue;
            }
            s[i] = students[i];
        }
        for(int i=0 ; i<=s.length ; i++)
        {
            students[i] = s[i];
        }
    }
    
    public void clear()
    {
        students = new String[100];
    }
}
