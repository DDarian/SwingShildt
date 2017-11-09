import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class AlignLabelDemo {
    AlignLabelDemo() {
        JLabel[] labs = new JLabel[9];

        JFrame frame = new JFrame("Horizontal and Vertical Alignment");

        frame.getContentPane().setLayout(
                new GridLayout(3, 3, 4, 4));
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        labs[0] = new JLabel("Left, Top", SwingConstants.LEFT);
        labs[0].setVerticalAlignment(SwingConstants.TOP);
        labs[1] = new JLabel("Center, Top", SwingConstants.CENTER);
        labs[1].setVerticalAlignment(SwingConstants.TOP);
        labs[2] = new JLabel("Rigth, Top", SwingConstants.RIGHT);
        labs[2].setVerticalAlignment(SwingConstants.TOP);

        labs[3] = new JLabel("Left, Center", SwingConstants.LEFT);
        labs[4] = new JLabel("Center,Center", SwingConstants.CENTER);
        labs[5] = new JLabel("Right, Center", SwingConstants.RIGHT);

        labs[6] = new JLabel("Left,Bottom", SwingConstants.LEFT);
        labs[6].setVerticalAlignment(SwingConstants.BOTTOM);
        labs[7] = new JLabel("Center, Botton", SwingConstants.CENTER);
        labs[7].setVerticalAlignment(SwingConstants.BOTTOM);
        labs[8] = new JLabel("Right, Bottom", SwingConstants.RIGHT);
        labs[8].setVerticalAlignment(SwingConstants.BOTTOM);

        Border border = BorderFactory.createEtchedBorder();
        for (int i = 0; i < 9; i++) {
            labs[i].setBorder(border);
        }

        for (int i = 0; i < 9; i++) {
            frame.getContentPane().add(labs[i]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AlignLabelDemo();
            }
        });
    }
}
