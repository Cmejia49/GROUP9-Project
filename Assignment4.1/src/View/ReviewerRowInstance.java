package View;
import Controller.*;
import Model.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
public class ReviewerRowInstance extends JPanel implements Observer{
    private Reviewer reviewer;
    private JButton btnEdit, btnDelete;
    private JLabel lblStudentNumber, lblName, lblProgram, lblYearLevel;
    public ReviewerRowInstance(Reviewer reviewer, ActionListener removeAction){
        this.reviewer = reviewer;
        btnDelete = new JButton("Delete");
        lblStudentNumber = new JLabel(String.valueOf(reviewer.getRestourant()));
        lblName = new JLabel(reviewer.getName());
        lblYearLevel = new JLabel(String.valueOf(reviewer.getRating()));
        lblProgram = new JLabel(reviewer.getReview());
        btnDelete.addActionListener(removeAction);
        setLayout(new GridLayout(1, 5));
        add(lblStudentNumber);
        add(lblName);
        add(lblProgram);
        add(lblYearLevel);
        add(btnDelete);
    }
    public void update(Observable obs, Object data){
        lblName.setText(reviewer.getName());
        lblProgram.setText(reviewer.getReview());
        lblYearLevel.setText(String.valueOf(reviewer.getRating()));
    }
}