package Clinical.Administration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    JButton b2, b3, b4, b5;
    private final JLabel imageLabel;
    private int currentImageIndex = 0;
    private final String[] imagePaths = {
            "C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img47.jpg",
            "C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img44.jpg",
            "C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img58.jpg",
            "C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img52.jpg",
            "C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img53.jpg",
            "C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img54.jpg",
            "C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img55.jpg",
            "C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img41.jpg",
            "C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img42.jpg",
            "C:\\Users\\prince\\OneDrive\\Desktop\\Java\\Project\\Clinical Administration\\src\\icon\\img45.jpg"
    };

    Main() {

        JFrame frame = new JFrame("Main Page");
        frame.setSize(1400, 780);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Automatically open in full-screen

        JLabel title = new JLabel("WELCOME TO");
        title.setBounds(20, 10, 200, 25);
        title.setForeground(Color.red);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        frame.add(title);

        JLabel title1 = new JLabel("Clinical Administration");
        title1.setBounds(20, 20, 800, 100);
        title1.setFont(new Font("Arial", Font.BOLD, 50));
        title1.setForeground(new Color(0, 86, 179));
        frame.add(title1);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 120, 1400, 50);
        buttonPanel.setBackground(Color.GRAY); // Set background color
        buttonPanel.setLayout(null); // Use absolute layout
        frame.add(buttonPanel);

        b2 = new JButton("AboutUs");
        b2.setBounds(20, 10, 110, 30);
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        b2.setContentAreaFilled(false);
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b2.setForeground(Color.BLACK);
        buttonPanel.add(b2);
        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b2.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b2.setForeground(Color.BLACK);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(AboutUs::new);
            }
        });


        b3 = new JButton("Notification");
        b3.setBounds(130, 10, 200, 30);
        b3.setFont(new Font("Arial", Font.BOLD, 18));
        b3.setContentAreaFilled(false);
        b3.setBorderPainted(false);
        b3.setFocusPainted(false);
        b3.setForeground(Color.BLACK);
        buttonPanel.add(b3);
        b3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b3.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b3.setForeground(Color.BLACK);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
                     JOptionPane.showMessageDialog(null, "No Notification!");
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
            }
        });

        b4 = new JButton("Login");
        b4.setBounds(1150, 10, 100, 30);
        b4.setFont(new Font("Arial", Font.BOLD, 18));
        b4.setContentAreaFilled(false);
        b4.setBorderPainted(false);
        b4.setFocusPainted(false);
        b4.setForeground(Color.BLACK);
        buttonPanel.add(b4);
        b4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b4.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b4.setForeground(Color.BLACK);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
            }
        });

        b5 = new JButton("Exit");
        b5.setBounds(1250, 10, 100, 30);
        b5.setFont(new Font("Arial", Font.BOLD, 18));
        b5.setContentAreaFilled(false);
        b5.setBorderPainted(false);
        b5.setFocusPainted(false);
        b5.setForeground(Color.BLACK);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitAction();
            }
        });
        buttonPanel.add(b5);
        b5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b5.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b5.setForeground(Color.BLACK);
            }
        });

        // Create a label to display images
        imageLabel = new JLabel();
        imageLabel.setBounds(0, 150, 1400, 650);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        updateImage();

        frame.add(imageLabel, BorderLayout.CENTER);

        // Create a timer to update the image
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex = (currentImageIndex + 1) % imagePaths.length;
                updateImage();
            }
        });
        timer.start();

        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void exitAction() {
        // Display a confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to exit?",
                "Exit Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        // Check user's response
        if (confirm == JOptionPane.YES_OPTION) {
            // Close the current frame
            JOptionPane.showMessageDialog(null, "You have been exited.");
            System.exit(0);
        }
    }

    // Method to update the displayed image
    private void updateImage() {
        ImageIcon icon = new ImageIcon(imagePaths[currentImageIndex]);
        Image scaledImage = icon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
    }

    public static void main(String[] args) {
         new Main();
    }
}
