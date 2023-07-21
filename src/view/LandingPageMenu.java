package view;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LandingPageMenu {
    public LandingPageMenu(){
        showLandingPage();
    }
    
    public void showLandingPage(){
        JFrame frame;
        JButton loginButton;
        JButton registerButton;
        
        frame = new JFrame("Landing Page");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginScreen();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new RegisterScreen();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        frame.getContentPane().add(buttonPanel);

        frame.setVisible(true);
    }
    
}
