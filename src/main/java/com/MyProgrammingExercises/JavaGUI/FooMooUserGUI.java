package com.MyProgrammingExercises.JavaGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Ref Video: https://www.youtube.com/watch?v=iE8tZ0hn2Ws
This tutorial shows how to use the Swing Library to create a simple GUI that accepts a username and password
If the content matches "foo","moo" respectively, a success message is shown
Or else, a failure message is shown
Here, components are created directly instead of using the intellij SwingUIDesigner
 */

public class FooMooUserGUI implements ActionListener{

    // place it here so that it can be referenced in the perform method
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel label;
    private static JTextField userText;
    private static JLabel label2;
    private static JTextField pwdText;
    private static JLabel success;
    private static JButton submitBtn;


    public static void main(String[] args) {

        frame = new JFrame(); // this is the window that open
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel); // put the panel on the window

        // Configure the panel
        panel.setLayout(null); //this is related to rows and columns

        label= new JLabel("Username");
        label.setBounds(10,20,80,25);
        panel.add(label);

        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // the y value is changed to position it correctly below
        label2 = new JLabel("Password");
        label2.setBounds(10,50,80,25);
        panel.add(label2);

        pwdText = new JTextField(20);
        pwdText.setBounds(100,50,165,25);
        panel.add(pwdText);

        submitBtn = new JButton("LOGIN");
        submitBtn.setBounds(30,80,80,25);
        // addActionListener method only accepts an object of type ActionListener
        submitBtn.addActionListener(new FooMooUserGUI());
        panel.add(submitBtn);

        success = new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);

        frame.setVisible(true);
    }

    @Override // this code is run each time button is clicked
    public void actionPerformed(ActionEvent e) {
        String username = userText.getText();
        String password = pwdText.getText();
        System.out.println(username);
        System.out.println(password);
        if(username.equals("foo")&&password.equals("moo")){
            success.setText("login success!");
        }else{
            success.setText("login fail");
        }
    }
}
