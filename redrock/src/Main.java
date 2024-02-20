import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main extends JFrame implements ActionListener {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    public Main() {
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("登录");

        setLayout(new FlowLayout());

        add(new JLabel("学号："));
        add(usernameField);
        add(new JLabel("密码："));
        add(passwordField);
        add(loginButton);

        loginButton.addActionListener(this);

        setTitle("登录界面");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            Class<?> courseFrameClass = checkCredentials(username, password);
            if (courseFrameClass != null) {
                try {
                    TimetableFrame courseFrame = (TimetableFrame) courseFrameClass.newInstance();
                    courseFrame.setVisible(true);
                } catch (InstantiationException | IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "学号或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private Class<?> checkCredentials(String username, String password) {
        java.util.List<String> validUsernames = new ArrayList<>();
        List<String> validPasswords = new ArrayList<>();
        List<String> courseFrameClasses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    validUsernames.add(parts[0]);
                    validPasswords.add(parts[1]);
                    courseFrameClasses.add(parts[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int index = validUsernames.indexOf(username);
        if (index != -1 && validPasswords.get(index).equals(password)) {
            try {
                return Class.forName(courseFrameClasses.get(index));
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}



