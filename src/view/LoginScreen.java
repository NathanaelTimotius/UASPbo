package view;


import controller.Controller;
import model.User;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LoginScreen {

    public LoginScreen() {
        showLoginMenu();
    }

    public void showLoginMenu() {
        JFrame frame;
        JTextField emailField;
        JPasswordField passwordField;
        JButton loginButton;
        JButton backButton;

        frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        emailLabel.setBounds(100, 10, 200, 30);
        passwordLabel.setBounds(10, 40, 200, 30);
        
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        backButton = new JButton("Back");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (verifyLogin(email, password)) {
                    JOptionPane.showMessageDialog(frame, "Login Success.");
                    frame.dispose();
                    new HomePageScreen();
                } else {
                    JOptionPane.showMessageDialog(frame, "Login failed. email or password is wrong");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LandingPageMenu();
            }
        });
        JPanel panel = new JPanel(null);
        
        emailLabel.setBounds(20, 30, 80, 25);
        emailField.setBounds(100, 30, 150, 25);
        passwordLabel.setBounds(20, 60, 80, 25);
        passwordField.setBounds(100, 60, 150, 25);
        loginButton.setBounds(40, 100, 100, 25);
        backButton.setBounds(160, 100, 100, 25);

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(backButton);

        
        frame.add(panel);

        frame.setVisible(true);
    }
    
    private boolean verifyLogin(String email, String password) {
        Controller con = new Controller();
        ArrayList<User> users = con.getAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

}
