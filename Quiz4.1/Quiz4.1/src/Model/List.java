package Model;
public class List<T>
{
    private Object[] data;
    private int ptr;
    private int ind = 0;
    public List()
    {
        // default count: 10
        this(10);
    }
    public List(int count)
    {
        if(count < 1)
            count = 10;
        data = new Object[count];
        ptr = 0;
    }
    public void add(T item)
    {
        if(ptr >= data.length)
        {
            Object[] temp = new Object[data.length * 2];
            for(int i=0; i<data.length; i++)
            {
                temp[i] = data[i];
            }
            data = temp;
        }

        data[ptr] = item;
        ptr++;
        ind = ptr - 1;
    }
    public void remove(int index)
    {
        if(index >= 0 && index<ptr)
        {
            for(int i=index+1; i<ptr; i++)
            {
                data[i-1] = data[i];
            }
            ptr--;
            data[ptr] = null;
        }
    }
    public String toString()
    {
        String result = "List: [";
        for(int i=0; i<ptr; i++){
            if(i>0) 
                result += ", ";
            result += data[i];
        }
        result += "]";
        return result;
    }
    public T get(int index){
        if(index >= 0 && index < ptr)
        {
            return (T) data[index];
        }
        return null;
    }
    public void set(int index, T item)
    {
        if(index >= 0 && index < ptr){
            data[index] = item;
        }
    }
    /**
     * to get the next data to array
     * @return
     */
    public T next()
    {
        ind++;
        if(ind>=ptr){ind = 0;}
        if(ptr == 0){return null;}
        return (T)data[ind];
    }
    /**
     * to get the previous data in array
     * @return
     */
    public T prev()
    {
        ind--;
        if(ind<0){ind = ptr - 1;}
        if(ptr == 0){return null;}
        return (T) data[ind];
    }

    public int size(){ return ptr; }
}