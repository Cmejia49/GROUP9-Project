import javax.swing.JFrame;
import Model.*;
import View.*;
public class App extends JFrame
{
    public App()
    {
        UserList list = new UserList();
        LoginView login = new LoginView(list,this);
        list.add(new User(0,"user", "pass", "Administrator", 1));
        list.addObserver(login);
        add(login);
    }
    public static void main(String[] args) throws Exception {
        JFrame app = new App();
        app.setVisible(true);
        app.setSize(500, 250);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
