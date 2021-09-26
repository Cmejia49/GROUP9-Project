package View;
import Controller.*;
import Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class MainView extends JPanel implements Observer{
    private JPanel tblData;
    private JButton btnAdd;
    private ReviewerList list;
    private JFrame app;
    public MainView(ReviewerList list, JFrame app){
        this.list = list;
        this.app = app;
        JPanel tblHeader = new JPanel(new GridLayout(1, 5));
        tblHeader.add(new JLabel("Restaurant", JLabel.CENTER));
        tblHeader.add(new JLabel("Reviewer", JLabel.CENTER));
        tblHeader.add(new JLabel("Review", JLabel.CENTER));
        tblHeader.add(new JLabel("Ratinng", JLabel.CENTER));
        tblHeader.add(new JLabel("Actions", JLabel.CENTER));
        setLayout(new BorderLayout());
        btnAdd = new JButton("Add");
        tblData = new JPanel();
        add(tblHeader, "North");
        add(btnAdd, "South");
        add(tblData);
    }
    public void update(Observable obs, Object data){
        tblData.removeAll();
        int listSize = list.size();
        tblData.setLayout(new GridLayout(listSize, 1));
        list.sort();
        for(int i=0; i<listSize; i++){
            Reviewer reviewer= list.get(i);
            RemoveController removeAction = new RemoveController(list, i);
            ReviewerRowInstance curr = new ReviewerRowInstance(reviewer, removeAction);
            reviewer.addObserver(curr);
            tblData.add(curr);
        }
        tblData.validate();
        tblData.repaint();
    }
    public void setAddAction(ActionListener addAction){
        btnAdd.addActionListener(addAction);
    }
}