package Model;
import java.util.Arrays;
import java.util.Observable;
public class ReviewerList extends Observable 
{
    private List<Reviewer> list;
    public ReviewerList() 
    {
        list = new List<Reviewer>();
    }

    public void reviewerListchange()
    {
        setChanged();
        notifyObservers();
    }

    public void add(Reviewer reviewer){
        list.add(reviewer);
        reviewerListchange();
    }
    public void remove(int index){
        list.remove(index);
        reviewerListchange();
    }
    public void set(int index, Reviewer reviewer){
        list.set(index, reviewer);
        reviewerListchange();
    }
    public Reviewer get(int index){
        return list.get(index);
    }
    public int size(){
        return list.size();
    }
    public void sort()
    {
            for(int i = 0 ;i<list.size();i++)
            {
                for(int j = 0;j<list.size();j++)
                {
                        if(get(i).getRating() > get(j).getRating())
                        {
                            Reviewer temp = get(i);
                            list.set(i, get(j));
                            list.set(j, temp);
                        }   
                }
            
            }
    }
  
}
