import javax.swing.*;
import  java.awt.*;

public class IconLabelDemo {

    IconLabelDemo(){
        JFrame frame = new JFrame("Use Images in Labels");
        frame.getContentPane().setLayout(new GridLayout(4, 1));
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ImageIcon myIcon = new ImageIcon("cp1.jpg");

        JLabel labIcon = new JLabel(myIcon);
        JLabel labIconTxt1 = new JLabel("Default Icon and Text Position",
                myIcon, SwingConstants.CENTER);

        JLabel labIconTxt2 = new JLabel("Text Left of Icon",
                myIcon, SwingConstants.CENTER);

        labIconTxt2.setHorizontalTextPosition(SwingConstants.LEFT);

        JLabel labIconTxt3 = new JLabel("Text Over Icon",
                myIcon, SwingConstants.CENTER);
        labIconTxt3.setVerticalTextPosition(SwingConstants.TOP);
        labIconTxt3.setHorizontalTextPosition(SwingConstants.CENTER);

        frame.getContentPane().add(labIcon);
        frame.getContentPane().add(labIconTxt1);
        frame.getContentPane().add(labIconTxt2);
        frame.getContentPane().add(labIconTxt3);
        }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new IconLabelDemo();
            }
        });
    }
}
