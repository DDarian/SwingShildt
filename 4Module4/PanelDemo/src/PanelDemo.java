import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelDemo {
JLabel jlab;
JButton jbtnAlpha;
JButton jbtnBeta;

    PanelDemo() {
        JFrame jfrm = new JFrame("Use Two JPanel");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(210, 210);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setVisible(true);

        JPanel jpnl = new JPanel();
        jpnl.setPreferredSize(new Dimension(100, 100));
        jpnl.setOpaque(true);
        jpnl.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JPanel jpnl2 = new JPanel();
        jpnl2.setPreferredSize(new Dimension(100, 60));
        jpnl.setOpaque(true);
        jpnl2.setBorder(BorderFactory.createLineBorder(Color.RED));

        jlab = new JLabel("Press a button");
        jbtnAlpha = new JButton("Alpha");
        jbtnBeta = new JButton("Beta");

        jbtnAlpha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlab.setText("Alpha pressed");
            }
        });

        jbtnBeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlab.setText("Beta pressed");
            }
        });

        jpnl.add(jbtnAlpha);
        jpnl.add(jbtnBeta);
        jpnl.add(jlab);

        jpnl2.add(new JLabel("One"));
        jpnl2.add(new JLabel("Two"));
        jpnl2.add(new JLabel("Three"));

        jfrm.add(jpnl);
        jfrm.add(jpnl2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PanelDemo();
            }
        });
    }
}
