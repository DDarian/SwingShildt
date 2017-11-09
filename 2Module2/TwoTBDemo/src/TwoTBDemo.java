import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoTBDemo implements ItemListener {
    JLabel labelAlpha;
    JLabel labelBeta;
    JToggleButton jtbnAlpha;
    JToggleButton jtbnBeta;


    TwoTBDemo() {
        JFrame frame = new JFrame("Two Toggle Buttons");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setSize(290, 80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelAlpha = new JLabel("Alpha is off");
        labelBeta = new JLabel("Beta is off");
        jtbnAlpha = new JToggleButton("Alpha");
        jtbnBeta = new JToggleButton("Beta");
        jtbnAlpha.addItemListener(this);
        jtbnBeta.addItemListener(this);

        frame.add(jtbnAlpha);
        frame.add(labelAlpha);
        frame.add(jtbnBeta);
        frame.add(labelBeta);
    }

    public void itemStateChanged(ItemEvent itemEvent) {
        JToggleButton tb = (JToggleButton) itemEvent.getItem();
        if(tb == jtbnAlpha)
        if(tb.isSelected()) {
            labelAlpha.setText("Alpha is on");
        } else {
            labelAlpha.setText("Alpha is off");
        } else if (tb == jtbnBeta) {
            if(tb.isSelected())
                labelBeta.setText("Beta is on");
            else
                labelBeta.setText("Beta is off");
        }}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TwoTBDemo();
            }
        });
    }
    }

