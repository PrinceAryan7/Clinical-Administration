package Clinical.Administration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage {

    private final JFrame frame;
    private final String loggedInUsername;
    private final Patient patient;
    private final Doctor doctor;
    private final Appointment appointment;
    private final Staff staff;
    private final Receptionist receptionist;
    private final Admin admin;
    private final Profile profile;

    public AdminPage(String username) {
        this.loggedInUsername = username;

        // Initialize connection and appointment
        conn c = new conn();
        patient = new Patient(c, loggedInUsername);
        doctor = new Doctor(c, loggedInUsername);
        appointment = new Appointment(c, loggedInUsername);
        staff = new Staff(c, loggedInUsername);
        receptionist = new Receptionist(c,loggedInUsername);
        admin = new Admin(c, loggedInUsername);
        profile = new Profile(c, loggedInUsername);

        frame = new JFrame("Welcome To Admin Home Page - " + loggedInUsername.toUpperCase());
        frame.setSize(1400, 780);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Automatically open in full-screen

        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Hospiital Management\\src\\icon\\img2.jpg");
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

        JMenuItem registerReceptionist = new JMenuItem("Register Receptionist");
        JMenuItem receptionistRecords = new JMenuItem("Receptionist Records");
        JMenuItem editReceptionistDetails = new JMenuItem("Edit Receptionist Details");
        JMenuItem deleteReceptionistAccount = new JMenuItem("Delete Receptionist Account");

        registerReceptionist.setFont(new Font("Arial", Font.BOLD, 13));
        receptionistRecords.setFont(new Font("Arial", Font.BOLD, 13));
        editReceptionistDetails.setFont(new Font("Arial", Font.BOLD, 13));
        deleteReceptionistAccount.setFont(new Font("Arial", Font.BOLD, 13));
        receptionistMenu.add(registerReceptionist);
        receptionistMenu.add(receptionistRecords);
        receptionistMenu.add(editReceptionistDetails);
        receptionistMenu.add(deleteReceptionistAccount);
        menuBar.add(receptionistMenu);

        // Doctor menu
        JMenu doctorMenu = new JMenu("Doctor");
        doctorMenu.setFont(new Font("Arial", Font.BOLD, 15));
        doctorMenu.setForeground(Color.white);

        JMenuItem registerDoctor = new JMenuItem("Register Doctor");
        JMenuItem doctorRecords = new JMenuItem("Doctor Records");
        JMenuItem editDoctorDetails = new JMenuItem("Edit Doctor Details");
        JMenuItem deleteDoctorAccount = new JMenuItem("Delete Doctor Account");

        registerDoctor.setFont(new Font("Arial", Font.BOLD, 13));
        doctorRecords.setFont(new Font("Arial", Font.BOLD, 13));
        editDoctorDetails.setFont(new Font("Arial", Font.BOLD, 13));
        deleteDoctorAccount.setFont(new Font("Arial", Font.BOLD, 13));
        doctorMenu.add(registerDoctor);
        doctorMenu.add(doctorRecords);
        doctorMenu.add(editDoctorDetails);
        doctorMenu.add(deleteDoctorAccount);
        menuBar.add(doctorMenu);

        // Patients menu
        JMenu patientMenu = new JMenu("Patient");
        patientMenu.setFont(new Font("Arial", Font.BOLD, 15));
        patientMenu.setForeground(Color.white);

        JMenuItem registerPatient = new JMenuItem("Register Patient");
        JMenuItem patientRecords = new JMenuItem("Patient Records");
        JMenuItem editPatientDetails = new JMenuItem("Edit Patient Details");
        JMenuItem dischargePatient = new JMenuItem("Discharge Patient");

        registerPatient.setFont(new Font("Arial", Font.BOLD, 13));
        patientRecords.setFont(new Font("Arial", Font.BOLD, 13));
        editPatientDetails.setFont(new Font("Arial", Font.BOLD, 13));
        dischargePatient.setFont(new Font("Arial", Font.BOLD, 13));
        patientMenu.add(registerPatient);
        patientMenu.add(patientRecords);
        patientMenu.add(editPatientDetails);
        patientMenu.add(dischargePatient);
        menuBar.add(patientMenu);

        // Staff menu
        JMenu staffMenu = new JMenu("Staff");
        staffMenu.setFont(new Font("Arial", Font.BOLD, 15));
        staffMenu.setForeground(Color.white);

        JMenuItem registerStaff = new JMenuItem("Register Staff");
        JMenuItem staffRecords = new JMenuItem("Staff Records");
        JMenuItem editStaffDetails = new JMenuItem("Edit Staff Details");
        JMenuItem deleteStaffAccount = new JMenuItem("Delete Staff Account");

        registerStaff.setFont(new Font("Arial", Font.BOLD, 13));
        staffRecords.setFont(new Font("Arial", Font.BOLD, 13));
        editStaffDetails.setFont(new Font("Arial", Font.BOLD, 13));
        deleteStaffAccount.setFont(new Font("Arial", Font.BOLD, 13));
        staffMenu.add(registerStaff);
        staffMenu.add(staffRecords);
        staffMenu.add(editStaffDetails);
        staffMenu.add(deleteStaffAccount);
        menuBar.add(staffMenu);

        // Appointment menu
        JMenu appointmentMenu = new JMenu("Appointment");
        appointmentMenu.setFont(new Font("Arial", Font.BOLD, 14));
        appointmentMenu.setForeground(Color.white);

        JMenuItem appointmentBooking = new JMenuItem("Appointment Booking");
        JMenuItem appointmentRecords = new JMenuItem("Appointment Records");
        JMenuItem editAppointmentDetails  = new JMenuItem("Edit Appointment Details");
        JMenuItem appointmentCompletion = new JMenuItem("Appointment Completion");
        JMenuItem appointmentRescheduling = new JMenuItem("Appointment Rescheduling");
        JMenuItem appointmentCancellation = new JMenuItem("Appointment Cancellation");

        appointmentBooking.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentRecords.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentRescheduling.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentCancellation.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentCompletion.setFont(new Font("Arial", Font.BOLD, 13));
        editAppointmentDetails.setFont(new Font("Arial", Font.BOLD, 13));
        appointmentMenu.add(appointmentBooking);
        appointmentMenu.add(appointmentRecords);
        appointmentMenu.add(editAppointmentDetails);
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
        myProfile.addActionListener(e -> profile.AdminProfile());
        editProfile.addActionListener(e -> admin.EditProfileDetails());
        registerReceptionist.addActionListener(e -> receptionist.AddNewReceptionist());
        receptionistRecords.addActionListener(e -> receptionist.ViewReceptionists());
        editReceptionistDetails.addActionListener(e -> receptionist.EditReceptionistDetails());
        deleteReceptionistAccount.addActionListener(e -> receptionist.DeleteReceptionistAccount());
        registerPatient.addActionListener(e -> patient.AddNewPatient());
        patientRecords.addActionListener(e -> patient.ViewPatient());
        dischargePatient.addActionListener(e -> patient.DischargePatient());
        editPatientDetails.addActionListener(e -> patient.EditPatientDetails());
        registerDoctor.addActionListener(e -> doctor.AddNewDoctor());
        doctorRecords.addActionListener(e -> doctor.ViewDoctor());
        editDoctorDetails.addActionListener(e -> doctor.EditDoctorDetails());
        deleteDoctorAccount.addActionListener(e -> doctor.DeleteDoctorAccount());
        registerStaff.addActionListener(e -> staff.AddNewStaff());
        staffRecords.addActionListener(e -> staff.ViewStaffs());
        editStaffDetails.addActionListener(e -> staff.EditStaffDetails());
        deleteStaffAccount.addActionListener(e -> staff.DeleteStaffAccount());
        appointmentBooking.addActionListener(e -> appointment.BookAppointment());
        appointmentRecords.addActionListener(e -> appointment.ViewAppointmentsAll());
        appointmentCompletion.addActionListener(e -> appointment.CompleteAppointment());
        appointmentRescheduling.addActionListener(e -> appointment.RescheduleAppointment());
        appointmentCancellation.addActionListener(e -> appointment.CancelAppointment());
        editAppointmentDetails.addActionListener(e -> appointment.EditAppointment());
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
        new AdminPage("admin");
    }
}
