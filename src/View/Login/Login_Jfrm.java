package View.Login;

import Controller.Login_cntrl;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login_Jfrm extends JFrame {

    public static JFrame frmLoginPanel;
    public static Login_Jfrm window;
    private JTextField user;
    private JTextField passw;
    private JComboBox rol;
    private JToggleButton tglbtnNewToggleButton;

    /**
     * Create the application.
     */
    public Login_Jfrm() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
                    UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
                    // UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
                    window = new Login_Jfrm();
                    window.frmLoginPanel.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frmLoginPanel = new JFrame();
        frmLoginPanel.setSize(889, 602); // Set ukuran menjadi 889x602
        frmLoginPanel.setType(Type.POPUP);
        frmLoginPanel.setTitle("Welcome, Traveliki🦇");
        frmLoginPanel.setBounds(480, 250, 889, 602); // Set ukuran menjadi 889x602
        frmLoginPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLoginPanel.getContentPane().setLayout(null);
        frmLoginPanel.getContentPane().setBackground(Color.orange);

        // JLabel lblteks = new JLabel(
        //         "<html><center><font face='Poppins' color='white' size='6'><b>Selamat Datang di Aplikasi Traveliki🦇<br/>Kapanpun dan dimanapun bisa sakniki<br/>harga murah asal uang nya ada</b></font></center></html>");
        // lblteks.setBounds(50, 20, 600, 80); // Perbesar bounds agar teks sesuai
        // frmLoginPanel.getContentPane().add(lblteks);

        // user = new JTextField();

        // tambahkan image

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        frmLoginPanel.getContentPane().add(lblLogin, BorderLayout.CENTER);

        // frmLoginPanel.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(6, 6, 31));
        panel.setPreferredSize(new Dimension(600, 400)); // Mengatur ukuran pan

        add(panel);

        JLabel lblUsername = new JLabel("Username : ");
        lblUsername.setFont(new Font("Poppins", Font.BOLD, 16)); // Perbesar teks
        lblUsername.setBounds(41, 90, 120, 30); // Sesuaikan bounds agar lebih besar
        frmLoginPanel.getContentPane().add(lblUsername);

        user = new JTextField();
        user.setBounds(180, 90, 250, 30); // Perbesar ukuran dan sesuaikan posisi
        frmLoginPanel.getContentPane().add(user);
        user.setColumns(10);


        JLabel lblPassword = new JLabel("Password : ");
        lblPassword.setFont(new Font("Poppins", Font.BOLD, 16)); // Perbesar teks
        lblPassword.setBounds(41, 140, 120, 30); // Tempatkan di bawah Username
        frmLoginPanel.getContentPane().add(lblPassword);

        passw = new JPasswordField();
        passw.setColumns(10);
        passw.setBounds(180, 140, 250, 30); // Tempatkan di bawah Username
        frmLoginPanel.getContentPane().add(passw);

        // btnLogin
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (rol.getSelectedItem().toString().equals("Select")) {
                    JOptionPane.showMessageDialog(null, "Select Your Role");
                } else {
                    String un = user.getText();
                    String ps = passw.getText();
                    String role = rol.getSelectedItem().toString();
                    new Login_cntrl(un, ps, role);
                }
            }
        });
        btnLogin.setBounds(124, 198, 89, 25);
        frmLoginPanel.getContentPane().add(btnLogin);

        // btnReset
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Membersihkan field input
                user.setText("");
                passw.setText("");
                rol.setSelectedIndex(0); // Mengatur combo box ke pilihan default
            }
        });

        btnReset.setBounds(250, 198, 89, 25); // Mengatur posisi tombol reset
        frmLoginPanel.getContentPane().add(btnReset);

        rol = new JComboBox();
        rol.setModel(
                // new DefaultComboBoxModel(new String[] { "Select", "Employee", "Manager",
                // "Admin", "Super_Admin" }));
                new DefaultComboBoxModel(new String[] { "Select", "Employee", "Manager", "Admin", "Super_Admin" }));

        rol.setBounds(124, 145, 89, 20);
        frmLoginPanel.getContentPane().add(rol);

        JLabel lblRole = new JLabel("Role : ");
        lblRole.setBounds(41, 148, 42, 14);
        frmLoginPanel.getContentPane().add(lblRole);

        // Icon untuk field Username
        JLabel lblUsernameIcon = new JLabel();
        lblUsernameIcon.setIcon(new ImageIcon(Login_Jfrm.class.getResource("/resource/Vector.png")));
        lblUsernameIcon.setBounds(440, 90, 30, 30); // Sesuaikan posisinya
        frmLoginPanel.getContentPane().add(lblUsernameIcon);

        // icon password
        tglbtnNewToggleButton = new JToggleButton("");
        tglbtnNewToggleButton.setIcon(new ImageIcon(Login_Jfrm.class.getResource("/resource/eye.png")));
        tglbtnNewToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (tglbtnNewToggleButton.isSelected()) {
                    ((JPasswordField) passw).setEchoChar((char) 0);
                } else {
                    ((JPasswordField) passw).setEchoChar('*');
                }
            }
        });

        tglbtnNewToggleButton.setBounds(341, 135, 18, 14);
        frmLoginPanel.getContentPane().add(tglbtnNewToggleButton);

        JLabel lblNotRegisterYet = new JLabel("sudah Punya akun ? ");
        lblNotRegisterYet.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNotRegisterYet.setBounds(124, 236, 150, 20);
        frmLoginPanel.getContentPane().add(lblNotRegisterYet);

        JLabel lblRegisterHere = new JLabel("Daftar dulu sini !!!");
        lblRegisterHere.setForeground(new Color(0, 51, 153));
        lblNotRegisterYet.setBounds(124, 236, 150, 20);
        lblRegisterHere.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Login_REG Login_REG = new Login_REG();
                Login_REG.main(null);
            }

        });
        lblRegisterHere.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblRegisterHere.setBounds(295, 236, 150, 20); // Meningkatkan nilai x untuk menambah jarak
        frmLoginPanel.getContentPane().add(lblRegisterHere);

        JLabel lblImageBottom2 = new JLabel(new ImageIcon(Login_Jfrm.class.getResource("/resource/All.png")));
        lblImageBottom2.setBounds(0, 0, 889, 602); // Atur ukuran dan posisi sesuai kebutuhan
        frmLoginPanel.getContentPane().add(lblImageBottom2);

    }
}
