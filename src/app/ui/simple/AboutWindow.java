package app.ui.simple;

import app.Application;

import javax.swing.*;
import java.awt.*;

/**
 * アプリのバージョン情報を表示するウィンドウ
 */
class AboutWindow extends SimpleWindow {

    @Override
    protected final void addComponent() {
        JLabel label = new JLabel(String.format("アプリのバージョン：%s", Application.VERSION));
        // 文字列を中央に配置したいので、パネルの真ん中に一旦追加する
        JPanel panel = new JPanel();
        panel.add(label, BorderLayout.CENTER);

        getContentPane().add(panel, BorderLayout.CENTER);
    }
}
