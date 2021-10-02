package Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import Utils.*;
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
           // call SQL query for insert
           String sql = String.format(
               "INSERT INTO reviewTbl (restourant, reviewer, review, rating ) " +
               "VALUES ('%s', '%s', '%s', %d)",
               reviewer.getRestourant(),
               reviewer.getName(),
               reviewer.getReview(),
               reviewer.getRating()
           );
           // execute update and reload data to reflect changes
           DBConnection.executeUpdate(sql);
           loadData();
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
    public void clearList(){
        while(list.size()>0){
            list.remove(0);
        }
    }
    public void loadData(){
        ResultSet rs = DBConnection.executeQuery(
            "SELECT * FROM reviewTbl;"
        );
        try{
            clearList();
            while(rs.next())
            {
                String restourant = rs.getString("restourant");
                String reviewer = rs.getString("reviewer");
                String review = rs.getString("review");
                int rating = rs.getInt("rating");
            }
            reviewerListchange();
        }
        catch(NullPointerException ex){}
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
  
}
