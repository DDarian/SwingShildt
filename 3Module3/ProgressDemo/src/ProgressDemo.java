import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ProgressDemo {
    JLabel jlabVert;
    JLabel jlabHoriz;

    JProgressBar jprogHoriz;
    JProgressBar jprogVert;

    JButton jbtn;

    ProgressDemo() {
        JFrame jfrm = new JFrame("Demonstrate Progress Bars");
        jfrm.getContentPane().setLayout(new FlowLayout());

        jfrm.setSize(280, 270);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setVisible(true);

        jprogVert = new JProgressBar(JProgressBar.VERTICAL);
        jprogHoriz = new JProgressBar(JProgressBar.HORIZONTAL);

        jprogHoriz.setStringPainted(true);
        jprogVert.setStringPainted(true);

        jbtn = new JButton("Push Me");

        jlabHoriz = new JLabel("Value of horizontal progress bar:" + jprogHoriz.getValue());
        jlabVert = new JLabel("Value of vertical progress bar: " + jprogVert.getValue());

        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hVal = jprogHoriz.getValue();
                int vVal = jprogVert.getValue();

                if (hVal >= jprogHoriz.getMaximum())
                    return;
                else
                    jprogHoriz.setValue(hVal + 10);

                if (vVal >= jprogVert.getMaximum())
                    return;
                else
                    jprogVert.setValue(hVal + 10);

                jlabHoriz.setText("Value of horizontal progress bar: " + jprogHoriz.getValue());
                jlabVert.setText("Value of vertical progress bar: " + jprogVert.getValue());
            }
        });

        jfrm.getContentPane().add(jprogHoriz);
        jfrm.add(jprogVert);
        jfrm.add(jlabHoriz);
        jfrm.add(jlabVert);
        jfrm.add(jbtn);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProgressDemo();
            }
        });
    }
}
