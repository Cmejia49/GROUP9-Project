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
    public PrevController(UserList list,MainView main,JFrame app,User user,
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
    public void actionPerformed(ActionEvent ae)
    {

      
 
        User curr = list.prev();
        if(curr == null || list.size() == 1){JOptionPane.showMessageDialog(app, "no Other User!");return;}   
        txtUsername.setText(curr.getUsername());
        txtPassword.setText(curr.getPassword());
        cbUserType.setSelectedItem(curr.getUserType());
        lblCount.setText(String.valueOf(curr.getCount()));

        
        app.getContentPane().removeAll();
        app.add(main);
        app.validate();
        app.repaint();
    }
}
