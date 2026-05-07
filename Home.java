package orderingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Home extends JFrame {

    private String email;

    public Home() {
        initUI();
    }

    public Home(String email) {
        this.email = email;
        initUI();
    }

    private void initUI() {

    private void initUI() {

    setTitle("Ordering System - Home");
    setSize(900, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // ===== BACKGROUND IMAGE =====
    ImageIcon bgIcon = new ImageIcon(
        getClass().getResource("/orderingsystem/background.jpg")
    );

    Image img = bgIcon.getImage();
    Image scaledImg = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);

    JLabel background = new JLabel(new ImageIcon(scaledImg));
    background.setLayout(new BorderLayout());

    setContentPane(background);

    // rest of your code below...
        

        // ===== TOP PANEL =====
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnLogout = new JButton("Logout");
        JButton btnExit = new JButton("Exit");

        btnLogout.addActionListener(e -> logout());
        btnExit.addActionListener(e -> exitApp());

        topPanel.add(btnLogout);
        topPanel.add(btnExit);
        
        topPanel.setOpaque(false);
        btnLogout.setOpaque(false);
        btnExit.setOpaque(false);

        // ===== SIDEBAR =====
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(6, 1, 10, 10));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnPlaceOrder = new JButton("Place Order");
        JButton btnBills = new JButton("View Bills");
        JButton btnChangePassword = new JButton("Change Password");
        JButton btnSecurity = new JButton("Security Settings");

        sidePanel.add(btnPlaceOrder);
        sidePanel.add(btnBills);
        sidePanel.add(btnChangePassword);
        sidePanel.add(btnSecurity);

        // ===== ADMIN PANEL =====
        JPanel adminPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        adminPanel.setBorder(BorderFactory.createTitledBorder("Admin Controls"));

        JButton btnCategory = new JButton("Manage Category");
        JButton btnProduct = new JButton("New Product");
        JButton btnEditProduct = new JButton("Edit Products");
        JButton btnUsers = new JButton("Verify Users");

        adminPanel.add(btnCategory);
        adminPanel.add(btnProduct);
        adminPanel.add(btnEditProduct);
        adminPanel.add(btnUsers);

        // Hide admin controls if not admin
        if (email != null && !email.equals("admin@gmail.com")) {
            adminPanel.setVisible(false);
        }

        // ===== MAIN CONTENT =====
        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to Ordering System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));

        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        mainPanel.add(adminPanel, BorderLayout.CENTER);

        // ===== ADD TO FRAME =====
        add(topPanel, BorderLayout.NORTH);
        add(sidePanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(this, "Logout?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
            new Login().setVisible(true);
        }
    }

    private void exitApp() {
        int confirm = JOptionPane.showConfirmDialog(this, "Exit application?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home().setVisible(true));
    }
}
