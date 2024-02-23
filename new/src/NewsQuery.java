import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class NewsQuery extends JFrame {
    private final JTextField titleField;
    public NewsQuery() {
        setTitle("新闻查询");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        titleField = new JTextField(20);
        JButton searchButton = new JButton("搜索");
        JButton userInfoButton = new JButton("个人信息");

        add(new JLabel("新闻标题："));
        add(titleField);
        add(searchButton);
        add(userInfoButton);

        userInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserInfo userInfo = new UserInfo();
                userInfo.setVisible(true);
                dispose();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                NewsDetail newsDetail = new NewsDetail(title);
                newsDetail.setVisible(true);
                dispose();
            }
        });
    }
    public static void main(String[] args) {
        NewsQuery newsQuery = new NewsQuery();
        newsQuery.setVisible(true);
    }
}
class NewsDetail extends JFrame {
    private final String title;
    private int likeCount;
    private static final Map<String, String> newsMap = new HashMap<>();

    static {
        newsMap.put("如果地球消失五十立方米的空间，消失哪个地方影响会最大？", "不知道");
        newsMap.put("藩属国到底属于中国还是属于外国？", "不知道");
    }
    public NewsDetail(String title) {
        this.title = title;
        likeCount = 0;

        setTitle("新闻详情");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea contentArea = new JTextArea();
        contentArea.setText(newsMap.getOrDefault(title, "未找到对应的新闻内容"));
        contentArea.setEditable(false);
        add(contentArea, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton likeButton = new JButton("点赞");
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                likeCount++;
                likeButton.setText("点赞(" + likeCount + ")");
            }
        });
        buttonPanel.add(likeButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
    @Override
    public String getTitle() {
        return title;
    }
}