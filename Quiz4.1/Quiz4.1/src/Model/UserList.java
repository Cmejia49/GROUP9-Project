package Model;
import java.util.Observable;

public class UserList extends Observable
{
    private List<User> list;
    private int ind = 0;
    public UserList()
    {
        list = new List<User>();
    }
    private void userListChanged()
    {
        setChanged();
        notifyObservers();
    }
    public void add(User user)
    {
        list.add(user);
        userListChanged();
    }
    public void remove(int index)
    {
        list.remove(index);
        userListChanged();
    }
    public void set(int index, User user)
    {
        list.set(index, user);
        userListChanged();
    }
    public User get(int index)
    {
        return list.get(index);
    }
    public int size()
    {
        return list.size();
    }
    public User next()
    {
        return list.next();
    }
    public User prev()
    {
        
      return list.prev();
    }
    /**
     * to validate username and password to log in
     * @param username
     * @param password
     * @return
     */
    public User find(String username, String password)
    {
        for(int i = 0 ; i< list.size();i++)
        {
          User curr = get(i);
          if(curr.getUsername().equals(username) && curr.getPassword().equals(password))
          {
              return curr;          
          }
        }
        return null;
    }
}
