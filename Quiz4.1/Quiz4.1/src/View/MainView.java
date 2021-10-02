package View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.MainViewController.*;
import Model.*;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
public class MainView extends JPanel implements Observer
{
    private JTextField txtUsername, txtPassword;
    private JComboBox<String> cbUserType;
    private JLabel lblCount;
    private JButton btnAdd,btnEdit,btnDelete,btnPrev,btnNxt,btnBack;
    private JFrame app;
    private UserList list;
    private User user;
    public MainView(User user , UserList list, JFrame app)
    {

        this.user = user;
        this.list = list;
        this.app = app;
        txtUsername = new JTextField();
        txtPassword = new JTextField();
        btnAdd = new JButton("Add");
        btnEdit = new JButton("Edit");
        btnDelete = new JButton("Delete");
        btnPrev = new JButton("Prev");
        btnNxt = new JButton("Nxt");
        btnBack = new JButton("Back");
        String[]userType = {"Administrator", "User"};
        cbUserType = new JComboBox<String>(userType);
        lblCount = new JLabel("0");
        txtUsername.setText(user.getUsername());
        txtPassword.setText(user.getPassword());
        cbUserType.setSelectedItem(user.getUserType());
        lblCount.setText(String.valueOf(user.getCount()));
        JPanel pnlWest = new JPanel(new GridLayout(4,1));
        JPanel pnlCenter = new JPanel(new GridLayout(4,1));
        JPanel pnlSouth = new JPanel(new GridLayout(1,6));
        setLayout(new BorderLayout());
        pnlWest.add(new JLabel("Username: "));
        pnlWest.add(new JLabel("Password: "));
        pnlWest.add(new JLabel("User Type: "));
        pnlWest.add(new JLabel("Login Count: "));
        pnlCenter.add(txtUsername);
        pnlCenter.add(txtPassword);
        pnlCenter.add(cbUserType);
        pnlCenter.add(lblCount);
        pnlSouth.add(btnAdd);
        pnlSouth.add(btnEdit);
        pnlSouth.add(btnDelete);
        pnlSouth.add(btnPrev);
        pnlSouth.add(btnNxt);
        pnlSouth.add(btnBack);
        add(pnlWest,"West");
        add(pnlCenter);
        add(pnlSouth,"South");

        btnAdd.addActionListener(new AddController(list, this, app, user, txtUsername, txtPassword, cbUserType, lblCount));
        btnEdit.addActionListener(new EditController(user,list, this, app, txtUsername, txtPassword, cbUserType, lblCount));
        btnBack.addActionListener(new BackController(new LoginView(list, app),app));
        btnPrev.addActionListener(new PrevController(list, this, app, user));
        btnNxt.addActionListener(new NextController(list, this, app, user));
        btnDelete.addActionListener(new DeleteController(user,list, this, app));
    }
    @Override
    public void update(Observable o, Object arg) 
    {
        txtUsername.setText(user.getUsername());
        txtPassword.setText(user.getPassword());
        cbUserType.setSelectedItem(user.getUserType());
        lblCount.setText(String.valueOf(user.getCount()));
        
    }



}
