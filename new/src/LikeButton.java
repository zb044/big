import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LikeButton extends JButton implements ActionListener {
    private boolean isLiked;
    public LikeButton() {
        super("点赞");
        addActionListener(this);
        isLiked = false;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isLiked) {
            setText("点赞");
            isLiked = false;
        } else {
            setText("已点赞");
            isLiked = true;
        }
    }
}
