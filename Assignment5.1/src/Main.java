import Model.*;
import Controller.*;
import View.*;

import javax.swing.*;
public class Main extends JFrame{
    public Main(){
        ReviewerList list = new ReviewerList();
        MainView main = new MainView(list, this);
        AddController addAction = new AddController(list, main, this);
        main.setAddAction(addAction);
        list.addObserver(main);
        list.loadData();
        add(main);
    }

    public static void main(String[]args){
        JFrame app = new Main();
        app.setTitle("Restaurant Reviewer");
        app.setVisible(true);
        app.setSize(500, 200);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}