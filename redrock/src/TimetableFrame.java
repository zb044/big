import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class TimetableFrame extends JFrame {
    private String[] columnNames = {"周一", "周二", "周三", "周四", "周五","周六","周日"};
    private Object[][] data = {
            {"英语听说5602", "", "高等数学3204", "英语读写4414", "c语言3406", "", ""},
            {"c语言A403", "中国近代史2116", "商务英语5405", "中国近代史2116", "", "", ""},
            {"高等数学3303语文", "形势与政策3301", "大学体育太极运动场", "英语听说5602", "", "", ""},
            {"", "c语言3406", "", "高等数学3204", "大学生规划2216", "", ""},
            {"英语读写4414", "", "军事理论3506", "新生研讨课3502", "", "", ""}
    };
    public TimetableFrame() {
        setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);

        table.setRowHeight(30);
        table.setGridColor(Color.BLACK);
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setTitle("课表                 (附加:每节课100分钟)");
        setSize(800, 210);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}