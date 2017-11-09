import java.awt.*;
import javax.swing.*;

public class BorderDemo {
    BorderDemo() {
        JFrame frame = new JFrame ("Use Line and Etched Borders");
        frame.setLayout(new FlowLayout());
        frame.setSize(280, 90);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel label1 = new JLabel("This uses a line border");
        label1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel label2 = new JLabel("This uses an etched border");
        label2.setBorder(BorderFactory.createEtchedBorder());

        frame.add(label1);
        frame.add(label2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BorderDemo();
            }
        });
    }


}
