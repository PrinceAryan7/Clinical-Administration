package Clinical.Administration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
    private final conn c;
    private final String loggedInUsername;

    public Admin(conn c, String loggedInUsername) {
        this.c = c;
        this.loggedInUsername = loggedInUsername;
    }

    public void EditProfileDetails() {
        // frame
        JFrame frame = new JFrame();
        frame.setSize(820, 375);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // background image getting
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Hospiital Management\\src\\icon\\img25.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(820, 375, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(820, 375);
        frame.add(background);

        // page heading
        JLabel heading = new JLabel("* MODIFY PROFILE - " + loggedInUsername.toUpperCase() + " *");
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
        background.add(emailField);

        try {
            conn c = new conn();
            String query = "SELECT * FROM admins WHERE username = ?";
            PreparedStatement stmt = c.connection.prepareStatement(query);
            stmt.setString(1, loggedInUsername);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usernameField.setText(rs.getString("Username"));
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

        JButton update = new JButton("Update");
        update.setBounds(200, 300, 150, 40);
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
                    String query = "UPDATE admins SET Mobile_No = ?, Email = ? WHERE Username = ? AND Password = ?";
                    PreparedStatement ps = c.connection.prepareStatement(query);

                    ps.setString(1, mobileNo);
                    ps.setString(2, email);
                    ps.setString(3, username);
                    ps.setString(4, password);

                    int rowsUpdated = ps.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(frame, "Admin details updated successfully!");
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
        back.setBounds(500, 300, 120, 40);
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
        String testUsername = "admin";
        Admin admin = new Admin(databaseConnection, testUsername);
        admin.EditProfileDetails();
    }
}
