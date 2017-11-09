import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonIcons implements ActionListener{

    JLabel label;
    JButton btnFirst;
    JButton btnSecond;

    ButtonIcons(){
        ImageIcon myIcon = new ImageIcon("cp1.jpg");
        ImageIcon myDisIcon = new ImageIcon("cp2.jpg");
        ImageIcon myROIcon = new ImageIcon("j1.jpg");
        ImageIcon myPIcon = new ImageIcon("j2.jpg");

        JFrame frame = new JFrame("Use Button Icons");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 250);


        label = new JLabel("Press a button");
        btnFirst = new JButton("First", myIcon);
        btnSecond = new JButton("Second", myROIcon);
//        JButton jbtn = new JButton("<html>Press<br>Me");

        btnFirst.setRolloverIcon(myROIcon);
        btnSecond.setRolloverIcon(myROIcon);
        btnFirst.setPressedIcon(myPIcon);
        btnSecond.setPressedIcon(myPIcon);
        btnFirst.setDisabledIcon(myDisIcon);
        btnSecond.setDisabledIcon(myDisIcon);
        frame.getRootPane().setDefaultButton(btnFirst);


        btnFirst.addActionListener(this);
        btnSecond.addActionListener(this);

        frame.getContentPane().add(label);
        frame.getContentPane().add(btnFirst);
        frame.getContentPane().add(btnSecond);
//        frame.getContentPane().add(jbtn);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("First")) {
            label.setText("First button wa pressed");
            if (btnSecond.isEnabled()) {
                label.setText("Second button is disabled");
                btnSecond.setEnabled(false);
            } else {
                label.setText("Second button is enabled");
                btnSecond.setEnabled(true);
            }
        } else {
            label.setText("Second button was pressed.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonIcons();
            }
        });
    }

}
