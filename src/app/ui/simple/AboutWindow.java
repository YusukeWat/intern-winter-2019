package app.ui.simple;

import app.App;

import javax.swing.*;
import java.awt.*;

/**
 * アプリのバージョン情報を表示するウィンドウ
 */
public class AboutWindow extends SimpleWindow {

    @Override
    protected void addComponent() {
        JLabel label = new JLabel(String.format("アプリのバージョン：%s", App.VERSION));
        // 文字列を中央に配置したいので、パネルの真ん中に一旦追加する
        JPanel panel = new JPanel();
        panel.add(label, BorderLayout.CENTER);

        getContentPane().add(panel, BorderLayout.CENTER);
    }
}
