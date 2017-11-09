import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MnemDemo {
    MnemDemo() {
        JFrame frame = new JFrame("Demonstrate Mnemics");

        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(260, 140);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel label1 = new JLabel("Email Address");
        JLabel label2 = new JLabel("Name");
        label1.setDisplayedMnemonic('e');
        label2.setDisplayedMnemonic('n');

        JTextField textField1 = new JTextField(20);
        JTextField textField2 = new JTextField(20);

        label1.setLabelFor(textField1);
        label2.setLabelFor(textField2);
        textField1.setActionCommand("textField1");
        textField2.setActionCommand("textField2");

        frame.getContentPane().add(label1);
        frame.getContentPane().add(textField1);
        frame.getContentPane().add(label2);
        frame.getContentPane().add(textField2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MnemDemo();
            }
        });
    }
}
