import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class CoderJava implements ActionListener {

    JTextField jtfPlaintext;
    JTextField jtfCiphertext;

   CoderJava() {
        JFrame jfrm = new JFrame("A simple ode Mashine");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(340, 120);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setVisible(true);

        JLabel jlabPlaintext = new JLabel("Plain text: ");
        JLabel jlabCiphettext = new JLabel("Cipher text:");

        jtfPlaintext = new JTextField(20);
        jtfPlaintext.addActionListener(this);
        jtfCiphertext = new JTextField(20);
        jtfCiphertext.addActionListener(this);

        jfrm.add(jlabPlaintext);
        jfrm.add(jtfPlaintext);
        jfrm.add(jlabCiphettext);
        jfrm.add(jtfCiphertext);

        JButton jbtnEncode = new JButton("Encode");
        jbtnEncode.addActionListener(this);
        JButton jbtnDecode = new JButton("Decode");
        jbtnDecode.addActionListener(this);
        JButton jbtnReset = new JButton("Reset");
        jbtnReset.addActionListener(this);

        jfrm.add(jbtnEncode);
        jfrm.add(jbtnDecode);
        jfrm.add(jbtnReset);
    }

    public void actionPerformed(ActionEvent eventAction){
        if (eventAction.getActionCommand().equals("Encode")) {
            StringBuilder str = new StringBuilder(jtfPlaintext.getText());
            for (int i = 0; i < str.length(); i++) {
                str.setCharAt(i, (char) (str.charAt(i) + 1));
            }
            jtfCiphertext.setText(str.toString());
        } else if (eventAction.getActionCommand().equals("Decode")) {
            StringBuilder str = new StringBuilder(jtfCiphertext.getText());
            for (int i = 0; i < str.length() ; i++) {
                str.setCharAt(i, (char) (str.charAt(i) - 1));
                jtfPlaintext.setText(str.toString());
            }} else {
                jtfPlaintext.setText("");
                jtfCiphertext.setText("");
            }
        }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CoderJava();
            }
        });
    }
}
