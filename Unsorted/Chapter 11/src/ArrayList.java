public class ArrayList 
{
    private Object[] elements;
    private int count = 0;
    
    public ArrayList()
    {
        elements = new Object[16];
    }
    
    public void add(Object x)
    {
        if(count == elements.length)
        {
            Object[] s = new Object[elements.length*2];
            for(int i=0 ; i<=s.length ; i++)
            {
                s[i] = elements[i];
            }
            elements = s;
            elements[count] = x;
            count++;
        }
        else
        {
            elements[count] = x;
            count++;
        }
    }
    
    public void add(int index, Object x)
    {
        Object[] s = new String[elements.length*2];
        for(int i=0 ; i<=s.length ; i++)
        {
            if(i == index)
            {
                elements[index] = x;
                i++;
            }
            else
            {
                s[i] = elements[i];
            }
        }
        elements = s;
        count++;
    }
    
    public void clear()
    {
        elements = new Object[16];
        count = 0;
    }
    
    public boolean contains(Object x)
    {
        for(int i=0 ; i<elements.length ; i++)
        {
            if(elements[i] == x)
                return true;
        }
        return false;
    }
    
    public Object get(int index)
    {
        return elements[index];
    }
    
    public int indexOf(Object x)
    {
        for(int i=0 ; i<elements.length ; i++)
        {
            if(elements[i] == x)
                return i;
        }
        return -1;
    }
    
    public boolean isEmpty()
    {
        for(int i=0 ; i<elements.length ; i++)
        {
            if(elements[i] != null)
                return false;
        }
        return true;
    }
    
    public int lastIndexOf(Object x)
    {
        for(int i=elements.length ; i>=0 ; i--)
        {
            if(elements[i] == x)
                return i;
        }
        return -1;
    }
    
    public boolean remove(Object x)
    {
        boolean done = false;
        for(int i=0 ; i<elements.length ; i++)
        {
            if(i >=indexOf(x) || done)
            {
                elements[i] = elements[i+1];
                done = true;
            }
        }
        return done;
    }
    
    public int size()
    {
        return count;
    }
    
    public boolean remove(int index)
    {
        boolean done = false;
        for(int i=0 ; i<elements.length ; i++)
        {
            if(i == index)
            {
                elements[i] = elements[i+1];
                done = true;
            }
        }
        return done;
    }
    
    public void set(int index, Object x)
    {
        for(int i=0 ; i<elements.length ; i++)
        {
            if(i == index)
                elements[index] = x;
        }
    }
}
