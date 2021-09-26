package Controller.MainViewController;

import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;

import View.LoginView;
import View.MainView;
import Model.*;
public class AddController implements ActionListener
{
    private UserList list;
    private MainView main;
    private JFrame app;
    private User user;
    private JTextField txtUsername, txtPassword;
    private JComboBox<String> cbUserType;
    private JLabel lblCount;
    
    public AddController(UserList list,MainView main,JFrame app,User user,
    JTextField txtUsername, JTextField txtPassword,JComboBox<String> cbUserType, JLabel lblCount)
    {
        this.list = list;
        this.main = main;
        this.app = app;
        this.user = user;
        this.txtUsername = txtUsername;
        this.txtPassword = txtPassword;
        this.cbUserType = cbUserType;
        this.lblCount = lblCount;
    }


    public void actionPerformed(ActionEvent ae){
        lblCount.setText("0");
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String usertype = cbUserType.getItemAt(cbUserType.getSelectedIndex());
        int count = Integer.parseInt(lblCount.getText());
        int id = list.size()-1;
            User curr = new User(id, username, password, usertype, count);
            list.add(curr);
            JOptionPane.showMessageDialog(app, "User Added!");
  
        app.getContentPane().removeAll();
        MainView main = new MainView(curr, list, app);
        app.add(main);
        app.validate();
        app.repaint();
    }

}