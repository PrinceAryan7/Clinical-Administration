package Clinical.Administration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffPage {
    private final JFrame frame;
    private final String loggedInUsername;
    private final Patient patient;
    private final Doctor doctor;
    private final Appointment appointment;
    private final Staff staff;
    private final Receptionist receptionist;
    private final Profile profile;

    public StaffPage(String username) {
        this.loggedInUsername = username;

        // Initialize connection and appointment
        conn c = new conn();
        patient = new Patient(c, loggedInUsername);
        doctor = new Doctor(c, loggedInUsername);
        staff = new Staff(c, loggedInUsername);
        appointment = new Appointment(c, loggedInUsername);
        receptionist = new Receptionist(c, loggedInUsername);
        profile = new Profile(c, loggedInUsername);

        // Create the frame
        frame = new JFrame("Welcome To Staff Home Page - " + loggedInUsername.toUpperCase());
        frame.setSize(1400, 780);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Automatically open in full-screen

        // Add background image
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img52.jpg");
        Image image = backgroundIcon.getImage().getScaledInstance(1400, 780, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(image);
        JLabel background = new JLabel(backgroundIcon);
        background.setSize(1400, 780);
        frame.add(background);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(3, 45, 48));
        menuBar.setForeground(Color.white);

        // Profile menu
        JMenu profileMenu = new JMenu("My Account");
        profileMenu.setFont(new Font("Arial", Font.BOLD, 15));
        profileMenu.setForeground(Color.white);

        JMenuItem myProfile = new JMenuItem("My Profile");
        JMenuItem editProfile = new JMenuItem("Edit Profile");
        myProfile.setFont(new Font("Arial", Font.BOLD, 13));
        editProfile.setFont(new Font("Arial", Font.BOLD, 13));
        profileMenu.add(myProfile);
        profileMenu.add(editProfile);
        menuBar.add(profileMenu);

        // Receptionist menu
        JMenu receptionistMenu = new JMenu("Receptionist");
        receptionistMenu.setFont(new Font("Arial", Font.BOLD, 15));
        receptionistMenu.setForeground(Color.WHITE);

        JMenuItem receptionistRecords = new JMenuItem("Receptionist Records");

        receptionistRecords.setFont(new Font("Arial", Font.BOLD, 13));
        receptionistMenu.add(receptionistRecords);
        menuBar.add(receptionistMenu);

        // Doctor menu
        JMenu doctorMenu = new JMenu("Doctor");
        doctorMenu.setFont(new Font("Arial", Font.BOLD, 15));
        doctorMenu.setForeground(Color.white);

        JMenuItem doctorRecords = new JMenuItem("Doctor Records");

        doctorRecords.setFont(new Font("Arial", Font.BOLD, 13));
        doctorMenu.add(doctorRecords);
        menuBar.add(doctorMenu);

        // Patients menu
        JMenu patientMenu = new JMenu("Patient");
        patientMenu.setFont(new Font("Arial", Font.BOLD, 15));
        patientMenu.setForeground(Color.white);

        JMenuItem patientRecords = new JMenuItem("Patient Records");

        patientRecords.setFont(new Font("Arial", Font.BOLD, 13));
        patientMenu.add(patientRecords);
        menuBar.add(patientMenu);

        // Appointments menu
        JMenu appointmentMenu = new JMenu("Appointments");
        appointmentMenu.setFont(new Font("Arial", Font.BOLD, 15));
        appointmentMenu.setForeground(Color.WHITE);

        JMenuItem appointmentsRecords = new JMenuItem("Appointments Records");

        appointmentsRecords.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentMenu.add(appointmentsRecords);
        menuBar.add(appointmentMenu);

        // Logout button
        JButton b1 = new JButton("Logout");
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.setForeground(Color.ORANGE);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logoutAction();
            }
        });
        menuBar.add(b1);

        // Add menu bar to the frame
        frame.setJMenuBar(menuBar);

        // Set frame properties
        frame.setLayout(null);
        frame.setVisible(true);

        // Action listeners for menu items
        myProfile.addActionListener(e -> profile.StaffProfile());
        editProfile.addActionListener(e -> staff.EditProfileDetails());
        patientRecords.addActionListener(e -> patient.ViewPatients());
        doctorRecords.addActionListener(e -> doctor.ViewDoctors());
        receptionistRecords.addActionListener(e -> receptionist.ViewReceptionist());
        appointmentsRecords.addActionListener(e -> appointment.ViewAppointmentsAll());
    }

    private void logoutAction() {
        // Display a confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
                frame, // Use the stored frame as the parent component
                "Are you sure you want to logout?",
                "Logout Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        // Check user's response
        if (confirm == JOptionPane.YES_OPTION) {
            // Close the current frame
            JOptionPane.showMessageDialog(frame, "You have been logged out.");
            frame.dispose(); // Dispose of the stored frame

            // Optionally redirect to the login page
            new Login();
        }
    }

    public static void main(String[] args) {
        new StaffPage("staff");
    }
}
