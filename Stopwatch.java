
/********************************************************************************************************************
 * Patrick's Stopwatch Application
 * Patrick Czermak - 040389514
 * Course: Java Application Programming CST8221_303
 * Assignment: Lab 2
 * Due: Sunday, February 14, 2021
 * Submitted: Sunday, February 14, 2021
 * Purpose: The purpose of this GUI is to display to the screen a stopwatch application. It consists of 
 *          3 buttons, 3 labels, and 3 text fields. Upon display the stop button is disabled. Once the user 
 *          clicks the start button, the time in milliseconds is displayed in the start text field and the stop
 *          button becomes enabled. Once the stop button is clicked, the time in milliseconds is displayed 
 *          in the stop text field and the start button becomes disabled, additionally the elapsed time ( or the 
 *          difference in time ) is shown in the elapsed text field. When the exit button is selected, the program
 *          terminates. also when the X in the top right corner of the GUI is selected, the program terminates also.
 *******************************************************************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* Class which creates the GUI frame, sets all the variables and properties of each element inside the application and 
 * makes it visible to the screen and terminate the program */
public class Stopwatch extends JFrame {

    /* class declarations (3xButtons and 3xTextFields) */
    JButton startButton;
    JButton stopButton;
    JButton exitButton;
    JTextField startTextField;
    JTextField stopTextField;
    JTextField elapsedTextField;
    public long startTime; /* variable to be able to reset actual startTime */

    /* main */
    public static void main(String args[]) {
        /* Construct the frame and make it visible on the screen */
        new Stopwatch().setVisible(true);
        

    } /* end main */  

    /* Frame constructor */
    public Stopwatch() {
        setTitle("Patrick's Stopwatch Application");
        /* setSize(300, 100); //USED IN LAB1 */
        getContentPane().setLayout(new GridBagLayout()); 
        GridBagConstraints position = new GridBagConstraints(); /* googled */
        
        /* Initializing all Buttons, Labels, and TextFields */
        startButton = new JButton();
        startButton.setText("Start Button");
        position.gridx = 0;
        position.gridy = 0;
        add(startButton, position);

        stopButton = new JButton();
        stopButton.setText("Stop Button");
        position.gridx = 0;
        position.gridy = 1;
        add(stopButton, position);
        stopButton.setEnabled(false);

        exitButton = new JButton();
        exitButton.setText("Exit Button");
        position.gridx = 0;
        position.gridy = 2;
        add(exitButton, position);

        JLabel startLabel = new JLabel();
        startLabel.setText("Start Time:");
        position.gridx = 1;
        position.gridy = 0;
        add(startLabel, position);

        JLabel stopLabel = new JLabel();
        stopLabel.setText("Stop Time:");
        position.gridx = 1;
        position.gridy = 1;
        add(stopLabel, position);

        JLabel elapsedLabel = new JLabel();
        elapsedLabel.setText("Total Time:");
        position.gridx = 1;
        position.gridy = 2;
        add(elapsedLabel, position);

        startTextField = new JTextField();
        position.gridx = 2;
        position.gridy = 0;
        startTextField.setColumns(10);
        add(startTextField, position);

        stopTextField = new JTextField();
        position.gridx = 2;
        position.gridy = 1;
        stopTextField.setColumns(10);
        add(stopTextField, position);

        elapsedTextField = new JTextField();
        position.gridx = 2;
        position.gridy = 2;
        elapsedTextField.setColumns(10);
        elapsedTextField.setLocation(2, 2);
        add(elapsedTextField, position);

        pack(); /* fit everything in nicely :) */

        setupListeners(); /* call method which holds action listeners */

        /* Window Listener - when top right X clicked, this happens */
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(EXIT_ON_CLOSE); /* close+stop program */

            }
        });
    } /* end constructor */
    
/* setupListeners method holds ActionListeners for functionality of Start/Stop/Exit Buttons */
    private void setupListeners() {
        /* start button event (enable stop button and display start time in milliseconds) */
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTime = System.currentTimeMillis(); /* START TIME - generated first */
                startTextField.setText("" + startTime); 
                stopButton.setEnabled(true);
                startButton.setEnabled(false);
                /* ensure stop and elapsed text fields set to blank */
                stopTextField.setText("");
                elapsedTextField.setText("");
            }
        });
        /* stop button event (enable start button again, display stop time in milliseconds and display elapsed/difference in start/stop time) */ 
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long stopTime = System.currentTimeMillis(); /* STOP TIME - generated second */ 
                stopTextField.setText("" + stopTime); 
                elapsedTextField.setText("" + (stopTime - startTime)); /* ELAPSED TIME - difference of start/stop */
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
            }
        });
        /* exit button event (stop and close running GUI) */ 
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE); /* close+stop program */
            }
        });
    } /* end setupListeners method */  
} /* end class */ 

