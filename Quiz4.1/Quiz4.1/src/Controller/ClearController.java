package Controller;
import View.*;
import java.awt.event.*;
import javax.swing.*;
public class ClearController implements ActionListener
{    
    private LoginView login;
    private JFrame app;
    private JTextField txtUsername,txtPassword;
    public ClearController(LoginView login, JFrame app, JTextField txtUsername, JTextField txtPassword)
    {
    
        this.txtUsername = txtUsername;
        this.txtPassword = txtPassword;
        this.login = login;
        this.app = app;
    }

    public void actionPerformed(ActionEvent ae)
    {       
        txtUsername.setText("");
        txtPassword.setText("");
        app.repaint();
    }
}
