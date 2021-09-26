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
    private JTextField txtUsername, txtPassword;
    private JComboBox<String> cbUserType;
    private JLabel lblCount;
    public DeleteController(User user, UserList list, MainView main, JFrame app,
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
        User curr = list.next();
        if(curr == null){JOptionPane.showMessageDialog(app, "nothing left"); return;}
        list.remove(user.getId());
        txtUsername.setText(curr.getUsername());
        txtPassword.setText(curr.getPassword());
        cbUserType.setSelectedItem(curr.getUserType());
        lblCount.setText(String.valueOf(curr.getCount()));
        JOptionPane.showMessageDialog(app, "User Delete!");
        app.getContentPane().removeAll();
        MainView newMain = new MainView(user, list, app);
        app.add(newMain);
        app.validate();
        app.repaint();
    }
}
