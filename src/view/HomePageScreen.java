package view;

import model.SingletonUser;
import controller.Controller;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Todo;


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
        ArrayList<Todo> todoList = con.getAllTodoUser(SingletonUser.getInstance().getIdUser());
        
        JLabel title[] = new JLabel[todoList.size()];
        JLabel note[] = new JLabel[todoList.size()];
        for (int i = 0; i < todoList.size(); i++) {
            title[i] = new JLabel(todoList.get(i).getTitle());
            note[i] = new JLabel(todoList.get(i).getNote());
        }
        
        JPanel panel = new JPanel(null);
        
        nama.setBounds(150, 10, 200, 30);
                   
        int height = 40;
        for (JLabel t : title) {
            t.setBounds(10, height, 200, 30);
            panel.add(t);
            height += 30;  
        }
        height = 40;
        for (JLabel n : note) {
           
            n.setBounds(100, height, 200, 30);
            panel.add(n);
            height += 30;  
        }
        panel.add(nama);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
