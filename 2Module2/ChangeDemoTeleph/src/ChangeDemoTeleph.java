import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChangeDemoTeleph {
    JTextField jtfName;
    JTextField jtfNumber;

    JRadioButton jrbExact;
    JRadioButton jrbStartWith;
    JRadioButton jrbEndsWith;

    JCheckBox jcbIgnoreCasese;

    String[][] phoneList = {
            {"John", "555-8765"},
            {"Jessica", "555-5643"},
            {"Adam", "555-1212"},
            {"Rachel", "555-3435"},
            {"Tom & Jerry", "555-1001"}
    };

    ChangeDemoTeleph() {
        JFrame jfrm = new JFrame("A simple phone Liist");
        jfrm.setSize(240, 220);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setVisible(true);

        JLabel jlabName = new JLabel("Name");
        JLabel jlabNumber = new JLabel("Number");
        JLabel jlabOptions = new JLabel("Search Options");

        jtfName = new JTextField(10);
        jtfNumber = new JTextField(10);

        jcbIgnoreCasese = new JCheckBox("IgnoreCase");
        jrbExact = new JRadioButton("Exact Match", true);
        jrbStartWith = new JRadioButton("Start With");
        jrbEndsWith = new JRadioButton("Ends With");

        ButtonGroup bg = new ButtonGroup();
        bg.add(jrbEndsWith);
        bg.add(jrbStartWith);
        bg.add(jrbEndsWith);

        jtfName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtfNumber.setText(lookupName(jtfName.getText()));
            }
        });

        jtfNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtfName.setText(lookupNumber(jtfNumber.getText()));
            }
        });

        jfrm.add(jlabName);
        jfrm.add(jtfName);
        jfrm.add(jlabNumber);
        jfrm.add(jtfNumber);
        jfrm.add(new JLabel());
        jfrm.add(jlabOptions);
        jfrm.add(jcbIgnoreCasese);
        jfrm.add(new JLabel());
        jfrm.add(jrbEndsWith);
        jfrm.add(jrbStartWith);
        jfrm.add(jrbEndsWith);
    }


    public String lookupName(String n) {
        for (int i = 0; i < phoneList.length; i++) {
            if (jrbStartWith.isSelected()) {
                if (jcbIgnoreCasese.isSelected()) {
                    if (phoneList[i][0].toLowerCase().
                            startsWith(n.toLowerCase()))
                        return phoneList[i][1];
                } else {
                    if (phoneList[i][0].startsWith(n))
                        return phoneList[i][1];
                    }
                }
                else if (jrbEndsWith.isSelected()) {
                    if (jcbIgnoreCasese.isSelected()) {
                        if (phoneList[i][0].toLowerCase().endsWith(n.toLowerCase()))
                            return phoneList[i][1];
                    } else {
                        if (phoneList[i][0].endsWith(n))
                            return phoneList[i][1];
                    }
                } else {
                    if (jcbIgnoreCasese.isSelected()) {
                        if (phoneList[i][0].toLowerCase().equals(n.toLowerCase()))
                            return phoneList[i][1];
                    } else {
                        if (phoneList[i][0].equals(n))
                            return phoneList[i][1];
                    }
                }
            }

            return "Not Found";
        }

    public String lookupNumber(String n) {
        for (int i = 0; i < phoneList.length; i++) {
            if (phoneList[i][1].equals(n))
                return phoneList[i][0];
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChangeDemoTeleph();
            }
        });
    }
}

