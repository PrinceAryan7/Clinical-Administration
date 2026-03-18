package Clinical.Administration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientPage {

    private final JFrame frame;
    private final String loggedInUsername;
    private final Profile profile;
    private final Patient patient;
    private final Doctor doctor;
    private final Appointment appointment;

    public PatientPage(String username) {
        this.loggedInUsername = username;
        // Initialize connection and appointment
        conn c = new conn();
        patient = new Patient(c, loggedInUsername);
        doctor = new Doctor(c, loggedInUsername);
        appointment = new Appointment(c, loggedInUsername);
        profile = new Profile(c, loggedInUsername);

        frame = new JFrame("Welcome To Patient Home Page - " + loggedInUsername.toUpperCase());
        frame.setSize(1400, 780);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Automatically open in full-screen

        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img41.jpg");
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

        // Doctor menu
        JMenu doctorMenu = new JMenu("Doctor");
        doctorMenu.setFont(new Font("Arial", Font.BOLD, 15));
        doctorMenu.setForeground(Color.white);

        JMenuItem doctorRecords = new JMenuItem("Doctor Records");

        doctorRecords.setFont(new Font("Arial", Font.BOLD, 13));
        doctorMenu.add(doctorRecords);
        menuBar.add(doctorMenu);

        // Appointment menu
        JMenu appointmentMenu = new JMenu("Appointment");
        appointmentMenu.setFont(new Font("Arial", Font.BOLD, 14));
        appointmentMenu.setForeground(Color.white);

        JMenuItem appointmentBooking = new JMenuItem("Appointment Booking");
        JMenuItem appointmentRecords = new JMenuItem("Appointment Records");
        JMenuItem appointmentRescheduling = new JMenuItem("Appointment Rescheduling");
        JMenuItem appointmentCancellation = new JMenuItem("Appointment Cancellation");

        appointmentBooking.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentRecords.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentRescheduling.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentCancellation.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentMenu.add(appointmentBooking);
        appointmentMenu.add(appointmentRecords);
        appointmentMenu.add(appointmentRescheduling);
        appointmentMenu.add(appointmentCancellation);
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

        frame.setJMenuBar(menuBar);
        frame.setLayout(null);
        frame.setVisible(true);

        // Action Listeners for menu items
        myProfile.addActionListener(e -> profile.PatientProfile());
        editProfile.addActionListener(e -> patient.EditProfileDetails());
        doctorRecords.addActionListener(e -> doctor.ViewDoctors());
        appointmentBooking.addActionListener(e -> appointment.BookAppointments());
        appointmentRecords.addActionListener(e -> appointment.ViewAppointmentsPatient());
        appointmentRescheduling.addActionListener(e -> appointment.RescheduleAppointment());
        appointmentCancellation.addActionListener(e -> appointment.CancelAppointment());
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
        new PatientPage("aditya1");
    }
}
