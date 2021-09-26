package Model;
import java.util.Observable;

public class User extends Observable
{
    private int id;//for right index of the user
    private String username;
    private String password;
    private String userType;
    private int count;
    public User(int id,String username, String password, String userType, int count)
    {
       this.id = id;
       this.username = username;
       this.password = password;
       this.userType = userType;
       this.count = count;
    }

    private void userChanged()
    {
        setChanged();
        notifyObservers();
    }
    public int getId(){return this.id;}
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
    public String getUserType(){return this.userType;}
    public int getCount(){return this.count;}

    public void setId(int id)
    {
        this.id = id;
        userChanged();
    }

    public void setUsername(String username)
    {
        this.username = username;
        userChanged();
    }
    
    public void setPassword(String password)
    {
        this.password = password;
        userChanged();
    }
    
    public void setUserType(String userType)
    {
        this.userType = userType;
        userChanged();
    }
    
    public void setCount(int count)
    {
        this.count = count;
        userChanged();
    }

}