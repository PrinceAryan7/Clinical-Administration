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

public class Receptionist {
    private final conn c;
    private final String loggedInUsername;
    private static final int MAX_RECEPTIONIST = 3;

    public Receptionist(conn c, String loggedInUsername) {
        this.c = c;
        this.loggedInUsername = loggedInUsername;
    }

    JComboBox comboBox1;

    // Add new receptionist code
    public void AddNewReceptionist() {
        // frame
        JFrame frame = new JFrame();
        frame.setSize(820, 460);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img40.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 460, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 460);
        frame.add(background);

        // page heading
        JLabel heading = new JLabel("* NEW RECEPTIONIST REGISTRATION FORM *");
        heading.setBounds(200, 10, 600, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        background.add(heading);

        // column 1 start now
        JLabel label1 = new JLabel("Receptionist ID");
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

        JLabel label7 = new JLabel("Mobile No");
        label7.setBounds(30, 320, 200, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 15));
        label7.setForeground(Color.BLACK);
        background.add(label7);

        // column 2 start now
        JTextField idField = new JTextField();
        idField.setBounds(230, 80, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idField.setEditable(false);
        background.add(idField);

        // Fetch the next available ID from database
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select max(ID) from receptionists");
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
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        usernameField.setForeground(Color.BLACK);
        background.add(usernameField);

        JTextField ageField = new JTextField();
        ageField.setBounds(230, 200, 150, 20);
        ageField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ageField.setForeground(Color.BLACK);
        background.add(ageField);

        JTextField qualificationField = new JTextField();
        qualificationField.setBounds(230, 240, 150, 20);
        qualificationField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        qualificationField.setForeground(Color.BLACK);
        background.add(qualificationField);

        JTextField userTypeField = new JTextField("Receptionist");
        userTypeField.setBounds(230, 280, 150, 20);
        userTypeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        userTypeField.setForeground(Color.BLACK);
        userTypeField.setEditable(false);
        background.add(userTypeField);

        JTextField mobileNoField = new JTextField();
        mobileNoField.setBounds(230, 320, 150, 20);
        mobileNoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        mobileNoField.setForeground(Color.BLACK);
        background.add(mobileNoField);

        // column 3 start now
        JLabel label8 = new JLabel("Receptionist Name");
        label8.setBounds(430, 80, 190, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 15));
        label8.setForeground(Color.BLACK);
        background.add(label8);

        JLabel label9 = new JLabel("ID Prof No");
        label9.setBounds(430, 120, 180, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 15));
        label9.setForeground(Color.BLACK);
        background.add(label9);

        JLabel label10 = new JLabel("Password");
        label10.setBounds(430, 160, 180, 20);
        label10.setFont(new Font("Tahoma", Font.BOLD, 15));
        label10.setForeground(Color.BLACK);
        background.add(label10);

        JLabel label11 = new JLabel("Gender");
        label11.setBounds(430, 200, 180, 20);
        label11.setFont(new Font("Tahoma", Font.BOLD, 15));
        label11.setForeground(Color.BLACK);
        background.add(label11);

        JLabel label12 = new JLabel("Joining Date");
        label12.setBounds(430, 240, 180, 20);
        label12.setFont(new Font("Tahoma", Font.BOLD, 15));
        label12.setForeground(Color.BLACK);
        background.add(label12);

        JLabel label13 = new JLabel("Address");
        label13.setBounds(430, 280, 180, 20);
        label13.setFont(new Font("Tahoma", Font.BOLD, 15));
        label13.setForeground(Color.BLACK);
        background.add(label13);

        JLabel label14 = new JLabel("Email");
        label14.setBounds(430, 320, 180, 20);
        label14.setFont(new Font("Tahoma", Font.BOLD, 15));
        label14.setForeground(Color.BLACK);
        background.add(label14);

        // column 4 start now
        JTextField nameField = new JTextField();
        nameField.setBounds(620, 80, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nameField.setForeground(Color.BLACK);
        background.add(nameField);

        JTextField idProfNoField = new JTextField();
        idProfNoField.setBounds(620, 120, 150, 20);
        idProfNoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idProfNoField.setForeground(Color.BLACK);
        background.add(idProfNoField);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(620, 160, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
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

        JTextField joiningDateField = new JTextField();
        joiningDateField.setBounds(620, 240, 150, 20);
        joiningDateField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        joiningDateField.setForeground(Color.BLACK);
        joiningDateField.setEditable(false);
        background.add(joiningDateField);

        // Set the current date in the field
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        joiningDateField.setText(formatter.format(currentDate));

        JTextField addressField = new JTextField();
        addressField.setBounds(620, 280, 150, 20);
        addressField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addressField.setForeground(Color.BLACK);
        background.add(addressField);

        JTextField emailField = new JTextField();
        emailField.setBounds(620, 320, 150, 20);
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        emailField.setForeground(Color.BLACK);
        background.add(emailField);

        // add two button (Add, Back)
        JButton b1 = new JButton("Add");
        b1.setBounds(160, 380, 120, 40);
        b1.setFont(new Font("Tahoma", Font.BOLD, 18));
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.white);
        background.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(e.getSource()==b1) {
                        try {
                            conn c = new conn();
                            // Query to count existing receptionists
                            ResultSet rs = c.statement.executeQuery("SELECT COUNT(*) FROM receptionists");
                            if (rs.next()) {
                                int receptionistCount = rs.getInt(1);
                                if (receptionistCount >= MAX_RECEPTIONIST) {
                                    JOptionPane.showMessageDialog(null,
                                            "Maximum number of receptionists (" + MAX_RECEPTIONIST + ") reached. Cannot add more.");
                                    return;
                                }
                            }
                        } catch (Exception E) {
                            E.printStackTrace();
                        }
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
                        String s9 = qualificationField.getText();
                        String s10 = joiningDateField.getText();
                        String s11 = userTypeField.getText();
                        String s12 = addressField.getText();
                        String s13 = mobileNoField.getText();
                        String s14 = emailField.getText();
                        if (s1.isEmpty() || s2.isEmpty() || s4.isEmpty() || s5.isEmpty() || s6.isEmpty() || s7.isEmpty() || s8.isEmpty() || s9.isEmpty() || s10.isEmpty() || s11.isEmpty() || s12.isEmpty() || s13.isEmpty() || s14.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "All fields are required!");
                            return;
                        }

                        try {
                            String q = "insert into receptionists values('"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"', '"+s5+"', '"+s6+"', '"+s7+"', '"+s8+"', '"+s9+"', '"+s10+"', '"+s11+"', '"+s12+"', '"+s13+"', '"+s14+"')";
                            String q1 = "insert into users(Username, Password, UserType) values('"+s5+"', '"+s6+"', '"+s11+"')";
                            c.statement.executeUpdate(q);
                            c.statement.executeUpdate(q1);
                            JOptionPane.showMessageDialog(null, "Receptionist Added Successfully");
                            JOptionPane.showMessageDialog(null, "Receptionist Login Username : " + s5 + " Password : " + s6 + " UserType : " + s11);
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
        b2.setBounds(540, 380, 120, 40);
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

    public void ViewReceptionists() {
        JFrame frame = new JFrame();
        frame.setBounds(0, 90, 1400, 780);
        frame.getContentPane().setBackground(new Color(109, 164, 170));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); // Use null layout for precise positioning
        contentPanel.setBackground(new Color(109, 164, 170));

        JLabel label1 = new JLabel("ALL RECEPTIONIST'S DATA");
        label1.setBounds(550, 10, 500, 50);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.BLACK);
        contentPanel.add(label1);

        JTable table = new JTable();
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));

        // Wrap the table in a JScrollPane
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(10, 70, 1340, 500);
        tableScrollPane.setBackground(new Color(109, 164, 170));
        contentPanel.add(tableScrollPane);

        try {
            conn c = new conn();
            String q = "select * from receptionists";
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

    public void ViewReceptionist() {
        JFrame frame = new JFrame();
        frame.setBounds(0, 90, 1400, 780);
        frame.getContentPane().setBackground(new Color(109, 164, 170));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); // Use null layout for precise positioning
        contentPanel.setBackground(new Color(109, 164, 170));

        JLabel label1 = new JLabel("ALL RECEPTIONIST'S DATA");
        label1.setBounds(550, 10, 500, 50);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.BLACK);
        contentPanel.add(label1);

        JTable table = new JTable();
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));

        // Wrap the table in a JScrollPane
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(10, 70, 1340, 500);
        tableScrollPane.setBackground(new Color(109, 164, 170));
        contentPanel.add(tableScrollPane);

        try {
            conn c = new conn();
            String q = "select ID, Receptionist_Name, Age, Gender, Mobile_No, Email from receptionists";
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

    public void EditReceptionistDetails() {
        // frame
        JFrame frame = new JFrame();
        frame.setSize(820, 460);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img25.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 460, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 460);
        frame.add(background);

        // page heading
        JLabel heading = new JLabel("* MODIFY RECEPTIONIST DETAILS *");
        heading.setBounds(250, 10, 600, 50);
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
        Choice choice = new Choice();
        choice.setBounds(230, 80, 150, 20);
        choice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        choice.setBackground(new Color(3, 45, 48));
        choice.setForeground(Color.white);
        background.add(choice);

        // Fetch the available username from receptionist
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from receptionists");
            while(resultSet.next()) {
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

        JTextField qualificationField = new JTextField();
        qualificationField.setBounds(230, 240, 150, 20);
        qualificationField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        qualificationField.setForeground(Color.BLACK);
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
        JTextField passwordField = new JTextField();
        passwordField.setBounds(620, 80, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setForeground(Color.BLACK);
        passwordField.setEditable(false);
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
        background.add(addressField);

        JTextField emailField = new JTextField();
        emailField.setBounds(620, 320, 150, 20);
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        emailField.setForeground(Color.BLACK);
        background.add(emailField);

        JButton check = new JButton("Check");
        check.setBounds(130, 380, 120, 40);
        check.setFont(new Font("Tahoma", Font.BOLD, 18));
        check.setForeground(Color.white);
        check.setBackground(Color.GREEN);
        background.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = choice.getSelectedItem().trim();

                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please select Username and enter Password.");
                    return;
                }
                try {
                    conn c = new conn();
                    String query = "select * from receptionists where Username = ?";
                    PreparedStatement ps = c.connection.prepareStatement(query);
                    ps.setString(1, username);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
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
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(310, 380, 200, 40);
        update.setFont(new Font("Tahoma", Font.BOLD, 18));
        update.setForeground(Color.white);
        update.setBackground(Color.BLUE);
        background.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = choice.getSelectedItem().trim();
                String password = passwordField.getText().trim();
                String receptionistName = nameField.getText().trim();
                String idProf = idProfField.getText().trim();
                String idProfNo = idProfNoField.getText().trim();
                String age = ageField.getText().trim();
                String gender = r1.isSelected() ? "Male" : "Female";
                String qualification = qualificationField.getText();
                String joiningDate = joiningDateField.getText();
                String usertype = userTypeField.getText();
                String address = addressField.getText().trim();
                String mobileNo = mobileNoField.getText().trim();
                String email = emailField.getText().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Username and Password are required!");
                    return;
                }

                try {
                    conn c = new conn();
                    String query = "UPDATE receptionists SET Receptionist_Name = ?, ID_Prof = ?, ID_Prof_No = ?, Age = ?, Gender = ?, Qualification = ?, Joining_Date = ?, UserType = ?, Address = ?, Mobile_No = ?, Email = ? WHERE Username = ? AND Password = ?";
                    PreparedStatement ps = c.connection.prepareStatement(query);

                    ps.setString(1, receptionistName);
                    ps.setString(2, idProf);
                    ps.setString(3, idProfNo);
                    ps.setString(4, age);
                    ps.setString(5, gender);
                    ps.setString(6, qualification);
                    ps.setString(7, joiningDate);
                    ps.setString(8, usertype);
                    ps.setString(9, address);
                    ps.setString(10, mobileNo);
                    ps.setString(11, email);
                    ps.setString(12, username);
                    ps.setString(13, password);

                    int rowsUpdated = ps.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(frame, "Receptionist details updated successfully!");
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
        back.setBounds(570, 380, 120, 40);
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

    public void DeleteReceptionistAccount() {
        JFrame frame = new JFrame();
        frame.setSize(820, 260);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img6.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 260, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 260);
        frame.add(background);

        JLabel heading = new JLabel("* DELETE RECEPTIONIST RECORDS *");
        heading.setBounds(280, 20, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        background.add(heading);

        JLabel label1 = new JLabel("Username");
        label1.setBounds(30, 80, 120, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        label1.setForeground(Color.BLACK);
        background.add(label1);

        JLabel label2 = new JLabel("Receptionist ID");
        label2.setBounds(30, 120, 200, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label2.setForeground(Color.BLACK);
        background.add(label2);

        Choice choice = new Choice();
        choice.setBounds(230, 80, 150, 30);
        background.add(choice);

        // Populate the choice with usernames from the database
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT Username FROM receptionists");
            while (rs.next()) {
                choice.add(rs.getString("Username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Failed to load usernames.");
        }

        JTextField idField = new JTextField();
        idField.setBounds(230, 120, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idField.setForeground(Color.BLACK);
        background.add(idField);

        JLabel label3 = new JLabel("Password");
        label3.setBounds(430, 80, 200, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 16));
        label3.setForeground(Color.BLACK);
        background.add(label3);

        JLabel label4 = new JLabel("Receptionist Name");
        label4.setBounds(430, 120, 200, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 16));
        label4.setForeground(Color.BLACK);
        background.add(label4);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(620, 80, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setForeground(Color.BLACK);
        background.add(passwordField);

        JTextField nameField = new JTextField();
        nameField.setBounds(620, 120, 150, 20);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Color.BLACK);
        background.add(nameField);

        JButton check = new JButton("Check");
        check.setBounds(130, 180, 120, 40);
        check.setFont(new Font("Tahoma", Font.BOLD, 18));
        check.setForeground(Color.white);
        check.setBackground(Color.GREEN);
        background.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = choice.getSelectedItem().trim();
                String password = passwordField.getText().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please select Username and enter Password.");
                    return;
                }
                try {
                    conn c = new conn();
                    String query = "select * from receptionists where Username = ? and Password = ?";
                    PreparedStatement ps = c.connection.prepareStatement(query);
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        idField.setText(rs.getString("ID"));
                        nameField.setText(rs.getString("Receptionist_Name"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(335, 180, 150, 40);
        deleteButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(Color.RED);
        background.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = choice.getSelectedItem();
                String password = passwordField.getText();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Username and Password are required!");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to delete this patient record?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        conn c = new conn();
                        String query = "DELETE FROM receptionists WHERE Username = ? and Password = ?";
                        PreparedStatement ps = c.connection.prepareStatement(query);

                        ps.setString(1, username);
                        ps.setString(2, password);
                        int rowsDeleted = ps.executeUpdate();
                        if (rowsDeleted > 0) {
                            JOptionPane.showMessageDialog(frame, "Receptionist record deleted successfully!");
                            String query2 = "DELETE FROM users WHERE Username = ?";
                            PreparedStatement ps2 = c.connection.prepareStatement(query2);
                            ps2.setString(1, username);
                            ps2.executeUpdate();

                            JOptionPane.showMessageDialog(frame, "Doctor Username and Password deleted successfully!");
                            choice.remove(username); // Remove from dropdown
                            frame.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(frame, "No record found with the selected username.");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "An error occurred while deleting the record.");
                    }
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(570, 180, 120, 40);
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
        frame.setVisible(true);
    }

    public void EditProfileDetails() {
        // frame
        JFrame frame = new JFrame();
        frame.setSize(820, 460);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img25.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 460, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 460);
        frame.add(background);

        // page heading
        JLabel heading = new JLabel("* MODIFY PROFILE " + loggedInUsername.toUpperCase() + " *");
        heading.setBounds(250, 10, 600, 50);
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
        background.add(emailField);

        try {
            conn c = new conn();
            String query = "SELECT * FROM receptionists WHERE username = ?";
            PreparedStatement stmt = c.connection.prepareStatement(query);
            stmt.setString(1, loggedInUsername);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usernameField.setText(rs.getString("Username"));
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

        JButton update = new JButton("Update");
        update.setBounds(200, 390, 150, 40);
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
                    String query = "UPDATE receptionists SET Mobile_No = ?, Email = ? WHERE Username = ? AND Password = ?";
                    PreparedStatement ps = c.connection.prepareStatement(query);

                    ps.setString(10, mobileNo);
                    ps.setString(11, email);
                    ps.setString(12, username);
                    ps.setString(13, password);

                    int rowsUpdated = ps.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(frame, "Receptionist details updated successfully!");
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
        back.setBounds(500, 390, 120, 40);
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
        String testUsername = "shreya1";
        Receptionist receptionist = new Receptionist(databaseConnection, testUsername);
//        receptionist.AddNewReceptionist();
//        receptionist.ViewReceptionist();
//        receptionist.EditReceptionistDetails();
        receptionist.DeleteReceptionistAccount();
    }
}
