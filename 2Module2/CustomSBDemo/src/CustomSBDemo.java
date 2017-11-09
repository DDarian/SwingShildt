import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CustomSBDemo {
    JLabel jlabVert;
    JLabel jlabHoriz;
    JLabel jlabVSBInfo;
    JLabel jlabHSBInfo;

    JScrollBar jsbVert;
    JScrollBar jsbHoriz;

    CustomSBDemo() {
        JFrame jfrm = new JFrame("Scroll Bars Properties");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(260, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setVisible(true);

        jlabVert = new JLabel("Value of vetical scroll bar: 0");
        jlabHoriz = new JLabel("Value of horizontal scroll ba: 250");


        jsbVert = new JScrollBar(JScrollBar.VERTICAL, 0, 5, 0, 500);
        jsbHoriz = new JScrollBar(Adjustable.HORIZONTAL, 250, 0, 0, 500);

        jsbVert.setPreferredSize(new Dimension(30, 200));
        jsbHoriz.setPreferredSize(new Dimension(200, 10));
        jsbHoriz.setBlockIncrement(25);

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
                jlabHoriz.setText("Value of horizontal scroll bar:" + e.getValue());
            }
        });

        jlabVSBInfo = new JLabel("<html>Vertical Scroll: <br>" +
        "Minimum value: " + jsbVert.getMinimum() + "<br>"+
        "Maximum value: " + jsbVert.getMaximum() + "<br>"+
        "Visible amount(extent): " + jsbVert.getBlockIncrement() + "<br>" +
        "Unit increment: " + jsbVert.getUnitIncrement());

        jlabHSBInfo = new JLabel("<html>Horizontal Scroll: <br>" +
                "Minimum value: " + jsbHoriz.getMinimum() + "<br>"+
                "Maximum value: " + jsbHoriz.getMaximum() + "<br>"+
                "Visible amount(extent): " + jsbHoriz.getBlockIncrement() + "<br>" +
                "Unit increment: " + jsbHoriz.getUnitIncrement());

        jfrm.add(jsbVert);
        jfrm.add(jsbHoriz);
        jfrm.add(jlabVert);
        jfrm.add(jlabHoriz);
        jfrm.add(jlabVSBInfo);
        jfrm.add(jlabHSBInfo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomSBDemo();
            }
        });
    }
}
