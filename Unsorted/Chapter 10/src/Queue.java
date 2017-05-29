public class Queue
{
    private String[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;
    
    public Queue() 
    {
        this(DEFAULT_CAPACITY);
    }
    
    public Queue(int capacity) 
    {
        elements = new String[capacity];
    }
    
    public void Insert(String value) 
    {
        if (size >= elements.length) 
        {
            String[] temp = new String[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        
        elements[size++] = value;
    }
    
    public String Remove() 
    {
        String botton = elements[0];
        for(int i=1 ; i<=elements.length-1 ; i++)
        {
            elements[i-1] = elements[i];
        }
        size--;
        return botton;
    }
    
    public String Examine()
    {
        return elements[0];
    }
    
    public boolean empty() 
    {
        return size == 0;
    }
    
    public int getSize() 
    {
        return size;
    }
}