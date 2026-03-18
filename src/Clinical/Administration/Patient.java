package Clinical.Administration;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient extends JFrame {

    private final conn c;
    private final String loggedInUsername;

    Patient(conn c, String loggedInUsername) {
        this.c = c;
        this.loggedInUsername = loggedInUsername;
    }

    JComboBox comboBox1, comboBox2;

    public void AddNewPatient() {
        // frame
        JFrame frame = new JFrame();
        frame.setSize(820, 500);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img49.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 500, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 500);
        frame.add(background);

        // page heading
        JLabel heading = new JLabel("* NEW PATIENT REGISTRATION FORM *");
        heading.setBounds(210, 10, 600, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        background.add(heading);

        // column 1 start now
        JLabel label1 = new JLabel("Patient ID");
        label1.setBounds(30, 80, 200, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label1.setForeground(Color.BLACK);
        background.add(label1);

        JLabel label2 = new JLabel("ID Prof");
        label2.setBounds(30, 120, 200, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.BLACK);
        background.add(label2);

        JLabel label3 = new JLabel("Username");
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
        JTextField idField = new JTextField();
        idField.setBounds(230, 80, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idField.setEditable(false);
        background.add(idField);

        // Fetch the next available ID from database
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select max(ID) from patients");
            if(resultSet.next()) {
                int nextId = resultSet.getInt(1) + 1;
                idField.setText(String.valueOf(nextId));
            } else {
                idField.setText("1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        comboBox1 = new JComboBox(new String[] {"Aadhar Card", "Pan Card", "VoterID Card", "Driving Licence"});
        comboBox1.setBounds(230, 120, 150, 20);
        comboBox1.setBackground(new Color(3, 45, 48));
        comboBox1.setForeground(Color.white);
        comboBox1.setFont(new Font("Tahoma", Font.BOLD, 12));
        background.add(comboBox1);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(230, 160, 150, 20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usernameField.setForeground(Color.BLACK);
        background.add(usernameField);

        JTextField ageField = new JTextField();
        ageField.setBounds(230, 200, 150, 20);
        ageField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ageField.setForeground(Color.BLACK);
        background.add(ageField);

        JTextField fatherNameField = new JTextField();
        fatherNameField.setBounds(230, 240, 150, 20);
        fatherNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fatherNameField.setForeground(Color.BLACK);
        background.add(fatherNameField);

        JTextField mobileNoField = new JTextField();
        mobileNoField.setBounds(230, 280, 150, 20);
        mobileNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        mobileNoField.setForeground(Color.BLACK);
        background.add(mobileNoField);

        JTextField patientDiseaseField = new JTextField();
        patientDiseaseField.setBounds(230, 320, 150, 20);
        patientDiseaseField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        patientDiseaseField.setForeground(Color.BLACK);
        background.add(patientDiseaseField);

        JTextField userTypeField = new JTextField("Patient");
        userTypeField.setBounds(230, 360, 150, 20);
        userTypeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        userTypeField.setForeground(Color.BLACK);
        userTypeField.setEditable(false);
        background.add(userTypeField);

        // column 3 start now
        JLabel label9 = new JLabel("Patient Name");
        label9.setBounds(430, 80, 190, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 15));
        label9.setForeground(Color.BLACK);
        background.add(label9);

        JLabel label10 = new JLabel("ID Prof No");
        label10.setBounds(430, 120, 180, 20);
        label10.setFont(new Font("Tahoma", Font.BOLD, 15));
        label10.setForeground(Color.BLACK);
        background.add(label10);

        JLabel label11 = new JLabel("Password");
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
        JTextField nameField = new JTextField();
        nameField.setBounds(620, 80, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Color.BLACK);
        background.add(nameField);

        JTextField idProfNoField = new JTextField();
        idProfNoField.setBounds(620, 120, 150, 20);
        idProfNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idProfNoField.setForeground(Color.BLACK);
        background.add(idProfNoField);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(620, 160, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setForeground(Color.BLACK);
        background.add(passwordField);

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
        background.add(addressField);

        JTextField emailField = new JTextField();
        emailField.setBounds(620, 280, 150, 20);
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        emailField.setForeground(Color.BLACK);
        background.add(emailField);

        comboBox2 = new JComboBox(new String[] {"Anaesthesiology", "Burns & Plastic Surgery", "CTVS", "Dentistry", "Dermatology", "ENT",
                "Gastroenterology", "General Medicine", "General Surgery", "Gynaecology", "Haematology", "Medical Oncology ", "Neurosurgery", "Obstetrics ", "Ophthalmology",
                "Orthopaedics", "Paediatrics", "Paediatric Surgery", "Physical Medicine", "Physical Medicine", "Psychiatry", "Pulmonary Medicine",
                "Radio-Therapy", "Rheumatologist", "Intervention Radiology", "Surgical Gastroenterology", "Surgical Oncology", "Trauma & Emergency", "Urology", "Private Ward"});
        comboBox2.setBounds(620, 320, 150, 20);
        comboBox2.setBackground(new Color(3, 45, 48));
        comboBox2.setForeground(Color.white);
        comboBox2.setFont(new Font("Tahoma", Font.BOLD, 12));
        background.add(comboBox2);

        JTextField dateField = new JTextField();
        dateField.setBounds(620, 360, 150, 20);
        dateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        dateField.setForeground(Color.BLACK);
        dateField.setEditable(false);
        background.add(dateField);

        // Set the current date in the field
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        dateField.setText(formatter.format(currentDate));

        // add two button (Add, Back)
        JButton b1 = new JButton("Add");
        b1.setBounds(160, 420, 120, 40);
        b1.setFont(new Font("Tahoma", Font.BOLD, 18));
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.white);
        background.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(e.getSource()==b1) {
                        conn c = new conn();
                        String radioBTN = null;
                        if(r1.isSelected()) {
                            radioBTN = "Male";
                        } else if(r2.isSelected()) {
                            radioBTN = "Female";
                        }
                        String s1 = idField.getText();
                        String s2 = nameField.getText();
                        String s3 = (String)comboBox1.getSelectedItem();
                        String s4 = idProfNoField.getText();
                        String s5 = usernameField.getText();
                        String s6 = passwordField.getText();
                        String s7 = ageField.getText();
                        String s8 = radioBTN;
                        String s9 = fatherNameField.getText();
                        String s10 = addressField.getText();
                        String s11 = mobileNoField.getText();
                        String s12 = emailField.getText();
                        String s13 = patientDiseaseField.getText();
                        String s14 = (String)comboBox2.getSelectedItem();
                        String s15 = userTypeField.getText();
                        String s16 = dateField.getText();
                        if (s1.isEmpty() || s2.isEmpty() || s4.isEmpty() || s5.isEmpty() || s6.isEmpty() || s7.isEmpty() || s8.isEmpty() || s9.isEmpty() || s10.isEmpty() || s11.isEmpty() || s13.isEmpty() || s14.isEmpty() || s15.isEmpty() || s16.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "All fields are required!");
                            return;
                        }

                        try {
                            String q = "insert into patients values('"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"', '"+s5+"', '"+s6+"', '"+s7+"', '"+s8+"', '"+s9+"', '"+s10+"', '"+s11+"', '"+s12+"', '"+s13+"', '"+s14+"', '"+s15+"', '"+s16+"')";
                            String q1 = "insert into users(Username, Password, UserType) values('"+s5+"', '"+s6+"', '"+s15+"')";
                            c.statement.executeUpdate(q);
                            c.statement.executeUpdate(q1);
                            JOptionPane.showMessageDialog(null, "Patient Added Successfully");
                            JOptionPane.showMessageDialog(null, "Patient Login Username : " + s5 + " Password : " + s6 + " UserType : " + s15);
                            frame.setVisible(false);
                        } catch (Exception E) {
                            E.printStackTrace();
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton b2 = new JButton("Back");
        b2.setBounds(540, 420, 120, 40);
        b2.setFont(new Font("Tahoma", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        background.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void ViewPatients() {
        JFrame frame = new JFrame();
        frame.setBounds(0, 90, 1400, 780);
        frame.getContentPane().setBackground(new Color(109, 164, 170));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); // Use null layout for precise positioning
        contentPanel.setBackground(new Color(109, 164, 170));

        JLabel label1 = new JLabel("ALL PATIENT'S DATA");
        label1.setBounds(600, 10, 400, 50);
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
            String q = "select ID, Patient_Name, Age, Gender, Father_Name, Address, Mobile_No, Email, Patient_Disease, Date from patients";
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

    public void ViewPatient() {
        JFrame frame = new JFrame();
        frame.setBounds(0, 90, 1400, 780);
        frame.getContentPane().setBackground(new Color(109, 164, 170));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); // Use null layout for precise positioning
        contentPanel.setBackground(new Color(109, 164, 170));

        JLabel label1 = new JLabel("ALL PATIENT'S DATA");
        label1.setBounds(600, 10, 400, 50);
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
            String q = "select * from patients";
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

    public void DischargePatient() {
        JFrame frame = new JFrame();
        frame.setSize(820, 420);
        frame.setLocationRelativeTo(null);

        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img49.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 420, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 420);
        frame.add(background);

        JLabel heading = new JLabel("* PATIENT DISCHARGE FORM *");
        heading.setBounds(270, 10, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        background.add(heading);

        // column 1 start now
        JLabel label1 = new JLabel("Username");
        label1.setBounds(30, 80, 200, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label1.setForeground(Color.BLACK);
        background.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(30, 120, 200, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.BLACK);
        background.add(label2);

        JLabel label3 = new JLabel("Father Name");
        label3.setBounds(30, 160, 200, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.BLACK);
        background.add(label3);

        JLabel label4 = new JLabel("Mobile No");
        label4.setBounds(30, 200, 200, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        label4.setForeground(Color.BLACK);
        background.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(30, 240, 200, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 15));
        label5.setForeground(Color.BLACK);
        background.add(label5);

        JLabel label6 = new JLabel("Admit Date");
        label6.setBounds(30, 280, 200, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 15));
        label6.setForeground(Color.BLACK);
        background.add(label6);

        // Column 2
        Choice choice = new Choice();
        choice.setBounds(230, 80, 150, 20);
        choice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        choice.setBackground(new Color(3, 45, 48));
        choice.setForeground(Color.white);
        background.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patients");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTextField ageField = new JTextField();
        ageField.setBounds(230, 120, 150, 20);
        ageField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ageField.setForeground(Color.BLACK);
        background.add(ageField);

        JTextField fatherNameField = new JTextField();
        fatherNameField.setBounds(230, 160, 150, 20);
        fatherNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fatherNameField.setForeground(Color.BLACK);
        background.add(fatherNameField);

        JTextField mobileNoField = new JTextField();
        mobileNoField.setBounds(230, 200, 150, 20);
        mobileNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        mobileNoField.setForeground(Color.BLACK);
        background.add(mobileNoField);

        JTextField patientDiseaseField = new JTextField();
        patientDiseaseField.setBounds(230, 240, 150, 20);
        patientDiseaseField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        patientDiseaseField.setForeground(Color.BLACK);
        background.add(patientDiseaseField);

        JTextField admitDateField = new JTextField();
        admitDateField.setBounds(230, 280, 150, 20);
        admitDateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        admitDateField.setForeground(Color.BLACK);
        admitDateField.setEditable(false);
        background.add(admitDateField);

        // column 3 start now
        JLabel label7 = new JLabel("Patient Name");
        label7.setBounds(430, 80, 190, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 15));
        label7.setForeground(Color.BLACK);
        background.add(label7);

        JLabel label8 = new JLabel("Gender");
        label8.setBounds(430, 120, 180, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 15));
        label8.setForeground(Color.BLACK);
        background.add(label8);

        JLabel label9 = new JLabel("Address");
        label9.setBounds(430, 160, 180, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 15));
        label9.setForeground(Color.BLACK);
        background.add(label9);

        JLabel label10 = new JLabel("Email");
        label10.setBounds(430, 200, 180, 20);
        label10.setFont(new Font("Tahoma", Font.BOLD, 15));
        label10.setForeground(Color.BLACK);
        background.add(label10);

        JLabel label11 = new JLabel("Ward");
        label11.setBounds(430, 240, 180, 20);
        label11.setFont(new Font("Tahoma", Font.BOLD, 15));
        label11.setForeground(Color.BLACK);
        background.add(label11);

        JLabel label12 = new JLabel("Discharge Time");
        label12.setBounds(430, 280, 200, 20);
        label12.setFont(new Font("Tahoma", Font.BOLD, 15));
        label12.setForeground(Color.BLACK);
        background.add(label12);

        // Column 4
        JTextField nameField = new JTextField();
        nameField.setBounds(620, 80, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Color.BLACK);
        background.add(nameField);

        // Select Gender
        // Create a ButtonGroup to group the gender radio buttons
        ButtonGroup genderGroup = new ButtonGroup();

        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(620, 120, 70, 20);
        r1.setFont(new Font("Tahoma", Font.BOLD, 12));
        r1.setForeground(Color.BLACK);
        background.add(r1);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(690, 120, 80, 20);
        r2.setFont(new Font("Tahoma", Font.BOLD, 12));
        r2.setForeground(Color.BLACK);
        background.add(r2);

        // Add radio buttons to the group
        genderGroup.add(r1);
        genderGroup.add(r2);

        JTextField addressField = new JTextField();
        addressField.setBounds(620, 160, 150, 20);
        addressField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addressField.setForeground(Color.BLACK);
        background.add(addressField);

        JTextField emailField = new JTextField();
        emailField.setBounds(620, 200, 150, 20);
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        emailField.setForeground(Color.BLACK);
        background.add(emailField);

        JTextField wardField = new JTextField();
        wardField.setBounds(620, 240, 150, 20);
        wardField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        wardField.setForeground(Color.BLACK);
        background.add(wardField);

        JTextField dischargeDateField = new JTextField();
        dischargeDateField.setBounds(620, 280, 150, 20);
        dischargeDateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        dischargeDateField.setForeground(Color.BLACK);
        dischargeDateField.setEditable(false);
        background.add(dischargeDateField);

        // Set the current date in the field
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        dischargeDateField.setText(formatter.format(currentDate));

        JButton check = new JButton("Check");
        check.setBounds(130, 340, 120, 40);
        check.setFont(new Font("Tahoma", Font.BOLD, 18));
        check.setForeground(Color.white);
        check.setBackground(Color.GREEN);
        background.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    ResultSet rs = c.statement.executeQuery("select * from patients where Username = '"+choice.getSelectedItem()+"'");
                    while (rs.next()) {
                        nameField.setText(rs.getString("Patient_Name"));
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
                        admitDateField.setText(rs.getString("Date"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(310, 340, 200, 40);
        discharge.setFont(new Font("Tahoma", Font.BOLD, 18));
        discharge.setForeground(Color.white);
        discharge.setBackground(Color.BLUE);
        background.add(discharge);

        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    c.statement.executeUpdate("delete from patients where Username = '"+choice.getSelectedItem()+"'");
                    JOptionPane.showMessageDialog(null, "Patient Discharge Successfully");
                    frame.setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(570, 340, 120, 40);
        back.setFont(new Font("Tahoma", Font.BOLD, 18));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        background.add(back);

        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void EditPatientDetails() {
        JFrame frame = new JFrame();
        frame.setSize(820, 500);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img49.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 500, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 500);
        frame.add(background);

        // page heading
        JLabel heading = new JLabel("* MODIFY PATIENT DETAILS *");
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
        Choice choice = new Choice();
        choice.setBounds(230, 80, 150, 20);
        choice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        choice.setBackground(new Color(3, 45, 48));
        choice.setForeground(Color.white);
        background.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patients");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTextField idField = new JTextField();
        idField.setBounds(230, 120, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idField.setEditable(false);
        background.add(idField);

        JTextField idProfField = new JTextField();
        idProfField.setBounds(230, 160, 150, 20);
        idProfField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        background.add(idProfField);

        JTextField ageField = new JTextField();
        ageField.setBounds(230, 200, 150, 20);
        ageField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ageField.setForeground(Color.BLACK);
        background.add(ageField);

        JTextField fatherNameField = new JTextField();
        fatherNameField.setBounds(230, 240, 150, 20);
        fatherNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fatherNameField.setForeground(Color.BLACK);
        background.add(fatherNameField);

        JTextField mobileNoField = new JTextField();
        mobileNoField.setBounds(230, 280, 150, 20);
        mobileNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        mobileNoField.setForeground(Color.BLACK);
        background.add(mobileNoField);

        JTextField patientDiseaseField = new JTextField();
        patientDiseaseField.setBounds(230, 320, 150, 20);
        patientDiseaseField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        patientDiseaseField.setForeground(Color.BLACK);
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
        background.add(passwordField);

        JTextField nameField = new JTextField();
        nameField.setBounds(620, 120, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Color.BLACK);
        background.add(nameField);

        JTextField idProfNoField = new JTextField();
        idProfNoField.setBounds(620, 160, 150, 20);
        idProfNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idProfNoField.setForeground(Color.BLACK);
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
        background.add(addressField);

        JTextField emailField = new JTextField();
        emailField.setBounds(620, 280, 150, 20);
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        emailField.setForeground(Color.BLACK);
        background.add(emailField);

        JTextField wardField = new JTextField();
        wardField.setBounds(620, 320, 150, 20);
        wardField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        wardField.setForeground(Color.BLACK);
        background.add(wardField);

        JTextField dateField = new JTextField();
        dateField.setBounds(620, 360, 150, 20);
        dateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        dateField.setForeground(Color.BLACK);
        dateField.setEditable(false);
        background.add(dateField);

        JButton check = new JButton("Check");
        check.setBounds(130, 420, 120, 40);
        check.setFont(new Font("Tahoma", Font.BOLD, 18));
        check.setForeground(Color.white);
        check.setBackground(Color.GREEN);
        background.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = choice.getSelectedItem().trim();

                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please select a Username.");
                    return;
                }
                try {
                    conn c = new conn();
                    String query = "select * from patients where Username = ?";
                    PreparedStatement ps = c.connection.prepareStatement(query);
                    ps.setString(1, username);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        passwordField.setText(rs.getString("Password"));
                        idField.setText(rs.getString("ID"));
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
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(310, 420, 200, 40);
        update.setFont(new Font("Tahoma", Font.BOLD, 18));
        update.setForeground(Color.white);
        update.setBackground(Color.BLUE);
        background.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = choice.getSelectedItem().trim();
                String password = passwordField.getText().trim();
                String patientName = nameField.getText().trim();
                String idProf = idProfField.getText().trim();
                String idProfNo = idProfNoField.getText().trim();
                String age = ageField.getText().trim();
                String gender = r1.isSelected() ? "Male" : "Female";
                String fatherName = fatherNameField.getText().trim();
                String address = addressField.getText().trim();
                String mobileNo = mobileNoField.getText().trim();
                String email = emailField.getText().trim();
                String patientDisease = patientDiseaseField.getText().trim();
                String ward = wardField.getText().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Username and Password are required!");
                    return;
                }

                try {
                    conn c = new conn();
                    String query = "UPDATE patients SET Patient_Name = ?, ID_Prof = ?, ID_Prof_No = ?, Age = ?, Gender = ?, Father_Name = ?, Address = ?, Mobile_No = ?, Email = ?, Patient_Disease = ?, Ward = ? WHERE Username = ? AND Password = ?";
                    PreparedStatement ps = c.connection.prepareStatement(query);

                    ps.setString(1, patientName);
                    ps.setString(2, idProf);
                    ps.setString(3, idProfNo);
                    ps.setString(4, age);
                    ps.setString(5, gender);
                    ps.setString(6, fatherName);
                    ps.setString(7, address);
                    ps.setString(8, mobileNo);
                    ps.setString(9, email);
                    ps.setString(10, patientDisease);
                    ps.setString(11, ward);
                    ps.setString(12, username);
                    ps.setString(13, password);

                    int rowsUpdated = ps.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(frame, "Patient details updated successfully!");
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(frame, "No record found with the provided Username and Password.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while updating the details.");
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(570, 420, 120, 40);
        back.setFont(new Font("Tahoma", Font.BOLD, 18));
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

    public void EditPatientsDetails() {
        JFrame frame = new JFrame();
        frame.setSize(820, 500);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img49.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 500, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 500);
        frame.add(background);

        // page heading
        JLabel heading = new JLabel("* MODIFY PATIENT DETAILS *");
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
        Choice choice = new Choice();
        choice.setBounds(230, 80, 150, 20);
        choice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        choice.setBackground(new Color(3, 45, 48));
        choice.setForeground(Color.white);
        background.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patients");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        background.add(wardField);

        JTextField dateField = new JTextField();
        dateField.setBounds(620, 360, 150, 20);
        dateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        dateField.setForeground(Color.BLACK);
        dateField.setEditable(false);
        background.add(dateField);

        JButton check = new JButton("Check");
        check.setBounds(130, 420, 120, 40);
        check.setFont(new Font("Tahoma", Font.BOLD, 18));
        check.setForeground(Color.white);
        check.setBackground(Color.GREEN);
        background.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = choice.getSelectedItem().trim();

                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please select Username.");
                    return;
                }
                try {
                    conn c = new conn();
                    String query = "select * from patients where Username = ?";
                    PreparedStatement ps = c.connection.prepareStatement(query);
                    ps.setString(1, username);

                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
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
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(310, 420, 200, 40);
        update.setFont(new Font("Tahoma", Font.BOLD, 18));
        update.setForeground(Color.white);
        update.setBackground(Color.BLUE);
        background.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = choice.getSelectedItem().trim();
                String password = passwordField.getText().trim();
                String patientName = nameField.getText().trim();
                String idProf = idProfField.getText().trim();
                String idProfNo = idProfNoField.getText().trim();
                String age = ageField.getText().trim();
                String gender = r1.isSelected() ? "Male" : "Female";
                String fatherName = fatherNameField.getText().trim();
                String address = addressField.getText().trim();
                String mobileNo = mobileNoField.getText().trim();
                String email = emailField.getText().trim();
                String patientDisease = patientDiseaseField.getText().trim();
                String ward = wardField.getText().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Username and Password are required!");
                    return;
                }

                try {
                    conn c = new conn();
                    String query = "UPDATE patients SET Patient_Name = ?, ID_Prof = ?, ID_Prof_No = ?, Age = ?, Gender = ?, Father_Name = ?, Address = ?, Mobile_No = ?, Email = ?, Patient_Disease = ?, Ward = ? WHERE Username = ? AND Password = ?";
                    PreparedStatement ps = c.connection.prepareStatement(query);

                    ps.setString(1, patientName);
                    ps.setString(2, idProf);
                    ps.setString(3, idProfNo);
                    ps.setString(4, age);
                    ps.setString(5, gender);
                    ps.setString(6, fatherName);
                    ps.setString(7, address);
                    ps.setString(8, mobileNo);
                    ps.setString(9, email);
                    ps.setString(10, patientDisease);
                    ps.setString(11, ward);
                    ps.setString(12, username);
                    ps.setString(13, password);

                    int rowsUpdated = ps.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(frame, "Patient details updated successfully!");
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(frame, "No record found with the provided Username and Password.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while updating the details.");
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(570, 420, 120, 40);
        back.setFont(new Font("Tahoma", Font.BOLD, 18));
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


    public void EditProfileDetails() {
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
        JLabel heading = new JLabel("* MODIFY PROFILE - " + loggedInUsername.toUpperCase() + " *");
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
                idField.setText(rs.getString("ID"));
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

        JButton update = new JButton("Update");
        update.setBounds(200, 420, 150, 40);
        update.setFont(new Font("Tahoma", Font.BOLD, 18));
        update.setForeground(Color.white);
        update.setBackground(Color.BLUE);
        background.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = passwordField.getText().trim();
                String mobileNo = mobileNoField.getText().trim();
                String email = emailField.getText().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Username and Password are required!");
                    return;
                }

                try {
                    conn c = new conn();
                    String query = "UPDATE patients SET Mobile_No = ?, Email = ? WHERE Username = ? AND Password = ?";
                    PreparedStatement ps = c.connection.prepareStatement(query);


                    ps.setString(1, mobileNo);
                    ps.setString(2, email);
                    ps.setString(3, username);
                    ps.setString(4, password);

                    int rowsUpdated = ps.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(frame, "Patient details updated successfully!");
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(frame, "No record found with the provided Username and Password.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while updating the details.");
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(500, 420, 120, 40);
        back.setFont(new Font("Tahoma", Font.BOLD, 18));
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

    public static void main(String[] args) {
        conn databaseConnection = new conn();
        String testUsername = "aditya1";
        Patient patient = new  Patient(databaseConnection, testUsername);
//        patient.AddNewPatient();
//        patient.ViewPatients();
//        patient.DischargePatient();
//        patient.EditPatientDetails();
//        patient.DeletePatientAccount();
//        patient.EditProfileDetails();

    }
}
