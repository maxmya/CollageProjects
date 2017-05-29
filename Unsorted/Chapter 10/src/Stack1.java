public class Stack1 
{
    Object[] elements;
    private int size;
    static final int DefaultCapacity = 16;
    
    Stack1()
    {
        elements = new Object[DefaultCapacity];
    }
    
    public Stack1(int capacity) 
    {
        elements = new Object[capacity];
    }
    
    public void push(Object value) 
    {
        if (size >= elements.length) 
        {
            Object[] temp = new Object[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        
        elements[size++] = value;
    }
    
    public Object pop() 
    {
        return elements[--size];
    }
    
    public Object peek()
    {
        return elements[size - 1];
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
