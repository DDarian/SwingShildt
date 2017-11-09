import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextFieldDemo implements ActionListener {
JTextField textField;
JLabel label;

    JTextFieldDemo() {
        JFrame frame = new JFrame("A Text Field Example");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(240, 90);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        textField = new JTextField(10);
        textField.addActionListener(this);

        label = new JLabel("");

        frame.getContentPane().add(textField);
        frame.getContentPane().add(label);
    }

    public void actionPerformed(ActionEvent event) {
        label.setText("Current text: " + textField.getText());
        textField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new JTextFieldDemo();
            }
        });
    }
}
