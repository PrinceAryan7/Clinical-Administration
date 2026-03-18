package Clinical.Administration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorPage {

    private final JFrame frame;
    private final String loggedInUsername;
    private final Profile profile;
    private final Patient patient;
    private final Doctor doctor;
    private final Appointment appointment;
    private final Staff staff;
    private final Receptionist receptionist;

    public DoctorPage(String username) {
        this.loggedInUsername = username;

        // Initialize connection and appointment
        conn c = new conn();
        patient = new Patient(c, loggedInUsername);
        doctor = new Doctor(c, loggedInUsername);
        appointment = new Appointment(c, loggedInUsername);
        staff = new Staff(c, loggedInUsername);
        receptionist = new Receptionist(c, loggedInUsername);
        profile = new Profile(c, loggedInUsername);

        frame = new JFrame("Welcome To Doctor Home Page - " + loggedInUsername.toUpperCase());
        frame.setSize(1400, 780);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Automatically open in full-screen

        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Hospiital Management\\src\\icon\\img42.jpg");
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

        // Patients menu
        JMenu patientMenu = new JMenu("Patient");
        patientMenu.setFont(new Font("Arial", Font.BOLD, 15));
        patientMenu.setForeground(Color.white);

        JMenuItem patientRecords = new JMenuItem("Patient Records");
        JMenuItem editPatientDetails = new JMenuItem("Edit Patient Details");
        patientRecords.setFont(new Font("Arial", Font.BOLD, 13));
        editPatientDetails.setFont(new Font("Arial", Font.BOLD, 13));
        patientMenu.add(patientRecords);
        patientMenu.add(editPatientDetails);
        menuBar.add(patientMenu);

        // Staff menu
        JMenu staffMenu = new JMenu("Staff");
        staffMenu.setFont(new Font("Arial", Font.BOLD, 15));
        staffMenu.setForeground(Color.white);

        JMenuItem staffRecords = new JMenuItem("Staff Records");
        staffRecords.setFont(new Font("Arial", Font.BOLD, 13));
        staffMenu.add(staffRecords);
        menuBar.add(staffMenu);

        // Appointment menu
        JMenu appointmentMenu = new JMenu("Appointment");
        appointmentMenu.setFont(new Font("Arial", Font.BOLD, 14));
        appointmentMenu.setForeground(Color.white);

        JMenuItem appointmentRecords = new JMenuItem("Appointment Records");
        JMenuItem appointmentCompletion = new JMenuItem("Appointment Completion");
        JMenuItem appointmentRescheduling = new JMenuItem("Appointment Rescheduling");
        JMenuItem appointmentCancellation = new JMenuItem("Appointment Cancellation");
        appointmentRecords.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentCompletion.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentRescheduling.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentCancellation.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentMenu.add(appointmentRecords);
        appointmentMenu.add(appointmentCompletion);
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
        myProfile.addActionListener(e -> profile.DoctorProfile());
        editProfile.addActionListener(e -> doctor.EditProfileDetails());
        receptionistRecords.addActionListener(e -> receptionist.ViewReceptionist());
        patientRecords.addActionListener(e -> patient.ViewPatients());
        editPatientDetails.addActionListener(e -> patient.EditPatientsDetails());
        staffRecords.addActionListener(e -> staff.ViewStaff());
        appointmentRecords.addActionListener(e -> appointment.ViewAppointmentsDoctor(loggedInUsername));
        appointmentCompletion.addActionListener(e -> appointment.CompleteAppointment());
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
        new DoctorPage("doctor123");
    }
}
