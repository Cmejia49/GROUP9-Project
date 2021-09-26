package View;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ClearController;
import Controller.LoginController;
import Model.User;
import Model.UserList;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class LoginView extends JPanel implements Observer
{

    private JTextField txtUsername,txtPassword;
    private JButton btnLogin,btnClear;
    private UserList list;
    private JFrame app;
    private int size;
    public LoginView(UserList list, JFrame app) {
        txtUsername = new JTextField();
        txtPassword = new JTextField();
        this.list = list;
        btnLogin = new JButton("Login");
        btnClear = new JButton("Clear");
        JPanel pnlWest = new JPanel(new GridLayout(2, 1));
        JPanel pnlCenter = new JPanel(new GridLayout(2,1));
        JPanel pnlSouth = new JPanel(new GridLayout(1,2));
        setLayout(new BorderLayout());
        pnlWest.add(new JLabel("Username: "));
        pnlWest.add(new JLabel("Password: "));
        pnlCenter.add(txtUsername);
        pnlCenter.add(txtPassword);
        pnlSouth.add(btnLogin);
        pnlSouth.add(btnClear);
        add(pnlWest,"West");
        add(pnlCenter);
        add(pnlSouth,"South");
        btnLogin.addActionListener(new LoginController(list, this, app, txtUsername, txtPassword));
        btnClear.addActionListener(new ClearController( this, app, txtUsername, txtPassword));
    }
    @Override
    public void update(Observable o, Object arg) 
    {
       //dont' know how to user
    }
    public void setClearAction(ActionListener clearAction)
    {
        btnClear.addActionListener(clearAction);
    }
 

}