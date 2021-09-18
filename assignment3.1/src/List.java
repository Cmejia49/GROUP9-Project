public class List<E> {
    private Object[] items;
    private int ptr;
    public List(){
        items = new Object[2];
        ptr = 0;
    }
    public void add(E o){
        int limit=items.length;
        if(ptr==limit){
            Object[] temp = new Object[limit];
            for(int i=0; i<limit; i++){
                temp[i] = items[i];
            }
            items = temp;
        }
        items[ptr++] = o;
    }


    public E get(int index){
        try{
            return (E) items[index];
        }catch(ArrayIndexOutOfBoundsException ex){
            return null;
        }
    }

    public Object[] getList()
    {
        try{
            return this.items;
        }catch(Exception  e){
            return null;
        }
    }

    @Override
    public String toString(){
        String conv = "<List Employee=[";
        if(ptr>0){
            conv += items[0].toString();
        }
        for(int i=1; i<ptr; i++){
            conv += ", " + items[i].toString();
        }
        conv += "]>";
        return conv;
    }
}
