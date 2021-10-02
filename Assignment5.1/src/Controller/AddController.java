package Controller;
import Model.*;
import View.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddController implements ActionListener{
    private ReviewerList list;
    private MainView main;
    private JFrame app;
    public AddController(ReviewerList list, MainView main, JFrame app){
        this.list = list;
        this.main = main;
        this.app = app;
    }
    public void actionPerformed(ActionEvent ae){
        app.getContentPane().removeAll();
        ReviewerDetailView detailView = new ReviewerDetailView(null, list, main, app);
        app.add(detailView);
        app.validate();
        app.repaint();
    }
}