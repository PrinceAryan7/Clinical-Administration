package Clinical.Administration;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

    private final JTextField textField;
    private final JPasswordField jPasswordField;
    private final JComboBox<String> comboBox;

    public Login() {
        JFrame frame = new JFrame("Login Page");
        frame.setSize(400, 310);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        // Adding a login background image
        ImageIcon loginBackgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Hospiital Management\\src\\icon\\img6.jpg");
        Image image = loginBackgroundIcon.getImage().getScaledInstance(400, 310, Image.SCALE_DEFAULT);
        loginBackgroundIcon = new ImageIcon(image);
        JLabel backgroundLogin = new JLabel(loginBackgroundIcon);
        backgroundLogin.setSize(400, 310);
        frame.add(backgroundLogin);

        JLabel title = new JLabel("Login Page");
        title.setBounds(140, 10, 300, 50);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.BLACK);
        backgroundLogin.add(title);

        // Adding components
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40, 80, 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        namelabel.setForeground(Color.BLACK);
        backgroundLogin.add(namelabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 130, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 18));
        password.setForeground(Color.BLACK);
        backgroundLogin.add(password);

        textField = new JTextField();
        textField.setBounds(220, 80, 150, 30);
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        textField.setForeground(Color.BLACK);
        backgroundLogin.add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(220, 130, 150, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jPasswordField.setForeground(Color.BLACK);
        backgroundLogin.add(jPasswordField);

        JLabel userType = new JLabel("UserType");
        userType.setBounds(40, 180, 100, 30);
        userType.setFont(new Font("Tahoma", Font.BOLD, 18));
        userType.setForeground(Color.BLACK);
        backgroundLogin.add(userType);

        comboBox = new JComboBox<>(new String[]{"Admin", "Receptionist", "Doctor", "Patient", "Staff"});
        comboBox.setBounds(220, 180, 150, 30);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setForeground(Color.white);
        backgroundLogin.add(comboBox);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 250, 120, 30);
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        loginButton.setBackground(Color.GREEN);
        loginButton.setForeground(Color.BLACK);
        loginButton.addActionListener(e -> handleLogin(frame));
        backgroundLogin.add(loginButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(235, 250, 120, 30);
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.white);
        cancelButton.addActionListener(e -> frame.dispose());
        backgroundLogin.add(cancelButton);

        frame.add(backgroundLogin);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void handleLogin(JFrame frame) {
        String username = textField.getText().trim();
        String password = new String(jPasswordField.getPassword()).trim();
        String userType = (String) comboBox.getSelectedItem();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            if (authenticateUser(username, password, userType)) {
                JOptionPane.showMessageDialog(null, "Login Successful!");
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean authenticateUser(String username, String password, String userType) throws SQLException {
        conn c = new conn();
        String query = "SELECT UserType FROM users WHERE username = ? AND password = ? AND usertype = ?";

        try (PreparedStatement stmt = c.connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, userType);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                switch (userType) {
                    case "Admin" -> new AdminPage(username);
                    case "Receptionist" -> new ReceptionPage(username);
                    case "Doctor" -> new DoctorPage(username);
                    case "Patient" -> new PatientPage(username);
                    case "Staff" -> new StaffPage(username);
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Login();
    }
}
