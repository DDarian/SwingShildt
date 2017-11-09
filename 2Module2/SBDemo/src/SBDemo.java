import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SBDemo {
    JLabel jlabVert;
    JLabel jlabHoriz;
    JLabel jlabSBInfo;

    JScrollBar jsbVert;
    JScrollBar jsbHoriz;

    SBDemo() {
        JFrame jfrm = new JFrame("demonstrate Scroll Bars");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(260, 260);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setVisible(true);

        jlabVert = new JLabel("Value of vertical scroll bar: 0");
        jlabHoriz = new JLabel("Value of horizontal scroll bar: 0");
        jsbVert = new JScrollBar();
        jsbHoriz = new JScrollBar(Adjustable.HORIZONTAL);

        jsbVert.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if(jsbVert.getValueIsAdjusting()) return;
                jlabVert.setText("Value of vertical scroll bar: " + e.getValue());
            }
        });

        jsbHoriz.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                jlabHoriz.setText("value of horizontal scroll bar: " + e.getValue());
            }
        });

        jlabSBInfo = new JLabel("<html>Scroll bar Default<br>+" +
                "Minimum value: " + jsbVert.getMinimum() + "<br>" +
                "Maximum value: " + jsbVert.getMaximum() + "<br>" +
                "Visible amount(extent): " + jsbVert.getVisibleAmount() + "<br>" +
                "Block increment: " + jsbVert.getBlockIncrement() + "<br>" +
                "Ubit increment: " + jsbVert.getUnitIncrement());

        jfrm.add(jsbVert);
        jfrm.add(jsbHoriz);
        jfrm.add(jlabVert);
        jfrm.add(jlabHoriz);
        jfrm.add(jlabSBInfo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SBDemo();
            }
        });
    }
}
