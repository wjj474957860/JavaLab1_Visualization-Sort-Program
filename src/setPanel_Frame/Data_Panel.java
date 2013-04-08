
package setPanel_Frame;

import java.awt.*;
import javax.swing.*;
import MySort.*;

public class Data_Panel extends JPanel {

    public void setASort(BaseSort ms) {
        this.ms = ms;
        repaint();
    }

    private BaseSort ms;

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g.clearRect(0, 0, getWidth(), getHeight());

        g2d.setFont(new Font("", Font.BOLD, 40));

        int y = 0, x = 50;

        if (ms != null) {
            for (int i = 0; i < ms.getLength(); i++) {
                g2d.drawString("" + ms.Probe(i), x, y += 60);
            }
        }
    }
}
