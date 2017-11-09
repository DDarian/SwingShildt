import javax.swing.*;

public class SwingDemo {
    SwingDemo() {
        JFrame frame = new JFrame("A Simple Swing Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);

        JLabel lab = new JLabel("Swing powers the modern Java Gui");
        frame.getContentPane().add(lab);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }
}
