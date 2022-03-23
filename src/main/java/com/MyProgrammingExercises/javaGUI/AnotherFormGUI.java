package com.MyProgrammingExercises.javaGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnotherFormGUI extends JFrame {
    private JTextField usernameText;
    private JPasswordField passwordField1;
    private JButton submitButton;
    private JLabel displayMsg;
    private JPanel myJPanel;

    public static void main(String[] args) {

        AnotherFormGUI thisForm = new AnotherFormGUI();
        thisForm.setContentPane(thisForm.myJPanel);
        thisForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisForm.setVisible(true);

        thisForm.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisForm.displayMsg.setText(thisForm.usernameText.getText() + " has entered password "
                        +thisForm.passwordField1.getText());
            }
        });
    } // END MAIN METHOD

}
