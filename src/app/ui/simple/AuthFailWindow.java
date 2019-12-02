package app.ui.simple;

import javax.swing.*;
import java.awt.*;

public class AuthFailWindow extends SimpleWindow {
    @Override
    protected void addComponent() {
        JLabel label = new JLabel("認証失敗");
        JButton button = new JButton("OK");
        button.addActionListener(actionEvent -> setVisible(false));

        add(label, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }
}