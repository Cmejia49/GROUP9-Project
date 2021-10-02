package Controller.MainViewController;

import View.*;
import Model.*;
import java.awt.event.*;

import javax.swing.*;
public class DeleteController implements ActionListener
{
    private UserList list;
    private MainView main;
    private JFrame app;
    private User user;
    public DeleteController(User user, UserList list, MainView main, JFrame app)
    {
        this.list = list;
        this.main = main;
        this.app = app;
        this.user = user;
    }
    public void actionPerformed(ActionEvent ae)
    {
        User curr = list.next();
        if(curr == null){JOptionPane.showMessageDialog(app, "nothing left"); return;}
        list.remove(user.getId());
        JOptionPane.showMessageDialog(app, "User Delete!");
        app.getContentPane().removeAll();
        MainView main = new MainView(curr, list, app);
        app.add(main);
        app.validate();
        app.repaint();
    }
}
