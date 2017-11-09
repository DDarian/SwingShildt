import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class StopWatch implements ActionListener {
    JLabel label;
    long start;

    StopWatch() {
        JFrame frame = new JFrame("A simple StopWatch");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(230, 90);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        start.addActionListener(this);
        stop.addActionListener(this);
        frame.add(start);
        frame.add(stop);

        label = new JLabel("PressStart to being timing");
        frame.add(label);
    }

    public void actionPerformed(ActionEvent event) {
        Calendar cal = Calendar.getInstance();

        if (event.getActionCommand().equals("Start")) {
            start=cal.getTimeInMillis();
            label.setText("Stop watch Running");
        } else {
            label.setText("Elapsed time is " +
                    (double) (cal.getTimeInMillis() - start)/1000);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new StopWatch();
            }
        });
    }
}
