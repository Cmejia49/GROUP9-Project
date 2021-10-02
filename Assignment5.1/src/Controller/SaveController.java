package Controller;
import Model.*;
import View.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SaveController implements ActionListener{
    private ReviewerList list;
    private MainView main;
    private JFrame app;
    private Reviewer reviewer;
    private JTextField txtRestaurant,txtName,txtReview;
    private JRadioButton jbtnRating1,jbtnRating2,jbtnRating3,jbtnRating4,jbtnRating5;
    public SaveController(Reviewer reviewer, ReviewerList list, MainView main, JFrame app,
        JTextField txtRestaurant, JTextField txtName, JTextField txtReview, JRadioButton jbtnRating1, 
        JRadioButton jbtnRating2,JRadioButton jbtnRating3,JRadioButton jbtnRating4,JRadioButton jbtnRating5 ){
            this.reviewer = reviewer;
            this.list = list;
            this.main = main;
            this.app = app;
        this.txtRestaurant = txtRestaurant;
        this.txtName= txtName;
        this.txtReview = txtReview;
        this.jbtnRating1 = jbtnRating1;
        this.jbtnRating2 = jbtnRating2;
        this.jbtnRating3 = jbtnRating3;
        this.jbtnRating4 = jbtnRating4;
        this.jbtnRating5 = jbtnRating5;
    }
    public void actionPerformed(ActionEvent ae){
        String restaurant = txtRestaurant.getText();
        String name = txtName.getText();
        String review = txtReview.getText();
        int rating = 0;
        if(jbtnRating1.isSelected()){ rating = Integer.parseInt(jbtnRating1.getText());}
        if(jbtnRating2.isSelected()){ rating = Integer.parseInt(jbtnRating2.getText());}
        if(jbtnRating3.isSelected()){ rating = Integer.parseInt(jbtnRating3.getText());}
        if(jbtnRating4.isSelected()){ rating = Integer.parseInt(jbtnRating4.getText());}
        if(jbtnRating5.isSelected()){ rating = Integer.parseInt(jbtnRating5.getText());}
        if(reviewer == null){
            Reviewer curr = new Reviewer(restaurant, name, review, rating);
            list.add(curr);
            JOptionPane.showMessageDialog(app, "Student Added!");
        }else{
            reviewer.setRestourant(restaurant);
            reviewer.setName(name);
            reviewer.setReview(review);
            JOptionPane.showMessageDialog(app, "Student Data Updated!");
        }
        app.getContentPane().removeAll();
        app.add(main);
        app.validate();
        app.repaint();
    }
}