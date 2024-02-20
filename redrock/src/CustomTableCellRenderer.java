import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value != null) {
            String course = value.toString();
            switch (course) {
                case "英语听说5602":
                    component.setForeground(Color.RED);
                    break;
                case "高等数学3204":
                    component.setForeground(Color.GREEN);
                    break;
                case "英语读写4414":
                    component.setForeground(Color.BLUE);
                    break;
                case "c语言3406":
                    component.setForeground(Color.ORANGE);
                    break;
                case "c语言A403":
                    component.setForeground(Color.MAGENTA);
                    break;
                case "中国近代史2116":
                    component.setForeground(Color.CYAN);
                    break;
                case "商务英语5405":
                    component.setForeground(Color.PINK);
                    break;
                default:
                    component.setForeground(Color.BLACK);
                    break;
            }
        }
        return component;
    }
}
