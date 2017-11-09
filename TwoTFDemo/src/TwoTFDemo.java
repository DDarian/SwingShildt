import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class TwoTFDemo implements ActionListener {
    JTextField field1;
    JTextField field2;
    JLabel label;

    TwoTFDemo(){
        JFrame frame = new JFrame("Use Iwo Text Field");
        frame.setLayout(new FlowLayout());
        frame.setSize(240, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        field1 = new JTextField(10);
        field2 = new JTextField(10);

        field1.setActionCommand("One");
        field2.setActionCommand("Two");

        field1.addActionListener(this);
        field2.addActionListener(this);

        label = new JLabel("");

        frame.add(field1);
        frame.add(field2);
        frame.add(label);
        }

    public void actionPerformed(ActionEvent ex) {
        if (ex.getActionCommand().equals("One")) {
            label.setText("Enter pressed in textField1: " + field1.getText());
        } else {
            label.setText("Enter pressed in textFirld2: " + field2.getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TwoTFDemo();
            }
        });
    }
}
