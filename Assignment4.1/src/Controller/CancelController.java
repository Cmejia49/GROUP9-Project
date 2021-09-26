package Controller;
import View.*;
import java.awt.event.*;
import javax.swing.*;
public class CancelController implements ActionListener{
    private MainView main;
    private JFrame app;
    public CancelController(MainView main, JFrame app){
        this.main = main;
        this.app = app;
    }
    public void actionPerformed(ActionEvent ae){
        app.getContentPane().removeAll();
        app.add(main);
        app.validate();
        app.repaint();
    }
}