package View;
import Controller.*;
import Model.*;
import javax.swing.*;
import java.awt.*;
public class ReviewerDetailView extends JPanel{
    private JTextField txtRestaurant, txtName,txtReview;
    private JRadioButton jbtnRating1,jbtnRating2,jbtnRating3,jbtnRating4,jbtnRating5;
    private JButton btnSave, btnCancel;
    private ReviewerList list;
    private Reviewer reviewer;
    private MainView main;
    private JFrame app;
    public ReviewerDetailView(Reviewer reviewer, ReviewerList list, MainView main, JFrame app){
        this.reviewer = reviewer;
        this.list = list;
        this.main = main;
        this.app = app;
        txtRestaurant = new JTextField();
        txtName = new JTextField();
        txtReview = new JTextField();

        jbtnRating1 = new JRadioButton("1");
        jbtnRating1.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnRating1.setMargin(new Insets(5, 25, 5, 25));
        jbtnRating2 = new JRadioButton("2");
        jbtnRating2.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnRating2.setMargin(new Insets(5,25, 5, 25));
        jbtnRating3 = new JRadioButton("3");
        jbtnRating3.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnRating3.setMargin(new Insets(5, 25, 5, 25));
        jbtnRating4 = new JRadioButton("4");
        jbtnRating4.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnRating4.setMargin(new Insets(5, 25, 5, 25));
        jbtnRating5 = new JRadioButton("5");
        jbtnRating5.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnRating5.setMargin(new Insets(5, 25, 5, 25));

        btnSave = new JButton("Save");
        btnCancel = new JButton("Cancel");
        
        ButtonGroup group = new ButtonGroup();
        group.add(jbtnRating1);
        group.add(jbtnRating2);
        group.add(jbtnRating3);
        group.add(jbtnRating4);
        group.add(jbtnRating5);
        JPanel radioBtnPanel = new JPanel();
        BoxLayout radioBtnLayout = new BoxLayout(radioBtnPanel, BoxLayout.X_AXIS);
        radioBtnPanel.setLayout(radioBtnLayout);
        radioBtnPanel.add(jbtnRating1); 
        radioBtnPanel.add(jbtnRating2);
        radioBtnPanel.add(jbtnRating3);
        radioBtnPanel.add(jbtnRating4);
        radioBtnPanel.add(jbtnRating5);


        JPanel pnlWest = new JPanel(new GridLayout(4,1));
        JPanel pnlCenter = new JPanel(new GridLayout(4,1));
        JPanel pnlSouth = new JPanel(new GridLayout(1,2));
      
        GridBagConstraints c = new GridBagConstraints();
        setLayout(new BorderLayout());
    
        pnlWest.add(new JLabel("Restaurant"));
        pnlWest.add(new JLabel("Reviewer"));
        pnlWest.add(new JLabel("Review"));
        pnlWest.add(new JLabel("Rating"));
        pnlCenter.add(txtRestaurant);
        pnlCenter.add(txtName);
        pnlCenter.add(txtReview);
        pnlCenter.add(radioBtnPanel);

        pnlSouth.add(btnSave);
        pnlSouth.add(btnCancel);
        add(pnlWest, "West");
        add(pnlCenter);
        add(pnlSouth, "South");

        btnSave.addActionListener(new SaveController(reviewer, list, main, app,
        txtRestaurant, txtName, txtReview, jbtnRating1,jbtnRating2,jbtnRating3,jbtnRating4,jbtnRating5));
        btnCancel.addActionListener(new CancelController(main, app));
        
    }
}