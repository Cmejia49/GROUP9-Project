package Controller.MainViewController;
import Model.*;
import View.*;
import java.awt.event.*;
import javax.swing.*;
public class EditController implements ActionListener
{
    private UserList list;
    private MainView main;
    private JFrame app;
    private User user;
    private JTextField txtUsername, txtPassword;
    private JComboBox<String> cbUserType;
    private JLabel lblCount;
    public EditController(User user, UserList list, MainView main, JFrame app,
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
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String userType = cbUserType.getItemAt(cbUserType.getSelectedIndex());
        int count = Integer.parseInt(lblCount.getText());
        user.setUsername(username);
        user.setPassword(password);
        user.setUserType(userType);
        user.setCount(count);
        app.getContentPane().removeAll();
        MainView newMain = new MainView(user, list, app);
        app.add(newMain);
        app.validate();
        app.repaint();
    }
    
}
