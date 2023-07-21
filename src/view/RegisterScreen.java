package view;


import controller.Controller;
import model.User;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;


public class RegisterScreen {

    public RegisterScreen() {
        showRegisterMenu();
    }
    
    public void showRegisterMenu(){
        JFrame frame;
        JTextField emailField;
        JTextField nameField;
        JPasswordField passwordField;
        JRadioButton maleRadioButton;
        JRadioButton femaleRadioButton;
        JButton registerButton;
        JButton backButton;
        JButton fotoChooser;
        
        frame = new JFrame("Registration");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel emailLabel = new JLabel("Email:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel birthdayLabel = new JLabel("Birthday:");
        JLabel photoLabel = new JLabel("Photo:");

        emailField = new JTextField();
        nameField = new JTextField();
        passwordField = new JPasswordField();

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup buttonJenisKelamin = new ButtonGroup();
        buttonJenisKelamin.add(maleRadioButton); 
        buttonJenisKelamin.add(femaleRadioButton);
        
        SqlDateModel dateModel = new SqlDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel);
        JDatePickerImpl birthdayPicker = new JDatePickerImpl(datePanel);
        birthdayPicker.setButtonFocusable(true);
        birthdayPicker.setShowYearButtons(true);

        registerButton = new JButton("Register");
        backButton = new JButton("Back");
        
        fotoChooser = new JButton("Choose File Here");
        JLabel pathFoto = new JLabel("No file selected");
        fotoChooser.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JFileChooser jf = new JFileChooser();
               
               int returnValue = jf.showOpenDialog(null);
               if (returnValue == JFileChooser.APPROVE_OPTION) {
                   File selectedFile = jf.getSelectedFile();
                   String pathFile = selectedFile.getAbsolutePath();
                   pathFoto.setText(pathFile);
               }
           }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String tempGender = maleRadioButton.isSelected() ? "Male" : "Female";
                int gender;
                if (tempGender.equals("Male")){
                    gender = 0;
                } else {
                    gender = 1;
                }
                Date birthday = (Date) birthdayPicker.getModel().getValue();
                String photo = pathFoto.getText();

                if (password.length() < 8) {
                    JOptionPane.showMessageDialog(frame, "Registration failed. Password tidak boleh kurang dari 8");
                } else {
                    User user = new User(name, email, password, gender, birthday, photo);
                    Controller con = new Controller();
                    if (con.insertUser(user)){
                        frame.dispose();
                        JOptionPane.showMessageDialog(frame, "Registration successful!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Registration failed.");
                    }
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
        emailField.setBounds(100, 30, 250, 25);
        nameLabel.setBounds(20, 60, 80, 25);
        nameField.setBounds(100, 60, 250, 25);
        passwordLabel.setBounds(20, 90, 80, 25);
        passwordField.setBounds(100, 90, 250, 25);
        genderLabel.setBounds(20, 120, 80, 25);
        maleRadioButton.setBounds(100, 120, 80, 25);
        femaleRadioButton.setBounds(200, 120, 80, 25);
        birthdayLabel.setBounds(20, 150, 80, 25);
        birthdayPicker.setBounds(100, 150, 250, 25);
        photoLabel.setBounds(20, 180, 80, 25);
        fotoChooser.setBounds(100, 180, 100, 25);
        pathFoto.setBounds(210, 180, 250, 25);
        registerButton.setBounds(100, 220, 100, 25);
        backButton.setBounds(220, 220, 100, 25);

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(genderLabel);
        panel.add(maleRadioButton);
        panel.add(femaleRadioButton);
        panel.add(birthdayLabel);
        panel.add(birthdayPicker);
        panel.add(photoLabel);
        panel.add(fotoChooser);
        panel.add(pathFoto);
        panel.add(registerButton);
        panel.add(backButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
