package Clinical.Administration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

public class Appointment extends JFrame {

    // Instance variable to hold the connection
    private final conn c;
    private final String loggedInUsername;

    // Constructor to initialize the connection
    public Appointment(conn c, String loggedInUsername) {
        this.c = c;
        this.loggedInUsername = loggedInUsername;
    }

    JFrame frame;

    // Method to book an appointment for patient
    public void BookAppointment() {
        frame = new JFrame();
        frame.setSize(820, 460);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Adding a background image
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Hospiital Management\\src\\icon\\img57.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 460, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 460);
        frame.add(background);

        JLabel labelName = new JLabel("* APPOINTMENT BOOKING FORM *");
        labelName.setBounds(250, 10, 400, 50);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.BLACK);
        background.add(labelName);

        // column 1
        JLabel label1 = new JLabel("Appointment ID");
        label1.setBounds(30, 80, 200, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.BLACK);
        background.add(label1);

        JLabel label2 = new JLabel("Username");
        label2.setBounds(30, 120, 200, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.BLACK);
        background.add(label2);

        JLabel label3 = new JLabel("Patient ID");
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

        JLabel label7 = new JLabel("Disease");
        label7.setBounds(30, 320, 200, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 15));
        label7.setForeground(Color.BLACK);
        background.add(label7);

        // column 2 start now
        JTextField idField = new JTextField();
        idField.setBounds(230, 80, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idField.setEditable(false);
        background.add(idField);

        // Fetch the next available ID from database
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select max(ID) from appointments");
            if(resultSet.next()) {
                int nextId = resultSet.getInt(1) + 1;
                idField.setText(String.valueOf(nextId));
            } else {
                idField.setText("1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Choice choice = new Choice();
        choice.setBounds(230, 120, 150, 20);
        choice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        choice.setBackground(new Color(3, 45, 48));
        choice.setForeground(Color.white);
        background.add(choice);

        // Populate Patient name in comboBox2
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select Username from Patients");
            while (rs.next()) {
                choice.add(rs.getString("Username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTextField patientIdField = new JTextField();
        patientIdField.setBounds(230, 160, 150, 20);
        patientIdField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        patientIdField.setEditable(false);
        background.add(patientIdField);

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
        background.add(patientDiseaseField);

        // column 3
        JLabel label8 = new JLabel("Appointment Date");
        label8.setBounds(430, 80, 200, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 15));
        label8.setForeground(Color.BLACK);
        background.add(label8);

        JLabel label9 = new JLabel("Password");
        label9.setBounds(430, 120, 200, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 15));
        label9.setForeground(Color.BLACK);
        background.add(label9);

        JLabel label10 = new JLabel("Patient Name");
        label10.setBounds(430, 160, 200, 20);
        label10.setFont(new Font("Tahoma", Font.BOLD, 15));
        label10.setForeground(Color.BLACK);
        background.add(label10);

        JLabel label11 = new JLabel("Gender");
        label11.setBounds(430, 200, 180, 20);
        label11.setFont(new Font("Tahoma", Font.BOLD, 15));
        label11.setForeground(Color.BLACK);
        background.add(label11);

        JLabel label12 = new JLabel("Address");
        label12.setBounds(430, 240, 180, 20);
        label12.setFont(new Font("Tahoma", Font.BOLD, 15));
        label12.setForeground(Color.BLACK);
        background.add(label12);

        JLabel label13 = new JLabel("Email");
        label13.setBounds(430, 280, 180, 20);
        label13.setFont(new Font("Tahoma", Font.BOLD, 15));
        label13.setForeground(Color.BLACK);
        background.add(label13);

        JLabel label14 = new JLabel("Select Doctor");
        label14.setBounds(430, 320, 180, 20);
        label14.setFont(new Font("Tahoma", Font.BOLD, 15));
        label14.setForeground(Color.BLACK);
        background.add(label14);

        // column 4
        // Add the JDateChooser for date selection
        JDateChooser dateField = new JDateChooser();
        dateField.setBounds(620, 80, 150, 20);
        dateField.setDateFormatString("yyyy-MM-dd"); // Set date format
        background.add(dateField);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(620, 120, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setForeground(Color.BLACK);
        passwordField.setEditable(false);
        background.add(passwordField);

        JTextField nameField = new JTextField();
        nameField.setBounds(620, 160, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Color.BLACK);
        nameField.setEditable(false);
        background.add(nameField);

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

        Choice choice1 = new Choice();
        choice1.setBounds(620, 320, 150, 20);
        choice1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        choice1.setBackground(new Color(3, 45, 48));
        choice1.setForeground(Color.white);
        background.add(choice1);

        // Populate Doctor name in comboBox2
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select Doctor_Name from doctors");
            while (rs.next()) {
                choice1.add(rs.getString("Doctor_Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton b1 = new JButton("Check");
        b1.setBounds(130, 380, 120, 40);
        b1.setFont(new Font("Tahoma", Font.BOLD, 18));
        b1.setBackground(Color.green);
        b1.setForeground(Color.BLACK);
        background.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the selected username from the dropdown
                    String selectedUsername = choice.getSelectedItem();
                    if (selectedUsername == null || selectedUsername.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please select a username first.");
                        return;
                    }

                    // Establish database connection
                    conn c = new conn();
                    String query = "SELECT * FROM patients WHERE username = ?";
                    PreparedStatement stmt = c.connection.prepareStatement(query);
                    stmt.setString(1, selectedUsername);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        passwordField.setText(rs.getString("Password"));
                        ageField.setText(rs.getString("Age"));
                        patientIdField.setText(rs.getString("ID"));
                        fatherNameField.setText(rs.getString("Father_Name"));
                        mobileNoField.setText(rs.getString("Mobile_No"));
                        addressField.setText(rs.getString("Address"));
                        emailField.setText(rs.getString("Email"));
                        nameField.setText(rs.getString("Patient_Name"));
                        String gender = rs.getString("Gender");
                        r1.setSelected(gender.equalsIgnoreCase("Male"));
                        r2.setSelected(gender.equalsIgnoreCase("Female"));
                        patientDiseaseField.setText(rs.getString("Patient_Disease"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton b2 = new JButton("Book Appointment");
        b2.setBounds(310, 380, 200, 40);
        b2.setFont(new Font("Tahoma", Font.BOLD, 18));
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        background.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (dateField.getDate() == null || passwordField.getText().isEmpty() || nameField.getText().isEmpty() ||
                            patientIdField.getText().isEmpty() || ageField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "All fields are required!");
                        return;
                    }

                    // Retrieve and format the selected date
                    Date selectedDate = dateField.getDate();
                    if (selectedDate == null) {
                        JOptionPane.showMessageDialog(null, "Please select a date.");
                        return;
                    }
                    SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = dbDateFormat.format(selectedDate);


                    conn c = new conn();
                    String q = "insert into appointments (AppointmentDate, Username, Password, Patient_ID, Patient_Name, Age, Gender, Father_Name, Address, Mobile_No, Email, Disease, Doctor_Name, Status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = c.statement.getConnection().prepareStatement(q);

                    ps.setString(1, formattedDate);
                    ps.setString(2, choice.getSelectedItem());
                    ps.setString(3, passwordField.getText());
                    ps.setString(4, patientIdField.getText());
                    ps.setString(5, nameField.getText());
                    ps.setInt(6, Integer.parseInt(ageField.getText()));
                    ps.setString(7, r1.isSelected() ? "Male" : "Female");
                    ps.setString(8, fatherNameField.getText());
                    ps.setString(9, addressField.getText());
                    ps.setString(10, mobileNoField.getText());
                    ps.setString(11, emailField.getText());
                    ps.setString(12, patientDiseaseField.getText());
                    ps.setString(13, choice1.getSelectedItem());
                    ps.setString(14, "Pending");

                    String username = choice.getSelectedItem();
                    String password = passwordField.getText();

                    if (authenticateUser(username, password)) {
                        int rowsInserted = ps.executeUpdate();
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "Appointment booked successfully!");
                        }
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Age must be a number!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        JButton b3 = new JButton("Back");
        b3.setBounds(570, 380, 120, 40);
        b3.setFont(new Font("serif", Font.BOLD, 18));
        b3.setForeground(Color.white);
        b3.setBackground(Color.BLACK);
        b3.addActionListener(e -> frame.setVisible(false));
        background.add(b3);

        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }

    // Method to book an appointment for patients
    public void BookAppointments() {
        frame = new JFrame();
        frame.setSize(820, 460);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Adding a background image
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Hospiital Management\\src\\icon\\img57.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 460, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 460);
        frame.add(background);

        JLabel labelName = new JLabel("* APPOINTMENT BOOKING FORM *");
        labelName.setBounds(250, 10, 400, 50);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.BLACK);
        background.add(labelName);

        // column 1
        JLabel label1 = new JLabel("Appointment ID");
        label1.setBounds(30, 80, 200, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.BLACK);
        background.add(label1);

        JLabel label2 = new JLabel("Username");
        label2.setBounds(30, 120, 200, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.BLACK);
        background.add(label2);

        JLabel label3 = new JLabel("Patient ID");
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

        JLabel label7 = new JLabel("Disease");
        label7.setBounds(30, 320, 200, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 15));
        label7.setForeground(Color.BLACK);
        background.add(label7);

        // column 2 start now
        JTextField idField = new JTextField();
        idField.setBounds(230, 80, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idField.setEditable(false);
        background.add(idField);

        // Fetch the next available ID from database
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select max(ID) from appointments");
            if(resultSet.next()) {
                int nextId = resultSet.getInt(1) + 1;
                idField.setText(String.valueOf(nextId));
            } else {
                idField.setText("1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTextField usernameField = new JTextField();
        usernameField.setBounds(230, 120, 150, 20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usernameField.setEditable(false);
        background.add(usernameField);

        JTextField patientIdField = new JTextField();
        patientIdField.setBounds(230, 160, 150, 20);
        patientIdField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        patientIdField.setEditable(false);
        background.add(patientIdField);

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
        background.add(patientDiseaseField);

        // column 3
        JLabel label8 = new JLabel("Appointment Date");
        label8.setBounds(430, 80, 200, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 15));
        label8.setForeground(Color.BLACK);
        background.add(label8);

        JLabel label9 = new JLabel("Password");
        label9.setBounds(430, 120, 200, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 15));
        label9.setForeground(Color.BLACK);
        background.add(label9);

        JLabel label10 = new JLabel("Patient Name");
        label10.setBounds(430, 160, 200, 20);
        label10.setFont(new Font("Tahoma", Font.BOLD, 15));
        label10.setForeground(Color.BLACK);
        background.add(label10);

        JLabel label11 = new JLabel("Gender");
        label11.setBounds(430, 200, 180, 20);
        label11.setFont(new Font("Tahoma", Font.BOLD, 15));
        label11.setForeground(Color.BLACK);
        background.add(label11);

        JLabel label12 = new JLabel("Address");
        label12.setBounds(430, 240, 180, 20);
        label12.setFont(new Font("Tahoma", Font.BOLD, 15));
        label12.setForeground(Color.BLACK);
        background.add(label12);

        JLabel label13 = new JLabel("Email");
        label13.setBounds(430, 280, 180, 20);
        label13.setFont(new Font("Tahoma", Font.BOLD, 15));
        label13.setForeground(Color.BLACK);
        background.add(label13);

        JLabel label14 = new JLabel("Select Doctor");
        label14.setBounds(430, 320, 180, 20);
        label14.setFont(new Font("Tahoma", Font.BOLD, 15));
        label14.setForeground(Color.BLACK);
        background.add(label14);

        // column 4
        // Add the JDateChooser for date selection
        JDateChooser dateField = new JDateChooser();
        dateField.setBounds(620, 80, 150, 20);
        dateField.setDateFormatString("yyyy-MM-dd"); // Set date format
        background.add(dateField);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(620, 120, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setForeground(Color.BLACK);
        background.add(passwordField);

        JTextField nameField = new JTextField();
        nameField.setBounds(620, 160, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Color.BLACK);
        nameField.setEditable(false);
        background.add(nameField);

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

        Choice choice1 = new Choice();
        choice1.setBounds(620, 320, 150, 20);
        choice1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        choice1.setBackground(new Color(3, 45, 48));
        choice1.setForeground(Color.white);
        background.add(choice1);

        // Populate Doctor name in comboBox2
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select Doctor_Name from doctors");
            while (rs.next()) {
                choice1.add(rs.getString("Doctor_Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton b1 = new JButton("Check");
        b1.setBounds(130, 380, 120, 40);
        b1.setFont(new Font("Tahoma", Font.BOLD, 18));
        b1.setBackground(Color.green);
        b1.setForeground(Color.BLACK);
        background.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Fetch patients details
                    conn c = new conn();
                    String query = "SELECT * FROM patients WHERE username = ?";
                    PreparedStatement stmt = c.connection.prepareStatement(query);
                    stmt.setString(1, loggedInUsername);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        usernameField.setText(rs.getString("Username"));
                        ageField.setText(rs.getString("Age"));
                        patientIdField.setText(rs.getString("ID"));
                        fatherNameField.setText(rs.getString("Father_Name"));
                        mobileNoField.setText(rs.getString("Mobile_No"));
                        addressField.setText(rs.getString("Address"));
                        emailField.setText(rs.getString("Email"));
                        nameField.setText(rs.getString("Patient_Name"));
                        String gender = rs.getString("Gender");
                        r1.setSelected(gender.equalsIgnoreCase("Male"));
                        r2.setSelected(gender.equalsIgnoreCase("Female"));
                        patientDiseaseField.setText(rs.getString("Patient_Disease"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton b2 = new JButton("Book Appointment");
        b2.setBounds(310, 380, 200, 40);
        b2.setFont(new Font("Tahoma", Font.BOLD, 18));
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        background.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (dateField.getDate() == null || passwordField.getText().isEmpty() || nameField.getText().isEmpty() ||
                            patientIdField.getText().isEmpty() || ageField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "All fields are required!");
                        return;
                    }

                    /// Retrieve and format the selected date
                    Date selectedDate = dateField.getDate();
                    if (selectedDate == null) {
                        JOptionPane.showMessageDialog(null, "Please select a date.");
                        return;
                    }
                    SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = dbDateFormat.format(selectedDate);


                    conn c = new conn();
                    String q = "insert into appointments (AppointmentDate, Username, Password, Patient_ID, Patient_Name, Age, Gender, Father_Name, Address, Mobile_No, Email, Disease, Doctor_Name, Status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = c.statement.getConnection().prepareStatement(q);

                    ps.setString(1, formattedDate);
                    ps.setString(2, usernameField.getText());
                    ps.setString(3, passwordField.getText());
                    ps.setString(4, patientIdField.getText());
                    ps.setString(5, nameField.getText());
                    ps.setInt(6, Integer.parseInt(ageField.getText()));
                    ps.setString(7, r1.isSelected() ? "Male" : "Female");
                    ps.setString(8, fatherNameField.getText());
                    ps.setString(9, addressField.getText());
                    ps.setString(10, mobileNoField.getText());
                    ps.setString(11, emailField.getText());
                    ps.setString(12, patientDiseaseField.getText());
                    ps.setString(13, choice1.getSelectedItem());
                    ps.setString(14, "Pending");

                    String username = usernameField.getText();
                    String password = passwordField.getText();

                    if (authenticateUser(username, password)) {
                        int rowsInserted = ps.executeUpdate();
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "Appointment booked successfully!");
                        }
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Age must be a number!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        JButton b3 = new JButton("Back");
        b3.setBounds(570, 380, 120, 40);
        b3.setFont(new Font("serif", Font.BOLD, 18));
        b3.setForeground(Color.white);
        b3.setBackground(Color.BLACK);
        b3.addActionListener(e -> frame.setVisible(false));
        background.add(b3);

        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }

    private boolean authenticateUser(String username, String password) {
        String query = "SELECT * FROM patients WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = c.connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    public void ViewAppointmentsAll() {
        frame = new JFrame();
        frame.setBounds(0, 90, 1400, 780);
        frame.getContentPane().setBackground(new Color(109, 164, 170));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); // Use null layout for precise positioning
        contentPanel.setBackground(new Color(109, 164, 170));

        JLabel label1 = new JLabel("ALL APPOINTMENT'S DATA");
        label1.setBounds(500, 10, 400, 50);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.BLACK);
        contentPanel.add(label1);

        JTable table = new JTable();
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));

        // Wrap the table in a JScrollPane
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(0, 70, 1400, 500);
        tableScrollPane.setBackground(new Color(109, 164, 170));
        contentPanel.add(tableScrollPane);

        try {
            conn c = new conn();
            String q = "select ID, AppointmentDate, Patient_ID, Patient_Name, Age, Gender, Father_Name, Address, Mobile_No, Email, Disease, Doctor_Name, Status  from appointments";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton b1 = new JButton("Back");
        b1.setBounds(630, 590, 120, 30);
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        contentPanel.add(b1);

        // Wrap the entire content panel in a JScrollPane
        JScrollPane frameScrollPane = new JScrollPane(contentPanel);
        frame.add(frameScrollPane);

        frame.setUndecorated(true);
        frame.setVisible(true);
    }

    public void ViewAppointmentsPatient() {
        frame = new JFrame();
        frame.setBounds(0, 90, 1400, 780);
        frame.getContentPane().setBackground(new Color(109, 164, 170));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); // Use null layout for precise positioning
        contentPanel.setBackground(new Color(109, 164, 170));

        JLabel label1 = new JLabel("ALL APPOINTMENT'S DATA");
        label1.setBounds(500, 10, 400, 50);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.BLACK);
        contentPanel.add(label1);

        JTable table = new JTable();
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));

        // Wrap the table in a JScrollPane
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(0, 70, 1400, 500);
        tableScrollPane.setBackground(new Color(109, 164, 170));
        contentPanel.add(tableScrollPane);

        try {
            conn c = new conn();
            String q = "select ID, AppointmentDate, Patient_ID, Patient_Name, Age, Gender, Father_Name, Address, Mobile_No, Email, Disease, Doctor_Name, Status  from appointments where Username = ?";
            PreparedStatement stmt = c.connection.prepareStatement(q);
            stmt.setString(1, loggedInUsername);
            ResultSet rs = stmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton b1 = new JButton("Back");
        b1.setBounds(630, 590, 120, 30);
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        contentPanel.add(b1);

        // Wrap the entire content panel in a JScrollPane
        JScrollPane frameScrollPane = new JScrollPane(contentPanel);
        frame.add(frameScrollPane);

        frame.setUndecorated(true);
        frame.setVisible(true);
    }

    public void ViewAppointmentsDoctor(String loggedInUsername) {
        JFrame frame = new JFrame("Doctor's Appointments");
        frame.setBounds(0, 90, 1400, 780);
        frame.getContentPane().setBackground(new Color(109, 164, 170));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(new Color(109, 164, 170));

        JLabel label1 = new JLabel("ALL APPOINTMENTS DATA");
        label1.setBounds(500, 10, 400, 50);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.BLACK);
        contentPanel.add(label1);

        JTable table = new JTable();
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(0, 70, 1400, 500);
        tableScrollPane.setBackground(new Color(109, 164, 170));
        contentPanel.add(tableScrollPane);

        try {
            conn c = new conn();

            // Step 1: Retrieve Doctor_Name based on loggedInUsername
            String doctorNameQuery = "SELECT Doctor_Name FROM doctors WHERE Username = ?";
            PreparedStatement doctorNameStmt = c.connection.prepareStatement(doctorNameQuery);
            doctorNameStmt.setString(1, loggedInUsername);

            ResultSet doctorNameRs = doctorNameStmt.executeQuery();

            String doctorName = null;
            if (doctorNameRs.next()) {
                doctorName = doctorNameRs.getString("Doctor_Name");
            }

            if (doctorName == null) {
                JOptionPane.showMessageDialog(null, "No doctor found for username: " + loggedInUsername);
                return;
            }

            // Step 2: Fetch appointments for the doctor
            String query = "SELECT ID, AppointmentDate, Patient_ID, Patient_Name, Age, Gender, Father_Name, " +
                    "Address, Mobile_No, Email, Disease, Doctor_Name, Status " +
                    "FROM appointments WHERE Doctor_Name = ?";
            PreparedStatement stmt = c.connection.prepareStatement(query);
            stmt.setString(1, doctorName);

            ResultSet rs = stmt.executeQuery();

            // Populate the JTable with the query result
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving appointments: " + e.getMessage());
        }

        JButton backButton = new JButton("Back");
        backButton.setBounds(630, 590, 120, 30);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> frame.setVisible(false));
        contentPanel.add(backButton);

        JScrollPane frameScrollPane = new JScrollPane(contentPanel);
        frame.add(frameScrollPane);

        frame.setUndecorated(true);
        frame.setVisible(true);
    }


    public void CompleteAppointment() {
        frame = new JFrame();
        frame.setSize(400, 200);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // Adding a login background image
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Hospiital Management\\src\\icon\\img46.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(400, 200);
        frame.add(background);

        JLabel title = new JLabel("Appointment Completion");
        title.setBounds(80, 10, 400, 50);
        title.setForeground(Color.white);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.BLACK);
        background.add(title);

        // Adding components
        JLabel namelabel = new JLabel("Appointment ID");
        namelabel.setBounds(30, 80, 200, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.BLACK);
        background.add(namelabel);

        JTextField textField = new JTextField();
        textField.setBounds(220, 80, 150, 30);
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        textField.setForeground(Color.BLACK);
        background.add(textField);

        JButton b1 = new JButton("Complete");
        b1.setBounds(30, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 16));
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK);
        background.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1) {
                    String inputId = textField.getText();
                    try {
                        int appointmentId = Integer.parseInt(inputId);
                        completeAppointment(appointmentId);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID. Please enter a valid number.");
                    }
                }
            }
        });

        JButton b2 = new JButton("Cancel");
        b2.setBounds(245, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        background.add(b2);


        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void completeAppointment(int appointmentId) {
        try {
            // Establish database connection
            conn c = new conn(); // Assuming conn is your database connection class
            if (c.connection == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed!");
                return;
            }

            // SQL query to update the AppointmentStatus to 'Completed'
            String sql = "UPDATE appointments SET Status = 'Complete' WHERE ID = ?";
            PreparedStatement ps = c.connection.prepareStatement(sql); // Use the correct connection instance

            // Set the appointment ID for the query
            ps.setInt(1, appointmentId);

            // Execute the update
            int rowsUpdated = ps.executeUpdate();

            // Check if the update was successful
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Appointment marked as completed successfully!");
                frame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Appointment ID not found. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }

    public void CancelAppointment() {
        frame = new JFrame();
        frame.setSize(400, 200);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // Adding a login background image
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Hospiital Management\\src\\icon\\img49.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(400, 200);
        frame.add(background);

        JLabel title = new JLabel("Appointment Cancellation");
        title.setBounds(70, 10, 400, 50);
        title.setForeground(Color.white);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.black);
        background.add(title);

        // Adding components
        JLabel namelabel = new JLabel("Appointment ID");
        namelabel.setBounds(30, 80, 200, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.BLACK);
        background.add(namelabel);

        JTextField textField = new JTextField();
        textField.setBounds(220, 80, 150, 30);
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        textField.setForeground(Color.BLACK);
        background.add(textField);

        JButton b1 = new JButton("Cancel");
        b1.setBounds(30, 140, 120, 30);
        b1.setFont(new Font("Tahoma", Font.BOLD, 16));
        b1.setBackground(Color.RED);
        b1.setForeground(Color.BLACK);
        background.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1) {
                    String inputId = textField.getText();
                    try {
                        int appointmentId = Integer.parseInt(inputId);
                        cancelAppointment(appointmentId);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID. Please enter a valid number.");
                    }
                }
            }
        });

        JButton b2 = new JButton("Back");
        b2.setBounds(245, 140, 120, 30);
        b2.setFont(new Font("Tahoma", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        background.add(b2);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void cancelAppointment(int appointmentId) {
        try {
            // Establish database connection
            conn c = new conn(); // Assuming conn is your database connection class
            if (c.connection == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed!");
                return;
            }

            // SQL query to update the AppointmentStatus to 'Completed'
            String sql = "UPDATE appointments SET Status = 'Cancelled' WHERE ID = ?";
            PreparedStatement ps = c.connection.prepareStatement(sql); // Use the correct connection instance

            // Set the appointment ID for the query
            ps.setInt(1, appointmentId);

            // Execute the update
            int rowsUpdated = ps.executeUpdate();

            // Check if the update was successful
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Appointment marked as cancelled successfully!");
                frame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Appointment ID not found. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }

    public void RescheduleAppointment() {
        frame = new JFrame();
        frame.setSize(400, 240);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // Adding a background image
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Hospiital Management\\src\\icon\\img40.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(400, 240, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(400, 240);
        frame.add(background);

        JLabel title = new JLabel("Appointment Rescheduling");
        title.setBounds(70, 10, 400, 50);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.black);
        background.add(title);

        JLabel nameLabel = new JLabel("Appointment ID");
        nameLabel.setBounds(30, 80, 200, 30);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        nameLabel.setForeground(Color.BLACK);
        background.add(nameLabel);

        JLabel dateLabel = new JLabel("Appointment Date");
        dateLabel.setBounds(30, 120, 200, 30);
        dateLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        dateLabel.setForeground(Color.BLACK);
        background.add(dateLabel);

        JTextField textField = new JTextField();
        textField.setBounds(220, 80, 150, 20);
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        background.add(textField);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(220, 120, 150, 20);
        dateChooser.setDateFormatString("dd-MM-yyyy");
        background.add(dateChooser);

        JButton rescheduleButton = new JButton("Reschedule");
        rescheduleButton.setBounds(30, 180, 140, 30);
        rescheduleButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        rescheduleButton.setBackground(Color.GREEN);
        rescheduleButton.setForeground(Color.BLACK);
        background.add(rescheduleButton);

        rescheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String inputId = textField.getText();
                    int appointmentId = Integer.parseInt(inputId);

                    // Get the selected date
                    Date selectedDate = dateChooser.getDate();
                    if (selectedDate == null) {
                        JOptionPane.showMessageDialog(null, "Please select a valid date.");
                        return;
                    }

                    // Format the selected date to match the database's date format
                    SimpleDateFormat dbDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String formattedDate = dbDateFormat.format(selectedDate);

                    // Reschedule the appointment
                    rescheduleAppointment(formattedDate, appointmentId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID. Please enter a valid number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(245, 180, 120, 30);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        background.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void rescheduleAppointment(String formattedDate, int appointmentId) {
        try {
            conn c = new conn(); // Assuming conn is your database connection class
            if (c.connection == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed!");
                return;
            }

            // SQL query to update the appointment date and status
            String sql = "UPDATE appointments SET AppointmentDate = ?, Status = 'Rescheduled' WHERE ID = ?";
            PreparedStatement ps = c.connection.prepareStatement(sql);

            // Set parameters
            ps.setString(1, formattedDate);
            ps.setInt(2, appointmentId);

            // Execute the update
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Appointment rescheduled successfully!");
                frame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Appointment ID not found. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }

    public void EditAppointment() {
        frame = new JFrame();
        frame.setSize(820, 460);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Adding a background image
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Hospiital Management\\src\\icon\\img57.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 460, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 460);
        frame.add(background);

        JLabel labelName = new JLabel("* MODIFY APPOINTMENT DETAILS *");
        labelName.setBounds(250, 10, 400, 50);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.BLACK);
        background.add(labelName);

        // column 1
        JLabel label1 = new JLabel("Username");
        label1.setBounds(30, 80, 200, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.BLACK);
        background.add(label1);

        JLabel label2 = new JLabel("Appointment ID");
        label2.setBounds(30, 120, 200, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.BLACK);
        background.add(label2);

        JLabel label3 = new JLabel("Patient ID");
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

        JLabel label7 = new JLabel("Disease");
        label7.setBounds(30, 320, 200, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 15));
        label7.setForeground(Color.BLACK);
        background.add(label7);

        // column 2 start now

        Choice choice = new Choice();
        choice.setBounds(230, 80, 150, 20);
        choice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        choice.setBackground(new Color(3, 45, 48));
        choice.setForeground(Color.white);
        background.add(choice);

        // Populate Patient name in comboBox2
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select Username from Patients");
            while (rs.next()) {
                choice.add(rs.getString("Username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTextField idField = new JTextField();
        idField.setBounds(230, 120, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idField.setEditable(false);
        background.add(idField);

        JTextField patientIdField = new JTextField();
        patientIdField.setBounds(230, 160, 150, 20);
        patientIdField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        patientIdField.setEditable(false);
        background.add(patientIdField);

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
        background.add(patientDiseaseField);

        // column 3
        JLabel label8 = new JLabel("Password");
        label8.setBounds(430, 80, 200, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 15));
        label8.setForeground(Color.BLACK);
        background.add(label8);

        JLabel label9 = new JLabel("Appointment Date");
        label9.setBounds(430, 120, 200, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 15));
        label9.setForeground(Color.BLACK);
        background.add(label9);

        JLabel label10 = new JLabel("Patient Name");
        label10.setBounds(430, 160, 200, 20);
        label10.setFont(new Font("Tahoma", Font.BOLD, 15));
        label10.setForeground(Color.BLACK);
        background.add(label10);

        JLabel label11 = new JLabel("Gender");
        label11.setBounds(430, 200, 180, 20);
        label11.setFont(new Font("Tahoma", Font.BOLD, 15));
        label11.setForeground(Color.BLACK);
        background.add(label11);

        JLabel label12 = new JLabel("Address");
        label12.setBounds(430, 240, 180, 20);
        label12.setFont(new Font("Tahoma", Font.BOLD, 15));
        label12.setForeground(Color.BLACK);
        background.add(label12);

        JLabel label13 = new JLabel("Email");
        label13.setBounds(430, 280, 180, 20);
        label13.setFont(new Font("Tahoma", Font.BOLD, 15));
        label13.setForeground(Color.BLACK);
        background.add(label13);

        JLabel label14 = new JLabel("Select Doctor");
        label14.setBounds(430, 320, 180, 20);
        label14.setFont(new Font("Tahoma", Font.BOLD, 15));
        label14.setForeground(Color.BLACK);
        background.add(label14);

        // column 4
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(620, 80, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setForeground(Color.BLACK);
        passwordField.setEditable(false);
        background.add(passwordField);

        // Add the JDateChooser for date selection
        JDateChooser dateField = new JDateChooser();
        dateField.setBounds(620, 120, 150, 20);
        dateField.setDateFormatString("yyyy-MM-dd"); // Set date format
        background.add(dateField);

        JTextField nameField = new JTextField();
        nameField.setBounds(620, 160, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Color.BLACK);
        nameField.setEditable(false);
        background.add(nameField);

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

        Choice choice1 = new Choice();
        choice1.setBounds(620, 320, 150, 20);
        choice1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        choice1.setBackground(new Color(3, 45, 48));
        choice1.setForeground(Color.white);
        background.add(choice1);

        // Populate Doctor name in comboBox2
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select Doctor_Name from doctors");
            while (rs.next()) {
                choice1.add(rs.getString("Doctor_Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton b1 = new JButton("Check");
        b1.setBounds(130, 380, 120, 40);
        b1.setFont(new Font("Tahoma", Font.BOLD, 18));
        b1.setBackground(Color.green);
        b1.setForeground(Color.BLACK);
        background.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the selected username from the dropdown
                    String selectedUsername = choice.getSelectedItem();
                    if (selectedUsername == null || selectedUsername.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please select a username first.");
                        return;
                    }

                    // Establish database connection
                    conn c = new conn();
                    String query = "SELECT * FROM appointments WHERE username = ?";
                    PreparedStatement stmt = c.connection.prepareStatement(query);
                    stmt.setString(1, selectedUsername);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        idField.setText(rs.getString("ID"));
                        passwordField.setText(rs.getString("Password"));
                        ageField.setText(rs.getString("Age"));
                        patientIdField.setText(rs.getString("ID"));
                        fatherNameField.setText(rs.getString("Father_Name"));
                        mobileNoField.setText(rs.getString("Mobile_No"));
                        addressField.setText(rs.getString("Address"));
                        emailField.setText(rs.getString("Email"));
                        nameField.setText(rs.getString("Patient_Name"));
                        String gender = rs.getString("Gender");
                        r1.setSelected(gender.equalsIgnoreCase("Male"));
                        r2.setSelected(gender.equalsIgnoreCase("Female"));
                        patientDiseaseField.setText(rs.getString("Disease"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton b2 = new JButton("Update");
        b2.setBounds(330, 380, 150, 40);
        b2.setFont(new Font("Tahoma", Font.BOLD, 18));
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        background.add(b2);
        b2.addActionListener(e -> {
            try {
                if (dateField.getDate() == null || passwordField.getText().isEmpty() || patientDiseaseField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required!");
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String appointmentDate = sdf.format(dateField.getDate());
                String username = choice.getSelectedItem();
                String disease = patientDiseaseField.getText();
                String doctorName = choice1.getSelectedItem();

                conn c = new conn();
                String query = "UPDATE appointments SET AppointmentDate = ?, Disease = ?, Doctor_Name = ? WHERE Username = ?";
                PreparedStatement ps = c.connection.prepareStatement(query);
                ps.setString(1, appointmentDate);
                ps.setString(2, disease);
                ps.setString(3, doctorName);
                ps.setString(4, username);

                int updated = ps.executeUpdate();
                if (updated > 0) {
                    JOptionPane.showMessageDialog(null, "Appointment updated successfully!");
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Update failed. Please try again.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        JButton b3 = new JButton("Back");
        b3.setBounds(570, 380, 120, 40);
        b3.setFont(new Font("serif", Font.BOLD, 18));
        b3.setForeground(Color.white);
        b3.setBackground(Color.BLACK);
        b3.addActionListener(e -> frame.setVisible(false));
        background.add(b3);

        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        conn databaseConnection = new conn();
        String testUsername = "aditya1";
        Appointment appointment = new Appointment(databaseConnection, testUsername);
//        appointment.BookAppointment();
//        appointment.BookAppointments();
//        appointment.ViewAppointments();
//        appointment.ViewAppointment();
//        appointment.CompleteAppointment();
//        appointment.CancelAppointment();
        appointment.RescheduleAppointment();
//        String loggedInDoctor = "Atul Kumar";
//        appointment.ViewAppointmentsDoctor(loggedInDoctor);
    }
}
