import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonDemo implements ActionListener {
    JLabel lab;

    ButtonDemo() {
        JFrame frame = new JFrame("A Button Example");
        frame.setLayout(new FlowLayout());
        frame.setSize(220, 90);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton first = new JButton("First");
        JButton second = new JButton("Second");
        first.addActionListener(this);
        second.addActionListener(this);

        frame.getContentPane().add(first);
        frame.getContentPane().add(second);

        lab = new JLabel("Press a button");
        frame.getContentPane().add(lab);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("First")) {
            lab.setText("First button pressed");
        } else {
            lab.setText("Second button pressed");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ButtonDemo();
            }
        });
    }
}
