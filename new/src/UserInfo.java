import javax.swing.*;
import java.awt.*;
public class UserInfo extends JFrame {
    public UserInfo() {
        setTitle("个人信息");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("姓名：xx" ));
        add(new JLabel("年龄：xx"));
        add(new JLabel("出生日期：xxxx/xx/xx"));
        add(new JLabel("个人喜好：..."));
        add(new JLabel("电话：..."));
    }
}


