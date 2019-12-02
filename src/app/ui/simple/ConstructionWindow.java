package app.ui.simple;

import javax.swing.*;
import java.awt.*;

/**
 * 準備中の機能をマスクするために表示するウィンドウ
 */
public class ConstructionWindow extends SimpleWindow {
    @Override
    protected void addComponent() {
        JLabel label = new JLabel("この機能は準備中です...");
        JButton button = new JButton("OK");
        button.addActionListener(actionEvent -> setVisible(false));

        add(label, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }
}
