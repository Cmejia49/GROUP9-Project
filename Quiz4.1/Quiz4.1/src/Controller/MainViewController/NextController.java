package Controller.MainViewController;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;

import View.LoginView;
import View.MainView;
import Model.*;
public class NextController  implements ActionListener
{
    private UserList list;
    private MainView main;
    private JFrame app;
    private User user;
    public NextController(UserList list,MainView main,JFrame app,User user)
    {

        this.list = list;
        this.main = main;
        this.app = app;
        this.user = user;
  
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        
        User curr = list.next();
        if(curr == null || list.size() == 1){JOptionPane.showMessageDialog(app, "no Other User!");return;}     
        MainView main = new MainView(curr, list, app);
        app.getContentPane().removeAll();
        app.add(main);
        app.validate();
        app.repaint();
    }
}
