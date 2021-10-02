package Controller.MainViewController;

import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;

import View.LoginView;
import View.MainView;
import Model.*;
public class PrevController implements ActionListener
{
    private UserList list;
    private MainView main;
    private JFrame app;
    private User user;
    private JTextField txtUsername, txtPassword;
    private JComboBox<String> cbUserType;
    private JLabel lblCount;
    public PrevController(UserList list,MainView main,JFrame app,User user)
    {
        this.list = list;
        this.main = main;
        this.app = app;
        this.user = user;
    }
    public void actionPerformed(ActionEvent ae)
    {

      
 
        User curr = list.prev();
        if(curr == null || list.size() == 1){JOptionPane.showMessageDialog(app, "no Other User!");return;}   

        MainView main = new MainView(curr, list, app);
        app.getContentPane().removeAll();
        app.add(main);
        app.validate();
        app.repaint();
    }
}
