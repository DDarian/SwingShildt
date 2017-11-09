import javax.swing.*;
import java.awt.*;


public class DisableLabelemo {
    DisableLabelemo() {
        JFrame frame = new JFrame("Use Images in Labels");
        frame.getContentPane().setLayout(new GridLayout(3, 1));
        frame.setVisible(true);
        frame.setSize(240, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon myIcon = new ImageIcon("cp1.jpg");
        ImageIcon myDisIcon = new ImageIcon("cp2.jpg");

        JLabel labIconTxt = new JLabel("This label is enabled",
                myIcon, SwingConstants.CENTER);

        JLabel labIconTxt2 = new JLabel("This label is disabled",
                myIcon, SwingConstants.CENTER);
        labIconTxt2.setEnabled(false);

        JLabel labIconTxt3 = new JLabel("Use the disable icon",
                myIcon, SwingConstants.CENTER);

        labIconTxt3.setDisabledIcon(myDisIcon);

        labIconTxt3.setEnabled(false);

        frame.getContentPane().add(labIconTxt);
        frame.getContentPane().add(labIconTxt2);
        frame.getContentPane().add(labIconTxt3);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DisableLabelemo();
            }
        });
    }
}


