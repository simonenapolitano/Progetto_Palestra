package main;

import javax.swing.*;

import database.DatabaseConnection;

import java.awt.*;
import helper_classes.*;

public class GUI extends JFrame {

        private static final String APP_ICON_CLASSPATH = "/resources/icons/32.png";
        private static final String APP_ICON_FILEPATH = "./resources/icons/32.png";
        private CardLayout cardLayout;
        private JPanel root;

        public GUI() {
                // ================= FRAME =================
                setTitle("PALESTRA");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(660, 357);
                setMinimumSize(new Dimension(500, 300));
                setLocationRelativeTo(null);

                // ================= ICONA =================
                java.net.URL iconUrl = GUI.class.getResource("/icons/32.png");
                if (iconUrl != null) {
                        setIconImage(new ImageIcon(iconUrl).getImage());
                } else {
                        System.err.println("Icona non trovata!");
                }

                // ================= ROOT (CARDLAYOUT) =================
                cardLayout = new CardLayout();
                root = new JPanel(cardLayout);
                setContentPane(root);

                // ================= PANNELLI =================
                JPanel loginPanel = createLoginPanel();
                JPanel registerPanel = createRegisterPanel();

                root.add(loginPanel, "login");
                root.add(registerPanel, "register");

                cardLayout.show(root, "login");

                // ================= MOSTRA =================
                setVisible(true);
        }

        private JPanel createLoginPanel() {
                JPanel rootPanel = new JPanel(new BorderLayout());
                rootPanel.setBackground(Color.decode("#1e1e1e"));

                JPanel centerWrapper = new JPanel(new GridBagLayout());
                centerWrapper.setBackground(Color.decode("#1e1e1e"));

                JPanel panel = new JPanel(new GridBagLayout());
                panel.setBackground(Color.decode("#1e1e1e"));

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.insets = new Insets(10, 20, 10, 20);
                gbc.weightx = 1;

                JLabel title = new JLabel("EFFETTUA L'ACCESSO", SwingConstants.CENTER);
                title.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 21));
                title.setForeground(Color.decode("#D9D9D9"));
                gbc.gridy = 0;
                panel.add(title, gbc);

                JTextField username = new JTextField();
                username.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 17));
                username.setBackground(Color.decode("#B2B2B2"));
                username.setForeground(Color.decode("#656565"));
                username.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
                OnFocusEventHelper.setOnFocusText(
                                username, "Username",
                                Color.decode("#353535"),
                                Color.decode("#656565"));
                gbc.gridy = 1;
                panel.add(username, gbc);

                JPasswordField password = new JPasswordField();
                password.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 17));
                password.setBackground(Color.decode("#B2B2B2"));
                password.setForeground(Color.decode("#656565"));
                password.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
                OnFocusEventHelper.setOnFocusText(
                                password, "Password",
                                Color.decode("#353535"),
                                Color.decode("#656565"));
                gbc.gridy = 2;
                panel.add(password, gbc);

                JButton login = new JButton("LOGIN");
                login.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
                login.setBackground(Color.decode("#2e2e2e"));
                login.setForeground(Color.decode("#D9D9D9"));
                login.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
                login.setFocusPainted(false);
                login.addActionListener(e -> {
                        if (DatabaseConnection.passwordCheck(username.getText(), new String(password.getPassword()))) {
                                System.out.println("Login successo");
                        }
                });
                gbc.gridy = 3;
                gbc.fill = GridBagConstraints.NONE;
                gbc.anchor = GridBagConstraints.CENTER;
                panel.add(login, gbc);

                centerWrapper.add(panel);
                rootPanel.add(centerWrapper, BorderLayout.CENTER);

                // ===== FOOTER =====
                JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
                footer.setBackground(Color.decode("#1e1e1e"));

                JLabel registerLabel = new JLabel("Non hai un account?");
                registerLabel.setForeground(Color.decode("#D9D9D9"));

                JButton registerButton = new JButton("Registrati");
                registerButton.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
                registerButton.setBackground(Color.decode("#2e2e2e"));
                registerButton.setForeground(Color.decode("#D9D9D9"));
                registerButton.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
                registerButton.setFocusPainted(false);
                registerButton.addActionListener(e -> {
                        if (DatabaseConnection.passwordCheck(username.getText(), new String(password.getPassword()))) {
                                System.out.println("Login successo");
                        }
                });
                gbc.gridy = 3;
                gbc.fill = GridBagConstraints.NONE;
                gbc.anchor = GridBagConstraints.CENTER;
                registerButton.addActionListener(e -> cardLayout.show(root, "register"));

                footer.add(registerLabel);
                footer.add(registerButton);

                rootPanel.add(footer, BorderLayout.SOUTH);

                return rootPanel;
        }

        private JPanel createRegisterPanel() {
                JPanel rootPanel = new JPanel(new BorderLayout());
                rootPanel.setBackground(Color.decode("#1e1e1e"));

                JPanel centerWrapper = new JPanel(new GridBagLayout());
                centerWrapper.setBackground(Color.decode("#1e1e1e"));

                JPanel panel = new JPanel(new GridBagLayout());
                panel.setBackground(Color.decode("#1e1e1e"));

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.insets = new Insets(10, 20, 10, 20);
                gbc.weightx = 1;

                JLabel title = new JLabel("EFFETTUA LA REGISTRAZIONE", SwingConstants.CENTER);
                title.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 21));
                title.setForeground(Color.decode("#D9D9D9"));
                gbc.gridy = 0;
                panel.add(title, gbc);

                JTextField username = new JTextField();
                username.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 17));
                username.setBackground(Color.decode("#B2B2B2"));
                username.setForeground(Color.decode("#656565"));
                username.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
                OnFocusEventHelper.setOnFocusText(
                                username, "Username",
                                Color.decode("#353535"),
                                Color.decode("#656565"));
                gbc.gridy = 1;
                panel.add(username, gbc);

                JPasswordField password = new JPasswordField();
                password.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 17));
                password.setBackground(Color.decode("#B2B2B2"));
                password.setForeground(Color.decode("#656565"));
                password.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
                OnFocusEventHelper.setOnFocusText(
                                password, "Password",
                                Color.decode("#353535"),
                                Color.decode("#656565"));
                gbc.gridy = 2;
                panel.add(password, gbc);

                JButton registrati = new JButton("REGISTRATI");
                registrati.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
                registrati.setBackground(Color.decode("#2e2e2e"));
                registrati.setForeground(Color.decode("#D9D9D9"));
                registrati.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
                registrati.setFocusPainted(false);
                gbc.gridy = 3;
                gbc.fill = GridBagConstraints.NONE;
                gbc.anchor = GridBagConstraints.CENTER;
                panel.add(registrati, gbc);

                centerWrapper.add(panel);
                rootPanel.add(centerWrapper, BorderLayout.CENTER);

                // ===== FOOTER =====
                JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
                footer.setBackground(Color.decode("#1e1e1e"));

                JLabel registerLabel = new JLabel("Hai gia un account?");
                registerLabel.setForeground(Color.decode("#D9D9D9"));

                JButton loginButton = new JButton("Login");
                loginButton.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
                loginButton.setBackground(Color.decode("#2e2e2e"));
                loginButton.setForeground(Color.decode("#D9D9D9"));
                loginButton.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
                loginButton.setFocusPainted(false);
                gbc.gridy = 3;
                gbc.fill = GridBagConstraints.NONE;
                gbc.anchor = GridBagConstraints.CENTER;
                loginButton.addActionListener(e -> cardLayout.show(root, "login"));

                footer.add(registerLabel);
                footer.add(loginButton);

                rootPanel.add(footer, BorderLayout.SOUTH);

                return rootPanel;
        }

        public static void main(String[] args) {
                new GUI();
        }
}
