import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToggleDemo {
    JLabel label;
    JToggleButton jtbutton;

    ToggleDemo() {
        JFrame frame = new JFrame("Demonstrate a Toggle Button");

        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(290, 80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        label = new JLabel("Button is off");
        jtbutton = new JToggleButton("On/Off");

        jtbutton.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent itemEvent) {
                if (jtbutton.isSelected())
                    label.setText("Button is on");
                else
                    label.setText("Button is off");
            }
        });

        frame.getContentPane().add(jtbutton);
        frame.getContentPane().add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToggleDemo();
            }
        });
    }
}
