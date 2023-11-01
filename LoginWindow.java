import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    private static final String usernameDefault = "admin";
    private static final String passwordDefault = "da";

    public LoginWindow() {
        setTitle("Autentificare");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(400, 200));
        setLocationRelativeTo(null);  

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Vă rugăm să vă autentificați:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(titleLabel);

        JLabel usernameLabel = new JLabel("Nume de utilizator:");
        loginPanel.add(usernameLabel);
        usernameField = new JTextField(20);
        loginPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Parolă:");
        loginPanel.add(passwordLabel);
        passwordField = new JPasswordField(20);
        loginPanel.add(passwordField);

        JButton loginButton = new JButton("Autentificare");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();  
                String passwordStr = new String(password);  
                if (autentificareCorecta(username, passwordStr)) {
                    dispose();  
                    Main.createAndShowGUI();
                } else {
                    JOptionPane.showMessageDialog(null, "Nume de utilizator sau parolă incorecte");
                }
            }
        });

        add(loginPanel);
        setVisible(true);
    } 
    private boolean autentificareCorecta(String username, String password) {
        return username.equals(usernameDefault) && password.equals(passwordDefault);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginWindow();
    });
    }
}