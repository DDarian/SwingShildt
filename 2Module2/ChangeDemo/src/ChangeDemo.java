import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ChangeDemo {

    JButton jbutton;
    JLabel jlabel;

    ChangeDemo(){
        JFrame frame = new JFrame("Button Change Events");

        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(250, 160);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        jlabel = new JLabel();
        jbutton = new JButton("Press fo Change Event Text");
        jbutton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel mod = jbutton.getModel();
                String what = "";
                if (mod.isEnabled()) what +="Enabled<br>";
                if (mod.isRollover()) what += "Rollover<br>";
                if(mod.isArmed()) what += "Armed<br>";
                if(mod.isPressed()) what += "Pressed<br>";

                jlabel.setText("<html>Current state:<br>" + what);
            }
        });

        frame.getContentPane().add(jbutton);
        frame.getContentPane().add(jlabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChangeDemo();
            }
        });
    }
}
