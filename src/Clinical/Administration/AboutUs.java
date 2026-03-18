package Clinical.Administration;

import javax.swing.*;

public class AboutUs {

    public AboutUs() {
        // Create JFrame
        JFrame frame = new JFrame("About Us");

        // Set full-screen mode
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Automatically open in full-screen

        // Create JEditorPane with styled content
        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html"); // Set content type to HTML
        editorPane.setText("""
                <html>
                    <body style='font-family: Arial; font-size: 14px;'>
                        <h1 style='text-align: center; text-color: blue;'>Clinical Administration</h1>
                        <h2>Project Overview:</h2>
                        <ul>
                            <li><b>Name:</b> Clinical Administration</li>
                            <li><b>Purpose:</b> To manage various aspects of a healthcare facility, including patient records, staff management, appointment scheduling, and more.</li>
                        </ul>
                       \s
                        <h2>Key Features:</h2>
                        <ul>
                            <li><b>User Roles:</b></li>
                            <ul>
                                <li>Admin</li>
                                <li>Receptionist</li>
                                <li>Doctor</li>
                                <li>Patient</li>
                                <li>Staff</li>
                            </ul>
                            <li><b>User Interface:</b></li>
                            <ul>
                                <li>Home Page: About Us, Notification, Login, Exit</li>
                                <li>User-Specific Pages: Admin Page, Receptionist Page, Doctor Page, etc.</li>
                            </ul>
                            <li><b>Core Functionality:</b></li>
                            <ul>
                                <li>User Registration and Login</li>
                                <li>User Profile Management (View & Edit)</li>
                                <li>Staff, Doctor, and Patient Management (Add, View, Edit, Delete)</li>
                                <li>Appointment Scheduling (Book, Reschedule, Cancel, Complete)</li>
                                <li>Data Storage using MySQL</li>
                            </ul>
                        </ul>

                        <h2>User Role Specific Access:</h2>
                        <ul>
                            <li><b>Admin:</b> Manage all aspects of the system.</li>
                            <li><b>Receptionist:</b> Manage patient and appointment scheduling.</li>
                            <li><b>Doctor:</b> Manage patient records and appointments.</li>
                            <li><b>Patient:</b> View doctors and manage appointments.</li>
                            <li><b>Staff:</b> Limited access based on assigned role.</li>
                        </ul>

                        <h2>Technical Considerations:</h2>
                        <ul>
                            <li><b>Programming Language:</b> Java</li>
                            <li><b>IDE:</b> Eclipse, IntelliJ IDEA</li>
                            <li><b>Database:</b> MySQL</li>
                            <li><b>Security:</b> Password hashing and encryption</li>
                        </ul>

                        <h2>Development Steps:</h2>
                        <ol>
                            <li><b>Design:</b>
                                <ul>
                                    <li>Create UML diagrams (class diagrams, use case diagrams) to model the system's structure and interactions.</li>
                                    <li>Design the database schema (tables, relationships).</li>
                                </ul>
                            </li>
                            <li><b>Implementation:</b>
                                <ul>
                                    <li>Develop the core Java classes (User, Admin, Receptionist, Doctor, Patient, Staff, Appointment).</li>
                                    <li>Implement the database connectivity and data access logic.</li>
                                    <li>Create the user interface (using Swing).</li>
                                    <li>Implement user authentication and authorization.</li>
                                    <li>Implement the business logic for each user role and feature.</li>
                                </ul>
                            </li>
                            <li><b>Testing:</b>
                                <ul>
                                    <li>Thoroughly test the application for functionality, usability, and security.</li>
                                    <li>Address any bugs or issues.</li>
                                </ul>
                            </li>
                            <li><b>Deployment:</b>
                                <ul>
                                    <li>Package the application for distribution.</li>
                                    <li>Consider deploying the application on a server for wider accessibility.</li>
                                </ul>
                            </li>
                        </ol>

                        <p>This outline provides a high-level overview of your Clinical Administration project.</p>
                    </body>
                </html>
               \s""");
        editorPane.setEditable(false); // Make the text non-editable

        // Add JScrollPane for scrollable content
        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Add scrollPane to frame
        frame.add(scrollPane);

        // Set frame visibility
        frame.setVisible(true);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(AboutUs::new);
//    }
}
