import javax.swing.*;
import java.awt.*;
import helper_classes.*;

public class Login extends JFrame {

    private static final String APP_ICON_CLASSPATH = "/resources/icons/32.png";
    private static final String APP_ICON_FILEPATH  = "./resources/icons/32.png";

    public Login() {
        // ================= FRAME =================
        setTitle("Palestra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(660, 357);
        setMinimumSize(new Dimension(500, 300));
        setLocationRelativeTo(null);

        // ================= ICONA =================
        ImageIcon icon;
        java.net.URL iconUrl = getClass().getResource(APP_ICON_CLASSPATH);
        icon = (iconUrl != null) ? new ImageIcon(iconUrl) : new ImageIcon(APP_ICON_FILEPATH);
        setIconImage(icon.getImage());

        // ================= ROOT =================
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(Color.decode("#1e1e1e"));
        setContentPane(root);

        // ================= WRAPPER CENTRANTE =================
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setBackground(Color.decode("#1e1e1e"));

        // ================= PANEL LOGIN (ORIGINALE) =================
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.decode("#1e1e1e"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.weightx = 1;

        // ===== TITOLO =====
        JLabel title = new JLabel("EFFETTUA L'ACCESSO", SwingConstants.CENTER);
        title.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 21));
        title.setForeground(Color.decode("#D9D9D9"));
        gbc.gridy = 0;
        panel.add(title, gbc);

        // ===== USERNAME (IDENTICA) =====
        JTextField username = new JTextField();
        username.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 17));
        username.setBackground(Color.decode("#B2B2B2"));
        username.setForeground(Color.decode("#656565"));
        username.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
        OnFocusEventHelper.setOnFocusText(
                username, "Username",
                Color.decode("#353535"),
                Color.decode("#656565")
        );
        gbc.gridy = 1;
        panel.add(username, gbc);

        // ===== PASSWORD (IDENTICA) =====
        JPasswordField password = new JPasswordField();
        password.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 17));
        password.setBackground(Color.decode("#B2B2B2"));
        password.setForeground(Color.decode("#656565"));
        password.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
        OnFocusEventHelper.setOnFocusText(
                password, "Password",
                Color.decode("#353535"),
                Color.decode("#656565")
        );
        gbc.gridy = 2;
        panel.add(password, gbc);

        // ===== LOGIN =====
        JButton login = new JButton("LOGIN");
        login.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
        login.setBackground(Color.decode("#2e2e2e"));
        login.setForeground(Color.decode("#D9D9D9"));
        login.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
        login.setFocusPainted(false);
        OnClickEventHelper.setOnClickColor(
                login,
                Color.decode("#232323"),
                Color.decode("#2e2e2e")
        );
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(login, gbc);

        centerWrapper.add(panel); // ← NON si stretchano

        root.add(centerWrapper, BorderLayout.CENTER);

        // ================= FOOTER (BASSO DESTRA) =================
        JPanel registerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
        registerPanel.setBackground(Color.decode("#1e1e1e"));

        JLabel registerLabel = new JLabel("Non hai un account?");
        registerLabel.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 13));
        registerLabel.setForeground(Color.decode("#D9D9D9"));

        JButton registerButton = new JButton("Registrati");
        registerButton.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 13));
        registerButton.setBackground(Color.decode("#2e2e2e"));
        registerButton.setForeground(Color.decode("#D9D9D9"));
        registerButton.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
        registerButton.setFocusPainted(false);
        OnClickEventHelper.setOnClickColor(
                registerButton,
                Color.decode("#232323"),
                Color.decode("#2e2e2e")
        );

        registerPanel.add(registerLabel);
        registerPanel.add(registerButton);

        root.add(registerPanel, BorderLayout.SOUTH);

        // ================= MOSTRA =================
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
