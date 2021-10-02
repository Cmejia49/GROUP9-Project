package Model;
import java.util.Observable;

public class Reviewer extends Observable 
{
    private int id;
    private String restaurant;
    private String name;
    private String review;
    private int rating;

    public Reviewer(int id,String restaurant, String name, String review, int rating)
    {
      this.id = id;
       this.restaurant = restaurant;
       this.name = name;
       this.review = review;
       this.rating = rating;
       if(rating >= 1 && rating <= 5)
       {
        this.rating = rating;
       }

    }
 
    public void reviewChange()
    {
        setChanged();
        notifyObservers();
    }
    //getter
    public int getId()
    {
        return id;
    }
    public String getRestourant()
    {
        return restaurant;
    }
    public String getName()
    {
        return name;
    }
    public String getReview()
    {
        return review;
    }
    public int getRating()
    {
        return rating;
    }
    //setter
    public void setRestourant(String restaurant)
    {
      this.restaurant = restaurant; 
    }
    public void setName(String name)
    {
      this.name = name; 
    }
    public void setReview(String review)
    {
      this.review= review;
    }
    public void setRating(int rating)
    {
      this.rating= rating;
    }
}