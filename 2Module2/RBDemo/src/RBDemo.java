import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RBDemo implements ActionListener{
    JLabel labelOptions;
    JLabel labelWhat;
    JLabel labelChange;
    JCheckBox jcbOptions;
    JRadioButton jrbSpeed;
    JRadioButton jrbSize;
    JRadioButton jrbDebug;

    RBDemo() {
        JFrame frame = new JFrame("Demonstrate Dario Buttons");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        labelOptions = new JLabel("Choose Option:");
        labelWhat = new JLabel("Option selected: Speed");
        jcbOptions = new JCheckBox("Enable Options");
        jrbSpeed = new JRadioButton("Maximum Speed", true);
        jrbSize = new JRadioButton("Minimum Size");
        jrbDebug = new JRadioButton("Debug");

        ButtonGroup bg = new ButtonGroup();
        bg.add(jrbSize);
        bg.add(jrbSize);
        bg.add(jrbDebug);

        jrbSpeed.setEnabled(false);
        jrbSize.setEnabled(false);
        jrbDebug.setEnabled(false);

        jcbOptions.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(jcbOptions.isSelected()){
                    jrbSpeed.setEnabled(true);
                    jrbSize.setEnabled(true);
                    jrbDebug.setEnabled(true);
                } else {
                    jrbSpeed.setEnabled(false);
                    jrbSize.setEnabled(false);
                    jrbDebug.setEnabled(false);
                }
            }
        });

        jrbSize.addActionListener(this);
        jrbSpeed.addActionListener(this);
        jrbDebug.addActionListener(this);

        frame.getContentPane().add(jcbOptions);
        frame.getContentPane().add(labelOptions);
        frame.getContentPane().add(jrbSpeed);
        frame.getContentPane().add(jrbSize);
        frame.getContentPane().add(jrbDebug);
        frame.getContentPane().add(labelWhat);
    }

    public void actionnPerformed(ActionEvent actionEvent) {
        String opts = "";

    public void itemStateChanged(ItemEvent itemEvent) {
        String opts = "";

        JCheckBox cb = (JCheckBox) itemEvent.getItem();

        if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
            labelWhat.setText("Selected change: " + cb.getText() + " selected.");
        } else
            labelWhat.setText("Selection shange: " + cb.getText() + " cleared");

        if (jrbSpeed.isSelected()) opts = "Speed ";
        else if (jrbSize.isSelected()) opts = "Sieze";
        else opts = "Debug";

        labelWhat.setText("Option selected: " + opts);
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RBDemo();
            }
        });
    }
}


