package view;

import controller.Controller;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HomePageScreen {

    public HomePageScreen() {
        showHomePageMenu();
    }
    
    public void showHomePageMenu(){
        JFrame frame;
        
        frame = new JFrame("Landing Page");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        JLabel nama = new JLabel(SingletonUser.getInstance().getUser().getName());
        nama.setFont(new Font("Arial", Font.BOLD, 18));
        
        Controller con = new Controller();
        ArrayList<Todo> todo = con.getAllTodoUser();
        
        JLabel title[] = new JLabel[];
        
        JPanel panel = new JPanel(null);
        
        nama.setBounds(100, 10, 200, 30);
        
        panel.add(nama);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
