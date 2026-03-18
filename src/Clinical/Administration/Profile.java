package Clinical.Administration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Profile {
    private final conn c; // Database connection instance
    private final String loggedInUsername; // Logged-in doctor's username

    // Constructor
    public Profile(conn c, String loggedInUsername) {
        this.c = c;
        this.loggedInUsername = loggedInUsername;
    }

    public void AdminProfile() {
        // frame
        JFrame frame = new JFrame();
        frame.setSize(820, 370);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img25.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 370, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 370);
        frame.add(background);

        // page heading
        JLabel heading = new JLabel("* MY PROFILE - " + loggedInUsername.toUpperCase() + " *");
        heading.setBounds(300, 10, 600, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        background.add(heading);

        // column 1 start now
        JLabel label1 = new JLabel("Username");
        label1.setBounds(30, 80, 200, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label1.setForeground(Color.BLACK);
        background.add(label1);

        JLabel label2 = new JLabel("Admin ID");
        label2.setBounds(30, 120, 200, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.BLACK);
        background.add(label2);

        JLabel label3 = new JLabel("Age");
        label3.setBounds(30, 160, 200, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.BLACK);
        background.add(label3);

        JLabel label4 = new JLabel("UserType");
        label4.setBounds(30, 200, 200, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        label4.setForeground(Color.BLACK);
        background.add(label4);

        JLabel label5 = new JLabel("Mobile No");
        label5.setBounds(30, 240, 200, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 15));
        label5.setForeground(Color.BLACK);
        background.add(label5);

        // column 2 start now
        JTextField usernameField = new JTextField();
        usernameField.setBounds(230, 80, 150, 20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usernameField.setEditable(false);
        background.add(usernameField);

        JTextField idField = new JTextField();
        idField.setBounds(230, 120, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idField.setEditable(false);
        background.add(idField);

        JTextField ageField = new JTextField();
        ageField.setBounds(230, 160, 150, 20);
        ageField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ageField.setForeground(Color.BLACK);
        ageField.setEditable(false);
        background.add(ageField);

        JTextField userTypeField = new JTextField("Admin");
        userTypeField.setBounds(230, 200, 150, 20);
        userTypeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        userTypeField.setForeground(Color.BLACK);
        userTypeField.setEditable(false);
        background.add(userTypeField);

        JTextField mobileNoField = new JTextField();
        mobileNoField.setBounds(230, 240, 150, 20);
        mobileNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        mobileNoField.setForeground(Color.BLACK);
        mobileNoField.setEditable(false);
        background.add(mobileNoField);

        // column 3 start now
        JLabel label6 = new JLabel("Password");
        label6.setBounds(430, 80, 190, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 15));
        label6.setForeground(Color.BLACK);
        background.add(label6);

        JLabel label7 = new JLabel("Admin Name");
        label7.setBounds(430, 120, 180, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 15));
        label7.setForeground(Color.BLACK);
        background.add(label7);

        JLabel label8 = new JLabel("Gender");
        label8.setBounds(430, 160, 180, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 15));
        label8.setForeground(Color.BLACK);
        background.add(label8);

        JLabel label9 = new JLabel("Joining Date");
        label9.setBounds(430, 200, 180, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 15));
        label9.setForeground(Color.BLACK);
        background.add(label9);

        JLabel label10 = new JLabel("Email");
        label10.setBounds(430, 240, 180, 20);
        label10.setFont(new Font("Tahoma", Font.BOLD, 15));
        label10.setForeground(Color.BLACK);
        background.add(label10);

        // column 4 start now
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(620, 80, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setForeground(Color.BLACK);
        passwordField.setEditable(false);
        background.add(passwordField);

        JTextField nameField = new JTextField();
        nameField.setBounds(620, 120, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Color.BLACK);
        nameField.setEditable(false);
        background.add(nameField);

        // Select Gender
        // Create a ButtonGroup to group the gender radio buttons
        ButtonGroup genderGroup = new ButtonGroup();

        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(620, 160, 70, 20);
        r1.setFont(new Font("Tahoma", Font.BOLD, 12));
        r1.setForeground(Color.BLACK);
        background.add(r1);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(690, 160, 80, 20);
        r2.setFont(new Font("Tahoma", Font.BOLD, 12));
        r2.setForeground(Color.BLACK);
        background.add(r2);

        // Add radio buttons to the group
        genderGroup.add(r1);
        genderGroup.add(r2);

        JTextField joiningDateField = new JTextField();
        joiningDateField.setBounds(620, 200, 150, 20);
        joiningDateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        joiningDateField.setForeground(Color.BLACK);
        joiningDateField.setEditable(false);
        background.add(joiningDateField);


        JTextField emailField = new JTextField();
        emailField.setBounds(620, 240, 150, 20);
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        emailField.setForeground(Color.BLACK);
        emailField.setEditable(false);
        background.add(emailField);

        try {
            conn c = new conn();
            String query = "SELECT * FROM admins WHERE username = ?";
            PreparedStatement stmt = c.connection.prepareStatement(query);
            stmt.setString(1, loggedInUsername);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usernameField.setText(rs.getString("Username"));
                passwordField.setText(rs.getString("Password"));
                idField.setText(rs.getString("ID"));
                nameField.setText(rs.getString("Name"));
                ageField.setText(rs.getString("Age"));
                String gender = rs.getString("Gender");
                r1.setSelected(gender.equalsIgnoreCase("Male"));
                r2.setSelected(gender.equalsIgnoreCase("Female"));
                joiningDateField.setText(rs.getString("Joining_Date"));
                mobileNoField.setText(rs.getString("Mobile_No"));
                emailField.setText(rs.getString("Email"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(340, 300, 120, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        background.add(back);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void ReceptionistProfile() {
        JFrame frame = new JFrame();
        frame.setSize(820, 460);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img57.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 460, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 460);
        frame.add(background);

        // page heading
        JLabel heading = new JLabel("* MY PROFILE - " + loggedInUsername.toUpperCase() + " *");
        heading.setBounds(290, 10, 600, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        background.add(heading);

        // column 1 start now
        JLabel label1 = new JLabel("Username");
        label1.setBounds(30, 80, 200, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label1.setForeground(Color.BLACK);
        background.add(label1);

        JLabel label2 = new JLabel("Receptionist ID");
        label2.setBounds(30, 120, 200, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.BLACK);
        background.add(label2);

        JLabel label3 = new JLabel("ID Prof");
        label3.setBounds(30, 160, 200, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.BLACK);
        background.add(label3);

        JLabel label4 = new JLabel("Age");
        label4.setBounds(30, 200, 200, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        label4.setForeground(Color.BLACK);
        background.add(label4);

        JLabel label5 = new JLabel("Qualification");
        label5.setBounds(30, 240, 200, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 15));
        label5.setForeground(Color.BLACK);
        background.add(label5);

        JLabel label6 = new JLabel("UserType");
        label6.setBounds(30, 280, 200, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 15));
        label6.setForeground(Color.BLACK);
        background.add(label6);

        JLabel label8 = new JLabel("Mobile No");
        label8.setBounds(30, 320, 200, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 15));
        label8.setForeground(Color.BLACK);
        background.add(label8);

        // column 2 start now
        JTextField usernameField = new JTextField();
        usernameField.setBounds(230, 80, 150, 20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usernameField.setEditable(false);
        background.add(usernameField);

        JTextField idField = new JTextField();
        idField.setBounds(230, 120, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idField.setEditable(false);
        background.add(idField);

        JTextField idProfField = new JTextField();
        idProfField.setBounds(230, 160, 150, 20);
        idProfField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idProfField.setEditable(false);
        background.add(idProfField);

        JTextField ageField = new JTextField();
        ageField.setBounds(230, 200, 150, 20);
        ageField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ageField.setForeground(Color.BLACK);
        ageField.setEditable(false);
        background.add(ageField);

        JTextField qualificationField = new JTextField();
        qualificationField.setBounds(230, 240, 150, 20);
        qualificationField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        qualificationField.setForeground(Color.BLACK);
        qualificationField.setEditable(false);
        background.add(qualificationField);

        JTextField userTypeField = new JTextField("Receptionist");
        userTypeField.setBounds(230, 280, 150, 20);
        userTypeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        userTypeField.setForeground(Color.BLACK);
        userTypeField.setEditable(false);
        background.add(userTypeField);

        JTextField mobileNoField = new JTextField();
        mobileNoField.setBounds(230, 320, 150, 20);
        mobileNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        mobileNoField.setForeground(Color.BLACK);
        mobileNoField.setEditable(false);
        background.add(mobileNoField);

        // column 3 start now
        JLabel label9 = new JLabel("Password");
        label9.setBounds(430, 80, 190, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 15));
        label9.setForeground(Color.BLACK);
        background.add(label9);

        JLabel label10 = new JLabel("Receptionist Name");
        label10.setBounds(430, 120, 180, 20);
        label10.setFont(new Font("Tahoma", Font.BOLD, 15));
        label10.setForeground(Color.BLACK);
        background.add(label10);

        JLabel label11 = new JLabel("ID Prof No");
        label11.setBounds(430, 160, 180, 20);
        label11.setFont(new Font("Tahoma", Font.BOLD, 15));
        label11.setForeground(Color.BLACK);
        background.add(label11);

        JLabel label12 = new JLabel("Gender");
        label12.setBounds(430, 200, 180, 20);
        label12.setFont(new Font("Tahoma", Font.BOLD, 15));
        label12.setForeground(Color.BLACK);
        background.add(label12);

        JLabel label13 = new JLabel("Joining Date");
        label13.setBounds(430, 240, 180, 20);
        label13.setFont(new Font("Tahoma", Font.BOLD, 15));
        label13.setForeground(Color.BLACK);
        background.add(label13);

        JLabel label15 = new JLabel("Address");
        label15.setBounds(430, 280, 180, 20);
        label15.setFont(new Font("Tahoma", Font.BOLD, 15));
        label15.setForeground(Color.BLACK);
        background.add(label15);

        JLabel label16 = new JLabel("Email");
        label16.setBounds(430, 320, 180, 20);
        label16.setFont(new Font("Tahoma", Font.BOLD, 15));
        label16.setForeground(Color.BLACK);
        background.add(label16);

        // column 4 start now
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(620, 80, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setForeground(Color.BLACK);
        passwordField.setEditable(false);
        background.add(passwordField);

        JTextField nameField = new JTextField();
        nameField.setBounds(620, 120, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Color.BLACK);
        nameField.setEditable(false);
        background.add(nameField);

        JTextField idProfNoField = new JTextField();
        idProfNoField.setBounds(620, 160, 150, 20);
        idProfNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idProfNoField.setForeground(Color.BLACK);
        idProfField.setEditable(false);
        background.add(idProfNoField);

        // Select Gender
        // Create a ButtonGroup to group the gender radio buttons
        ButtonGroup genderGroup = new ButtonGroup();

        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(620, 200, 70, 20);
        r1.setFont(new Font("Tahoma", Font.BOLD, 12));
        r1.setForeground(Color.BLACK);
        background.add(r1);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(690, 200, 80, 20);
        r2.setFont(new Font("Tahoma", Font.BOLD, 12));
        r2.setForeground(Color.BLACK);
        background.add(r2);

        // Add radio buttons to the group
        genderGroup.add(r1);
        genderGroup.add(r2);

        JTextField joiningDateField = new JTextField();
        joiningDateField.setBounds(620, 240, 150, 20);
        joiningDateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        joiningDateField.setForeground(Color.BLACK);
        joiningDateField.setEditable(false);
        background.add(joiningDateField);

        JTextField addressField = new JTextField();
        addressField.setBounds(620, 280, 150, 20);
        addressField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addressField.setForeground(Color.BLACK);
        addressField.setEditable(false);
        background.add(addressField);

        JTextField emailField = new JTextField();
        emailField.setBounds(620, 320, 150, 20);
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        emailField.setForeground(Color.BLACK);
        emailField.setEditable(false);
        background.add(emailField);

        try {
            String query = "SELECT * FROM receptionists WHERE username = ?";
            PreparedStatement stmt = c.connection.prepareStatement(query);
            stmt.setString(1, loggedInUsername);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usernameField.setText(rs.getString("Username"));
                passwordField.setText(rs.getString("Password"));
                idField.setText(rs.getString("ID"));
                nameField.setText(rs.getString("Receptionist_Name"));
                idProfField.setText(rs.getString("ID_Prof"));
                idProfNoField.setText(rs.getString("ID_Prof_No"));
                ageField.setText(rs.getString("Age"));
                String gender = rs.getString("Gender");
                r1.setSelected(gender.equalsIgnoreCase("Male"));
                r2.setSelected(gender.equalsIgnoreCase("Female"));
                qualificationField.setText(rs.getString("Qualification"));
                joiningDateField.setText(rs.getString("Joining_Date"));
                addressField.setText(rs.getString("Address"));
                mobileNoField.setText(rs.getString("Mobile_No"));
                emailField.setText(rs.getString("Email"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(340, 400, 120, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        background.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    // Method to display the doctor's profile
    public void DoctorProfile() {
        // frame
        JFrame frame = new JFrame();
        frame.setSize(820, 490);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img57.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 500, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 500);
        frame.add(background);

        // page heading
        JLabel heading = new JLabel("* MY PROFILE - " + loggedInUsername.toUpperCase() + " *");
        heading.setBounds(270, 10, 600, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        background.add(heading);

        // column 1 start now
        JLabel label1 = new JLabel("Username");
        label1.setBounds(30, 80, 200, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label1.setForeground(Color.BLACK);
        background.add(label1);

        JLabel label2 = new JLabel("Doctor ID");
        label2.setBounds(30, 120, 200, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.BLACK);
        background.add(label2);

        JLabel label3 = new JLabel("ID Prof");
        label3.setBounds(30, 160, 200, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.BLACK);
        background.add(label3);

        JLabel label4 = new JLabel("Age");
        label4.setBounds(30, 200, 200, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        label4.setForeground(Color.BLACK);
        background.add(label4);

        JLabel label5 = new JLabel("Qualification");
        label5.setBounds(30, 240, 200, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 15));
        label5.setForeground(Color.BLACK);
        background.add(label5);

        JLabel label6 = new JLabel("UserType");
        label6.setBounds(30, 280, 200, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 15));
        label6.setForeground(Color.BLACK);
        background.add(label6);

        JLabel label7 = new JLabel("Father Name");
        label7.setBounds(30, 320, 200, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 15));
        label7.setForeground(Color.BLACK);
        background.add(label7);

        JLabel label8 = new JLabel("Mobile No");
        label8.setBounds(30, 360, 200, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 15));
        label8.setForeground(Color.BLACK);
        background.add(label8);

        // column 2 start now
        JTextField usernameField = new JTextField();
        usernameField.setBounds(230, 80, 150, 20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usernameField.setEditable(false);
        background.add(usernameField);

        JTextField idField = new JTextField();
        idField.setBounds(230, 120, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idField.setEditable(false);
        background.add(idField);

        JTextField idProfField = new JTextField();
        idProfField.setBounds(230, 160, 150, 20);
        idProfField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idProfField.setEditable(false);
        background.add(idProfField);

        JTextField ageField = new JTextField();
        ageField.setBounds(230, 200, 150, 20);
        ageField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ageField.setForeground(Color.BLACK);
        ageField.setEditable(false);
        background.add(ageField);

        JTextField qualificationField = new JTextField();
        qualificationField.setBounds(230, 240, 150, 20);
        qualificationField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        qualificationField.setForeground(Color.BLACK);
        qualificationField.setEditable(false);
        background.add(qualificationField);

        JTextField userTypeField = new JTextField("Doctor");
        userTypeField.setBounds(230, 280, 150, 20);
        userTypeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        userTypeField.setForeground(Color.BLACK);
        userTypeField.setEditable(false);
        background.add(userTypeField);

        JTextField fatherNameField = new JTextField();
        fatherNameField.setBounds(230, 320, 150, 20);
        fatherNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fatherNameField.setForeground(Color.BLACK);
        fatherNameField.setEditable(false);
        background.add(fatherNameField);

        JTextField mobileNoField = new JTextField();
        mobileNoField.setBounds(230, 360, 150, 20);
        mobileNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        mobileNoField.setForeground(Color.BLACK);
        mobileNoField.setEditable(false);
        background.add(mobileNoField);

        // column 3 start now
        JLabel label9 = new JLabel("Password");
        label9.setBounds(430, 80, 190, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 15));
        label9.setForeground(Color.BLACK);
        background.add(label9);

        JLabel label10 = new JLabel("Doctor Name");
        label10.setBounds(430, 120, 180, 20);
        label10.setFont(new Font("Tahoma", Font.BOLD, 15));
        label10.setForeground(Color.BLACK);
        background.add(label10);

        JLabel label11 = new JLabel("ID Prof No");
        label11.setBounds(430, 160, 180, 20);
        label11.setFont(new Font("Tahoma", Font.BOLD, 15));
        label11.setForeground(Color.BLACK);
        background.add(label11);

        JLabel label12 = new JLabel("Gender");
        label12.setBounds(430, 200, 180, 20);
        label12.setFont(new Font("Tahoma", Font.BOLD, 15));
        label12.setForeground(Color.BLACK);
        background.add(label12);

        JLabel label13 = new JLabel("Joining Date");
        label13.setBounds(430, 240, 180, 20);
        label13.setFont(new Font("Tahoma", Font.BOLD, 15));
        label13.setForeground(Color.BLACK);
        background.add(label13);

        JLabel label14 = new JLabel("Specialisation");
        label14.setBounds(430, 280, 180, 20);
        label14.setFont(new Font("Tahoma", Font.BOLD, 15));
        label14.setForeground(Color.BLACK);
        background.add(label14);

        JLabel label15 = new JLabel("Address");
        label15.setBounds(430, 320, 180, 20);
        label15.setFont(new Font("Tahoma", Font.BOLD, 15));
        label15.setForeground(Color.BLACK);
        background.add(label15);

        JLabel label16 = new JLabel("Email");
        label16.setBounds(430, 360, 180, 20);
        label16.setFont(new Font("Tahoma", Font.BOLD, 15));
        label16.setForeground(Color.BLACK);
        background.add(label16);

        // column 4 start now
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(620, 80, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setForeground(Color.BLACK);
        passwordField.setEditable(false);
        background.add(passwordField);

        JTextField nameField = new JTextField();
        nameField.setBounds(620, 120, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Color.BLACK);
        nameField.setEditable(false);
        background.add(nameField);

        JTextField idProfNoField = new JTextField();
        idProfNoField.setBounds(620, 160, 150, 20);
        idProfNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idProfNoField.setForeground(Color.BLACK);
        idProfField.setEditable(false);
        background.add(idProfNoField);

        // Select Gender
        // Create a ButtonGroup to group the gender radio buttons
        ButtonGroup genderGroup = new ButtonGroup();

        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(620, 200, 70, 20);
        r1.setFont(new Font("Tahoma", Font.BOLD, 12));
        r1.setForeground(Color.BLACK);
        background.add(r1);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(690, 200, 80, 20);
        r2.setFont(new Font("Tahoma", Font.BOLD, 12));
        r2.setForeground(Color.BLACK);
        background.add(r2);

        // Add radio buttons to the group
        genderGroup.add(r1);
        genderGroup.add(r2);

        JTextField joiningDateField = new JTextField();
        joiningDateField.setBounds(620, 240, 150, 20);
        joiningDateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        joiningDateField.setForeground(Color.BLACK);
        joiningDateField.setEditable(false);
        background.add(joiningDateField);

        JTextField specialisationField = new JTextField();
        specialisationField.setBounds(620, 280, 150, 20);
        specialisationField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        specialisationField.setForeground(Color.BLACK);
        specialisationField.setEditable(false);
        background.add(specialisationField);


        JTextField addressField = new JTextField();
        addressField.setBounds(620, 320, 150, 20);
        addressField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addressField.setForeground(Color.BLACK);
        addressField.setEditable(false);
        background.add(addressField);

        JTextField emailField = new JTextField();
        emailField.setBounds(620, 360, 150, 20);
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        emailField.setForeground(Color.BLACK);
        emailField.setEditable(false);
        background.add(emailField);


        try {
            String query = "SELECT * FROM doctors WHERE username = ?";
            PreparedStatement stmt = c.connection.prepareStatement(query);
            stmt.setString(1, loggedInUsername);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usernameField.setText(rs.getString("Username"));
                passwordField.setText(rs.getString("Password"));
                idField.setText(rs.getString("ID"));
                nameField.setText(rs.getString("Doctor_Name"));
                idProfField.setText(rs.getString("ID_Prof"));
                idProfNoField.setText(rs.getString("ID_Prof_No"));
                ageField.setText(rs.getString("Age"));
                String gender = rs.getString("Gender");
                r1.setSelected(gender.equalsIgnoreCase("Male"));
                r2.setSelected(gender.equalsIgnoreCase("Female"));
                qualificationField.setText(rs.getString("Qualification"));
                joiningDateField.setText(rs.getString("Joining_Date"));
                specialisationField.setText(rs.getString("Specialisation"));
                fatherNameField.setText(rs.getString("FatherName"));
                addressField.setText(rs.getString("Address"));
                mobileNoField.setText(rs.getString("Mobile_No"));
                emailField.setText(rs.getString("Email"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(340, 420, 120, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        background.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });


        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void PatientProfile() {
        JFrame frame = new JFrame();
        frame.setSize(820, 500);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img57.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 500, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 500);
        frame.add(background);

        // page heading
        JLabel heading = new JLabel("* MY PROFILE - " + loggedInUsername.toUpperCase() + " *");
        heading.setBounds(270, 10, 600, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        background.add(heading);

        // column 1 start now
        JLabel label1 = new JLabel("Username");
        label1.setBounds(30, 80, 200, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label1.setForeground(Color.BLACK);
        background.add(label1);

        JLabel label2 = new JLabel("Patient ID");
        label2.setBounds(30, 120, 200, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.BLACK);
        background.add(label2);

        JLabel label3 = new JLabel("ID Prof");
        label3.setBounds(30, 160, 200, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.BLACK);
        background.add(label3);

        JLabel label4 = new JLabel("Age");
        label4.setBounds(30, 200, 200, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        label4.setForeground(Color.BLACK);
        background.add(label4);

        JLabel label5 = new JLabel("Father Name");
        label5.setBounds(30, 240, 200, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 15));
        label5.setForeground(Color.BLACK);
        background.add(label5);

        JLabel label6 = new JLabel("Mobile No");
        label6.setBounds(30, 280, 200, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 15));
        label6.setForeground(Color.BLACK);
        background.add(label6);

        JLabel label7 = new JLabel("Patient Disease");
        label7.setBounds(30, 320, 200, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 15));
        label7.setForeground(Color.BLACK);
        background.add(label7);

        JLabel label8 = new JLabel("UserType");
        label8.setBounds(30, 360, 200, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 15));
        label8.setForeground(Color.BLACK);
        background.add(label8);

        // column 2 start now
        JTextField usernameField = new JTextField();
        usernameField.setBounds(230, 80, 150, 20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usernameField.setEditable(false);
        background.add(usernameField);

        JTextField idField = new JTextField();
        idField.setBounds(230, 120, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idField.setEditable(false);
        background.add(idField);

        JTextField idProfField = new JTextField();
        idProfField.setBounds(230, 160, 150, 20);
        idProfField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idProfField.setEditable(false);
        background.add(idProfField);

        JTextField ageField = new JTextField();
        ageField.setBounds(230, 200, 150, 20);
        ageField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ageField.setForeground(Color.BLACK);
        ageField.setEditable(false);
        background.add(ageField);

        JTextField fatherNameField = new JTextField();
        fatherNameField.setBounds(230, 240, 150, 20);
        fatherNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fatherNameField.setForeground(Color.BLACK);
        fatherNameField.setEditable(false);
        background.add(fatherNameField);

        JTextField mobileNoField = new JTextField();
        mobileNoField.setBounds(230, 280, 150, 20);
        mobileNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        mobileNoField.setForeground(Color.BLACK);
        mobileNoField.setEditable(false);
        background.add(mobileNoField);

        JTextField patientDiseaseField = new JTextField();
        patientDiseaseField.setBounds(230, 320, 150, 20);
        patientDiseaseField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        patientDiseaseField.setForeground(Color.BLACK);
        patientDiseaseField.setEditable(false);
        background.add(patientDiseaseField);

        JTextField userTypeField = new JTextField("Patient");
        userTypeField.setBounds(230, 360, 150, 20);
        userTypeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        userTypeField.setForeground(Color.BLACK);
        userTypeField.setEditable(false);
        background.add(userTypeField);

        // column 3 start now
        JLabel label9 = new JLabel("Password");
        label9.setBounds(430, 80, 190, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 15));
        label9.setForeground(Color.BLACK);
        background.add(label9);

        JLabel label10 = new JLabel("Patient Name");
        label10.setBounds(430, 120, 180, 20);
        label10.setFont(new Font("Tahoma", Font.BOLD, 15));
        label10.setForeground(Color.BLACK);
        background.add(label10);

        JLabel label11 = new JLabel("ID Prof No");
        label11.setBounds(430, 160, 180, 20);
        label11.setFont(new Font("Tahoma", Font.BOLD, 15));
        label11.setForeground(Color.BLACK);
        background.add(label11);

        JLabel label12 = new JLabel("Gender");
        label12.setBounds(430, 200, 180, 20);
        label12.setFont(new Font("Tahoma", Font.BOLD, 15));
        label12.setForeground(Color.BLACK);
        background.add(label12);

        JLabel label13 = new JLabel("Address");
        label13.setBounds(430, 240, 180, 20);
        label13.setFont(new Font("Tahoma", Font.BOLD, 15));
        label13.setForeground(Color.BLACK);
        background.add(label13);

        JLabel label14 = new JLabel("Email");
        label14.setBounds(430, 280, 180, 20);
        label14.setFont(new Font("Tahoma", Font.BOLD, 15));
        label14.setForeground(Color.BLACK);
        background.add(label14);

        JLabel label15 = new JLabel("Ward");
        label15.setBounds(430, 320, 180, 20);
        label15.setFont(new Font("Tahoma", Font.BOLD, 15));
        label15.setForeground(Color.BLACK);
        background.add(label15);

        JLabel label16 = new JLabel("Date");
        label16.setBounds(430, 360, 180, 20);
        label16.setFont(new Font("Tahoma", Font.BOLD, 15));
        label16.setForeground(Color.BLACK);
        background.add(label16);

        // column 4 start now
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(620, 80, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setForeground(Color.BLACK);
        passwordField.setEditable(false);
        background.add(passwordField);

        JTextField nameField = new JTextField();
        nameField.setBounds(620, 120, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Color.BLACK);
        nameField.setEditable(false);
        background.add(nameField);

        JTextField idProfNoField = new JTextField();
        idProfNoField.setBounds(620, 160, 150, 20);
        idProfNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idProfNoField.setForeground(Color.BLACK);
        idProfNoField.setEditable(false);
        background.add(idProfNoField);

        // Select Gender
        // Create a ButtonGroup to group the gender radio buttons
        ButtonGroup genderGroup = new ButtonGroup();

        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(620, 200, 70, 20);
        r1.setFont(new Font("Tahoma", Font.BOLD, 12));
        r1.setForeground(Color.BLACK);
        background.add(r1);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(690, 200, 80, 20);
        r2.setFont(new Font("Tahoma", Font.BOLD, 12));
        r2.setForeground(Color.BLACK);
        background.add(r2);

        // Add radio buttons to the group
        genderGroup.add(r1);
        genderGroup.add(r2);

        JTextField addressField = new JTextField();
        addressField.setBounds(620, 240, 150, 20);
        addressField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addressField.setForeground(Color.BLACK);
        addressField.setEditable(false);
        background.add(addressField);

        JTextField emailField = new JTextField();
        emailField.setBounds(620, 280, 150, 20);
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        emailField.setForeground(Color.BLACK);
        emailField.setEditable(false);
        background.add(emailField);

        JTextField wardField = new JTextField();
        wardField.setBounds(620, 320, 150, 20);
        wardField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        wardField.setForeground(Color.BLACK);
        wardField.setEditable(false);
        background.add(wardField);

        JTextField dateField = new JTextField();
        dateField.setBounds(620, 360, 150, 20);
        dateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        dateField.setForeground(Color.BLACK);
        dateField.setEditable(false);
        background.add(dateField);


        try {
            String query = "SELECT * FROM patients WHERE username = ?";
            PreparedStatement stmt = c.connection.prepareStatement(query);
            stmt.setString(1, loggedInUsername);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usernameField.setText(rs.getString("Username"));
                passwordField.setText(rs.getString("Password"));
                idField.setText(rs.getString("ID"));
                passwordField.setText(rs.getString("Password"));
                nameField.setText(rs.getString("Patient_Name"));
                idProfField.setText(rs.getString("ID_Prof"));
                idProfNoField.setText(rs.getString("ID_Prof_No"));
                ageField.setText(rs.getString("Age"));
                String gender = rs.getString("Gender");
                r1.setSelected(gender.equalsIgnoreCase("Male"));
                r2.setSelected(gender.equalsIgnoreCase("Female"));
                fatherNameField.setText(rs.getString("Father_Name"));
                addressField.setText(rs.getString("Address"));
                mobileNoField.setText(rs.getString("Mobile_No"));
                emailField.setText(rs.getString("Email"));
                patientDiseaseField.setText(rs.getString("Patient_Disease"));
                wardField.setText(rs.getString("Ward"));
                userTypeField.setText(rs.getString("UserType"));
                dateField.setText(rs.getString("Date"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(340, 420, 120, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        background.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void StaffProfile() {
        // frame
        JFrame frame = new JFrame();
        frame.setSize(820, 490);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img57.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 490, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 490);
        frame.add(background);

        // page heading
        JLabel heading = new JLabel("* MY PROFILE - " + loggedInUsername.toUpperCase() + " *");
        heading.setBounds(270, 10, 600, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        background.add(heading);

        // column 1 start now
        JLabel label1 = new JLabel("Username");
        label1.setBounds(30, 80, 200, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label1.setForeground(Color.BLACK);
        background.add(label1);

        JLabel label2 = new JLabel("Staff ID");
        label2.setBounds(30, 120, 200, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.BLACK);
        background.add(label2);

        JLabel label3 = new JLabel("ID Prof");
        label3.setBounds(30, 160, 200, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.BLACK);
        background.add(label3);

        JLabel label4 = new JLabel("Age");
        label4.setBounds(30, 200, 200, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        label4.setForeground(Color.BLACK);
        background.add(label4);

        JLabel label5 = new JLabel("Qualification");
        label5.setBounds(30, 240, 200, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 15));
        label5.setForeground(Color.BLACK);
        background.add(label5);

        JLabel label6 = new JLabel("UserType");
        label6.setBounds(30, 280, 200, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 15));
        label6.setForeground(Color.BLACK);
        background.add(label6);

        JLabel label7 = new JLabel("Father Name");
        label7.setBounds(30, 320, 200, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 15));
        label7.setForeground(Color.BLACK);
        background.add(label7);

        JLabel label8 = new JLabel("Mobile No");
        label8.setBounds(30, 360, 200, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 15));
        label8.setForeground(Color.BLACK);
        background.add(label8);

        // column 2 start now
        JTextField usernameField = new JTextField();
        usernameField.setBounds(230, 80, 150, 20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usernameField.setEditable(false);
        usernameField.setEditable(false);
        background.add(usernameField);

        JTextField idField = new JTextField();
        idField.setBounds(230, 120, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idField.setEditable(false);
        background.add(idField);

        JTextField idProfField = new JTextField();
        idProfField.setBounds(230, 160, 150, 20);
        idProfField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idProfField.setEditable(false);
        background.add(idProfField);

        JTextField ageField = new JTextField();
        ageField.setBounds(230, 200, 150, 20);
        ageField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ageField.setForeground(Color.BLACK);
        ageField.setEditable(false);
        background.add(ageField);

        JTextField qualificationField = new JTextField();
        qualificationField.setBounds(230, 240, 150, 20);
        qualificationField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        qualificationField.setForeground(Color.BLACK);
        qualificationField.setEditable(false);
        background.add(qualificationField);

        JTextField userTypeField = new JTextField("Staff");
        userTypeField.setBounds(230, 280, 150, 20);
        userTypeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        userTypeField.setForeground(Color.BLACK);
        userTypeField.setEditable(false);
        background.add(userTypeField);

        JTextField fatherNameField = new JTextField();
        fatherNameField.setBounds(230, 320, 150, 20);
        fatherNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fatherNameField.setForeground(Color.BLACK);
        fatherNameField.setEditable(false);
        background.add(fatherNameField);

        JTextField mobileNoField = new JTextField();
        mobileNoField.setBounds(230, 360, 150, 20);
        mobileNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        mobileNoField.setForeground(Color.BLACK);
        mobileNoField.setEditable(false);
        background.add(mobileNoField);

        // column 3 start now
        JLabel label9 = new JLabel("Password");
        label9.setBounds(430, 80, 190, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 15));
        label9.setForeground(Color.BLACK);
        background.add(label9);

        JLabel label10 = new JLabel("Staff Name");
        label10.setBounds(430, 120, 180, 20);
        label10.setFont(new Font("Tahoma", Font.BOLD, 15));
        label10.setForeground(Color.BLACK);
        background.add(label10);

        JLabel label11 = new JLabel("ID Prof No");
        label11.setBounds(430, 160, 180, 20);
        label11.setFont(new Font("Tahoma", Font.BOLD, 15));
        label11.setForeground(Color.BLACK);
        background.add(label11);

        JLabel label12 = new JLabel("Gender");
        label12.setBounds(430, 200, 180, 20);
        label12.setFont(new Font("Tahoma", Font.BOLD, 15));
        label12.setForeground(Color.BLACK);
        background.add(label12);

        JLabel label13 = new JLabel("Joining Date");
        label13.setBounds(430, 240, 180, 20);
        label13.setFont(new Font("Tahoma", Font.BOLD, 15));
        label13.setForeground(Color.BLACK);
        background.add(label13);

        JLabel label14 = new JLabel("StaffType");
        label14.setBounds(430, 280, 180, 20);
        label14.setFont(new Font("Tahoma", Font.BOLD, 15));
        label14.setForeground(Color.BLACK);
        background.add(label14);

        JLabel label15 = new JLabel("Address");
        label15.setBounds(430, 320, 180, 20);
        label15.setFont(new Font("Tahoma", Font.BOLD, 15));
        label15.setForeground(Color.BLACK);
        background.add(label15);

        JLabel label16 = new JLabel("Email");
        label16.setBounds(430, 360, 180, 20);
        label16.setFont(new Font("Tahoma", Font.BOLD, 15));
        label16.setForeground(Color.BLACK);
        background.add(label16);

        // column 4 start now
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(620, 80, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setForeground(Color.BLACK);
        passwordField.setEditable(false);
        background.add(passwordField);

        JTextField nameField = new JTextField();
        nameField.setBounds(620, 120, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Color.BLACK);
        nameField.setEditable(false);
        background.add(nameField);

        JTextField idProfNoField = new JTextField();
        idProfNoField.setBounds(620, 160, 150, 20);
        idProfNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idProfNoField.setForeground(Color.BLACK);
        idProfNoField.setEditable(false);
        background.add(idProfNoField);

        // Select Gender
        // Create a ButtonGroup to group the gender radio buttons
        ButtonGroup genderGroup = new ButtonGroup();

        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(620, 200, 70, 20);
        r1.setFont(new Font("Tahoma", Font.BOLD, 12));
        r1.setForeground(Color.BLACK);
        background.add(r1);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(690, 200, 80, 20);
        r2.setFont(new Font("Tahoma", Font.BOLD, 12));
        r2.setForeground(Color.BLACK);
        background.add(r2);

        // Add radio buttons to the group
        genderGroup.add(r1);
        genderGroup.add(r2);

        JTextField joiningDateField = new JTextField();
        joiningDateField.setBounds(620, 240, 150, 20);
        joiningDateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        joiningDateField.setForeground(Color.BLACK);
        joiningDateField.setEditable(false);
        background.add(joiningDateField);

        JTextField staffTypeField = new JTextField();
        staffTypeField.setBounds(620, 280, 150, 20);
        staffTypeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        staffTypeField.setForeground(Color.BLACK);
        staffTypeField.setEditable(false);
        background.add(staffTypeField);


        JTextField addressField = new JTextField();
        addressField.setBounds(620, 320, 150, 20);
        addressField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addressField.setForeground(Color.BLACK);
        addressField.setEditable(false);
        background.add(addressField);

        JTextField emailField = new JTextField();
        emailField.setBounds(620, 360, 150, 20);
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        emailField.setForeground(Color.BLACK);
        emailField.setEditable(false);
        background.add(emailField);

        try {
            String query = "SELECT * FROM staffs WHERE username = ?";
            PreparedStatement stmt = c.connection.prepareStatement(query);
            stmt.setString(1, loggedInUsername);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usernameField.setText(rs.getString("Username"));
                passwordField.setText(rs.getString("Password"));
                idField.setText(rs.getString("ID"));
                nameField.setText(rs.getString("Staff_Name"));
                idProfField.setText(rs.getString("ID_Prof"));
                idProfNoField.setText(rs.getString("ID_Prof_No"));
                ageField.setText(rs.getString("Age"));
                String gender = rs.getString("Gender");
                r1.setSelected(gender.equalsIgnoreCase("Male"));
                r2.setSelected(gender.equalsIgnoreCase("Female"));
                qualificationField.setText(rs.getString("Qualification"));
                joiningDateField.setText(rs.getString("Joining_Date"));
                staffTypeField.setText(rs.getString("Staff_Type"));
                fatherNameField.setText(rs.getString("FatherName"));
                addressField.setText(rs.getString("Address"));
                mobileNoField.setText(rs.getString("Mobile_No"));
                emailField.setText(rs.getString("Email"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(340, 420, 120, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        background.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

}
