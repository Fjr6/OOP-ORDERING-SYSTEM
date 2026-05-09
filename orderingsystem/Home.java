package orderingsystem;

import javax.swing.*;
import java.awt.*;

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

        setTitle("Ordering System - Home");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ===== BACKGROUND =====
        ImageIcon bgIcon = new ImageIcon(
                getClass().getResource("/orderingsystem/background.jpg")
        );

        Image img = bgIcon.getImage();
        Image scaledImg;
        scaledImg = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);

        JLabel background = new JLabel(new ImageIcon(scaledImg));
        background.setLayout(new BorderLayout());

        setContentPane(background);

        // ===== TOP PANEL =====
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setOpaque(false);

        JButton btnLogout = new JButton("Logout");
        JButton btnExit = new JButton("Exit");

        topPanel.add(btnLogout);
        topPanel.add(btnExit);
        
        topPanel.setOpaque(false);
        btnLogout.setOpaque(false);
        btnExit.setOpaque(false);  

        // ===== SIDE PANEL =====
        JPanel sidePanel = new JPanel(new GridLayout(4, 1, 10, 10));
        sidePanel.setOpaque(false);
        sidePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnPlaceOrder = new JButton("Place Order");
        JButton btnBills = new JButton("View Bills");
        JButton btnPassword = new JButton("Change Password");
        JButton btnSecurity = new JButton("Security Settings");

        sidePanel.add(btnPlaceOrder);
        sidePanel.add(btnBills);
        sidePanel.add(btnPassword);
        sidePanel.add(btnSecurity);

        // ===== CENTER PANEL =====
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false);

        JLabel title = new JLabel("Welcome to Ordering System", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.WHITE);

        centerPanel.add(title, BorderLayout.NORTH);

        // ===== ADMIN PANEL =====
        JPanel adminPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        adminPanel.setOpaque(false);
        adminPanel.setBorder(BorderFactory.createTitledBorder("Admin Controls"));

        JButton btnCategory = new JButton("Manage Category");
        JButton btnProduct = new JButton("New Product");
        JButton btnEdit = new JButton("Edit Products");
        JButton btnUsers = new JButton("Verify Users");

        adminPanel.add(btnCategory);
        adminPanel.add(btnProduct);
        adminPanel.add(btnEdit);
        adminPanel.add(btnUsers);

        // Hide admin controls for non-admin users
        if (email != null && !email.equals("admin@gmail.com")) {
            adminPanel.setVisible(false);
        }

        centerPanel.add(adminPanel, BorderLayout.CENTER);

        // ===== ADD PANELS =====
        add(topPanel, BorderLayout.NORTH);
        add(sidePanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

        // ===== BUTTON ACTIONS =====
        btnExit.addActionListener(e -> System.exit(0));

        btnLogout.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }
}