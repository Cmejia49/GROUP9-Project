package Controller;
import Model.*;
import View.*;
import java.awt.event.*;
import javax.swing.*;
public class LoginController implements ActionListener
{
    private UserList list;
    private LoginView login;
    private JFrame app;
    private JTextField txtUsername,txtPassword;
    public LoginController(UserList list, LoginView login, JFrame app, JTextField txtUsername, JTextField txtPassword)
    {

      this.txtUsername = txtUsername;
      this.txtPassword = txtPassword;
      this.list = list;
      this.login = login;
      this.app = app;
    }
    public void actionPerformed(ActionEvent ae)
    {
      String username = txtUsername.getText();
      String password = txtPassword.getText();
      User curr = list.find(txtUsername.getText(),txtPassword.getText());
      if(curr == null){ JOptionPane.showMessageDialog(app, "Incorrect Username or Password!");return;}
          if(curr.getUsername().equals(username) && curr.getPassword().equals(password) && curr.getUserType().equals("Administrator"))
          {
            curr.setCount(curr.getCount()+1);
            app.getContentPane().removeAll();
            MainView main = new MainView(curr,list, app);
            txtUsername.setText("");
            txtPassword.setText("");
            app.add(main);
            app.validate();
            app.repaint();   
          }else if(curr.getUsername().equals(username) && curr.getPassword().equals(password)&& curr.getUserType().equals("User"))
          {
            JOptionPane.showMessageDialog(app, "Login Success Only Administrator can procced");
          }
    }    
}
