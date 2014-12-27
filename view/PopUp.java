package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUp extends JFrame {

    JLabel label;

    public PopUp (String warning) {
        super("Warning!");
        setResizable(false);
        setLocationRelativeTo(null);
        init(warning);
        pack();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void init(String warning) {
        label = new JLabel();
        label.setText(warning);
        JPanel pane = new JPanel();
        getContentPane().add(pane);
        JButton ok = new JButton("OK");
        pane.add(label);
        pane.add(ok);
        ok.addActionListener(new OkActionListener());
    }

    private class OkActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }
}
