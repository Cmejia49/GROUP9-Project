package Controller.MainViewController;

import View.LoginView;
import java.awt.event.*;
import javax.swing.*;
public class BackController implements ActionListener
{
    private LoginView login;
    private JFrame app;
    public BackController(LoginView login,JFrame app)
    {
       this.login = login;
       this.app = app;
    }    
    public void actionPerformed(ActionEvent ea)
    {
        app.getContentPane().removeAll();
        app.add(login);
        app.validate();
        app.repaint();
    }
}
