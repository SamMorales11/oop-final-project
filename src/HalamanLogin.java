import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalamanLogin extends JFrame {
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JButton buttonLogin;

    public HalamanLogin() {
        setTitle("Halaman Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel labelUsername = new JLabel("Username:");
        textFieldUsername = new JTextField();
        JLabel labelPassword = new JLabel("Password:");
        passwordField = new JPasswordField();
        buttonLogin = new JButton("Login");

        panel.add(labelUsername);
        panel.add(textFieldUsername);
        panel.add(labelPassword);
        panel.add(passwordField);
        panel.add(new JLabel()); // Placeholder for spacing
        panel.add(buttonLogin);

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("admin") && password.equals("07889213")) {
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(HalamanLogin.this, "Username atau password salah!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HalamanLogin login = new HalamanLogin();
                login.setVisible(true);
            }
        });
    }
}
