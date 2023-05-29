import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonClickerGUI implements ActionListener{

    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public ButtonClickerGUI() {

        frame = new JFrame(); //The frame is the basic window 

        JButton button = new JButton("Click Me"); //Creating a button for the frame 
        button.addActionListener(this); //"this" means it goes to the GUI class
        //Action listener allows for counting number of clicks on the button 

        label = new JLabel("Number of clicks: 0"); //Creating a label for the frame 

        panel = new JPanel(); //Panel allows for layout(something in the window ) to be placed 
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30,10, 30)); //Creates an invisible border(the dimensions of the frame) that can be expanded
        panel.setLayout(new GridLayout(0, 1)); //Creates a layout with the number of rows and columns 
        panel.add(button); //Adding a button to the frame 
        panel.add(label); //Adding a label to the frame 

        //The statements below are for setting up the frame 
        frame.add(panel, BorderLayout.CENTER); //Adding the panel to the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closing the frame at the end of running
        frame.setTitle("My GUI"); //Adding title to the frame
        frame.pack(); //Set to match certain size
        frame.setVisible(true); //Make sure it is visible

    }
    //A gui is anything with buttons or colors like Discord or Google  
    public static void main(String[] args) {

        
        new ButtonClickerGUI(); //Constructer in the main method that runs the code 
        //All the code above was to implement the constructor and it is just being called here to run 
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number Of Clicks: " + count);

    }
}