package app.ui.simple;

import app.App;

import javax.swing.*;
import java.awt.*;

public class AboutWindow extends SimpleWindow {

    private final JLabel mLabel = new JLabel(String.format("アプリのバージョン：%s", App.APP_VERSION));

    @Override
    protected void addComponent() {
        // 文字列を中央に配置したいので、パネルの真ん中に一旦追加する
        JPanel panel = new JPanel();
        panel.add(mLabel, BorderLayout.CENTER);

        getContentPane().add(panel, BorderLayout.CENTER);
    }
}
