package Controller;
import Model.*;
import View.*;
import java.awt.event.*;
public class RemoveController implements ActionListener{
    private ReviewerList list;
    private int index;
    public RemoveController(ReviewerList list, int index){
        this.list = list;
        this.index = index;
    }
    public void actionPerformed(ActionEvent ae){
        list.remove(index);
    }
}